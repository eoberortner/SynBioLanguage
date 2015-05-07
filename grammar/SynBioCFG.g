grammar SynBioCFG;

options {
language=Java;
output=AST;
}

tokens {
	ALTERNATIVE 	= '|';
	ARROW 		= '-->';
	DOT		= '.';
}


@header {
package gov.lbl.jgi.grammar.parser;

import gov.lbl.jgi.grammar.dom.*;
}

@lexer::header {
package gov.lbl.jgi.grammar.parser;
}

@members {

/*---------------------------------------------------------------------
 * MEMBER VARIABLES
 *---------------------------------------------------------------------*/

final SymbolTables symbols = SymbolTables.instantiate();
public ParsingPhases PARSING_PHASE;

public enum ParsingPhases {
    COLLECT_NONTERMINALS, COLLECT_PRODUCTION_RULES
}

/*---------------------------------------------------------------------
 * METHODS FOR ERROR REPORTING
 *---------------------------------------------------------------------*/
private static final String NL = System.getProperty("line.separator");

final boolean DEBUG_MODE = true;
public void printDebug(Object message) {
    if (DEBUG_MODE) {
        int line = input.LT(-1).getLine();
        System.err.println("@Debug Line " + line + ": " + message);
    }
}

public void printError(Object message) {
    int line = input.LT(-1).getLine();
    int pos = input.LT(-1).getCharPositionInLine();
    
    StringBuilder sb = new StringBuilder();
    sb.append("@Error!").append(NL);
    sb.append("Line ").append(line).append(" Position ").append(pos).append(NL);
    sb.append(message).append(NL);
    
    throw new IllegalArgumentException(sb.toString());
}

@Override
public void reportError(RecognitionException re) {
    printError(
        this.getErrorMessage(re, this.getTokenNames()));
}
}


prog 
	returns[Grammar grammar]
	:	(productionRule)* {
if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
    $grammar = new Grammar(
                    this.symbols.getProductionRules(), 
                    this.symbols.getStartSymbol());
}	
	}	EOF
	;

productionRule
	:	nt=lhs {
if(this.PARSING_PHASE == ParsingPhases.COLLECT_NONTERMINALS) {
    this.symbols.put($nt.nt);
}	
	}	ARROW los=rhs {
if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	

    List<List<Symbol>> rhsAlternatives = $los.rhsAlternatives;
    
    for(List<Symbol> alternative : rhsAlternatives) {
        this.symbols.put($nt.nt, alternative);	
    }
}
	}	DOT
	;

lhs	
	returns [Nonterminal nt]
	:	ID	{
$nt = new Nonterminal($ID.text);	
	}
	;

rhs	
	returns [List<List<Symbol>> rhsAlternatives]
@init {
$rhsAlternatives = new ArrayList<List<Symbol>>();
}	
	:	alt=rhs_alternative {
if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
    $rhsAlternatives.add(
        $alt.rhsSymbols);	
}
	}	
		(ALTERNATIVE r=rhs_alternative {
if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
    $rhsAlternatives.add(
                $r.rhsSymbols);
}	
	}	)*
	;

rhs_alternative
	returns[List<Symbol> rhsSymbols]	
@init {
$rhsSymbols = new ArrayList<Symbol>();
}	
	:	(ID {
if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
    $rhsSymbols.add(
        this.symbols.get($ID.text));	
}
	}	)+	
	;
	

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
