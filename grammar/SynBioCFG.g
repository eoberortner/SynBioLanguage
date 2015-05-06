grammar SynBioCFG;

options {
language=Java;
output=AST;
}

tokens {
	ALTERNATIVE 	= '|';
	ARROW 		= '-->';
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
	:	(productionRule)* EOF
	;

productionRule
	:	lhs ARROW rhs
	;

lhs	:	ID	
	;

rhs	:	ID rhs
	|	ID ALTERNATIVE rhs
	|
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
