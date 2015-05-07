// $ANTLR 3.5.1 /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g 2015-05-06 21:34:09

package gov.lbl.jgi.grammar.parser;

import gov.lbl.jgi.grammar.dom.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class SynBioCFGParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALTERNATIVE", "ARROW", "CHAR", 
		"COMMENT", "ESC_SEQ", "HEX_DIGIT", "ID", "OCTAL_ESC", "STRING", "UNICODE_ESC", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ALTERNATIVE=4;
	public static final int ARROW=5;
	public static final int CHAR=6;
	public static final int COMMENT=7;
	public static final int ESC_SEQ=8;
	public static final int HEX_DIGIT=9;
	public static final int ID=10;
	public static final int OCTAL_ESC=11;
	public static final int STRING=12;
	public static final int UNICODE_ESC=13;
	public static final int WS=14;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SynBioCFGParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SynBioCFGParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return SynBioCFGParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g"; }



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


	public static class prog_return extends ParserRuleReturnScope {
		public Grammar grammar;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:70:1: prog returns [Grammar grammar] : ( productionRule )* EOF ;
	public final SynBioCFGParser.prog_return prog() throws RecognitionException {
		SynBioCFGParser.prog_return retval = new SynBioCFGParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope productionRule1 =null;

		Object EOF2_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:72:2: ( ( productionRule )* EOF )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:72:4: ( productionRule )* EOF
			{
			root_0 = (Object)adaptor.nil();


			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:72:4: ( productionRule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:72:5: productionRule
					{
					pushFollow(FOLLOW_productionRule_in_prog79);
					productionRule1=productionRule();
					state._fsp--;

					adaptor.addChild(root_0, productionRule1.getTree());

					}
					break;

				default :
					break loop1;
				}
			}


			if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
			    retval.grammar = new Grammar(
			                    this.symbols.getProductionRules(), 
			                    this.symbols.getStartSymbol());
			}	
				
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog85); 
			EOF2_tree = (Object)adaptor.create(EOF2);
			adaptor.addChild(root_0, EOF2_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prog"


	public static class productionRule_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "productionRule"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:81:1: productionRule : nt= lhs ARROW los= rhs ;
	public final SynBioCFGParser.productionRule_return productionRule() throws RecognitionException {
		SynBioCFGParser.productionRule_return retval = new SynBioCFGParser.productionRule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ARROW3=null;
		ParserRuleReturnScope nt =null;
		ParserRuleReturnScope los =null;

		Object ARROW3_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:82:2: (nt= lhs ARROW los= rhs )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:82:4: nt= lhs ARROW los= rhs
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_lhs_in_productionRule98);
			nt=lhs();
			state._fsp--;

			adaptor.addChild(root_0, nt.getTree());


			if(this.PARSING_PHASE == ParsingPhases.COLLECT_NONTERMINALS) {
			    this.symbols.put((nt!=null?((SynBioCFGParser.lhs_return)nt).nt:null));
			}	
				
			ARROW3=(Token)match(input,ARROW,FOLLOW_ARROW_in_productionRule102); 
			ARROW3_tree = (Object)adaptor.create(ARROW3);
			adaptor.addChild(root_0, ARROW3_tree);

			pushFollow(FOLLOW_rhs_in_productionRule106);
			los=rhs();
			state._fsp--;

			adaptor.addChild(root_0, los.getTree());


			if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
			    this.symbols.put((nt!=null?((SynBioCFGParser.lhs_return)nt).nt:null), (los!=null?((SynBioCFGParser.rhs_return)los).rhsSymbols:null));	
			}
				
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "productionRule"


	public static class lhs_return extends ParserRuleReturnScope {
		public Nonterminal nt;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lhs"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:93:1: lhs returns [Nonterminal nt] : ID ;
	public final SynBioCFGParser.lhs_return lhs() throws RecognitionException {
		SynBioCFGParser.lhs_return retval = new SynBioCFGParser.lhs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID4=null;

		Object ID4_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:95:2: ( ID )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:95:4: ID
			{
			root_0 = (Object)adaptor.nil();


			ID4=(Token)match(input,ID,FOLLOW_ID_in_lhs125); 
			ID4_tree = (Object)adaptor.create(ID4);
			adaptor.addChild(root_0, ID4_tree);


			retval.nt = new Nonterminal((ID4!=null?ID4.getText():null));	
				
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lhs"


	public static class rhs_return extends ParserRuleReturnScope {
		public List<Symbol> rhsSymbols;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rhs"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:100:1: rhs returns [List<Symbol> rhsSymbols] : ( ID r= rhs |);
	public final SynBioCFGParser.rhs_return rhs() throws RecognitionException {
		SynBioCFGParser.rhs_return retval = new SynBioCFGParser.rhs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID5=null;
		ParserRuleReturnScope r =null;

		Object ID5_tree=null;


		retval.rhsSymbols = new ArrayList<Symbol>();

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:105:2: ( ID r= rhs |)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ID) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==EOF||LA2_1==ID) ) {
					alt2=1;
				}
				else if ( (LA2_1==ARROW) ) {
					alt2=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA2_0==EOF) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:105:4: ID r= rhs
					{
					root_0 = (Object)adaptor.nil();


					ID5=(Token)match(input,ID,FOLLOW_ID_in_rhs150); 
					ID5_tree = (Object)adaptor.create(ID5);
					adaptor.addChild(root_0, ID5_tree);


					if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
					    retval.rhsSymbols.add(
					        this.symbols.get((ID5!=null?ID5.getText():null)));	
					}
						
					pushFollow(FOLLOW_rhs_in_rhs156);
					r=rhs();
					state._fsp--;

					adaptor.addChild(root_0, r.getTree());


					if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
					    if(null != (r!=null?((SynBioCFGParser.rhs_return)r).rhsSymbols:null)) {
					        retval.rhsSymbols.addAll(
					                (r!=null?((SynBioCFGParser.rhs_return)r).rhsSymbols:null));	
					    }
					}

					}
					break;
				case 2 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:119:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rhs"

	// Delegated rules



	public static final BitSet FOLLOW_productionRule_in_prog79 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_prog85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lhs_in_productionRule98 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_productionRule102 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rhs_in_productionRule106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_lhs125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_rhs150 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rhs_in_rhs156 = new BitSet(new long[]{0x0000000000000002L});
}
