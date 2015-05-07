// $ANTLR 3.5.1 /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g 2015-05-06 22:38:53

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
		"COMMENT", "DOT", "ESC_SEQ", "HEX_DIGIT", "ID", "OCTAL_ESC", "STRING", 
		"UNICODE_ESC", "WS"
	};
	public static final int EOF=-1;
	public static final int ALTERNATIVE=4;
	public static final int ARROW=5;
	public static final int CHAR=6;
	public static final int COMMENT=7;
	public static final int DOT=8;
	public static final int ESC_SEQ=9;
	public static final int HEX_DIGIT=10;
	public static final int ID=11;
	public static final int OCTAL_ESC=12;
	public static final int STRING=13;
	public static final int UNICODE_ESC=14;
	public static final int WS=15;

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
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:71:1: prog returns [Grammar grammar] : ( productionRule )* EOF ;
	public final SynBioCFGParser.prog_return prog() throws RecognitionException {
		SynBioCFGParser.prog_return retval = new SynBioCFGParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope productionRule1 =null;

		Object EOF2_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:73:2: ( ( productionRule )* EOF )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:73:4: ( productionRule )* EOF
			{
			root_0 = (Object)adaptor.nil();


			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:73:4: ( productionRule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:73:5: productionRule
					{
					pushFollow(FOLLOW_productionRule_in_prog88);
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
				
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog94); 
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
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:82:1: productionRule : nt= lhs ARROW los= rhs DOT ;
	public final SynBioCFGParser.productionRule_return productionRule() throws RecognitionException {
		SynBioCFGParser.productionRule_return retval = new SynBioCFGParser.productionRule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ARROW3=null;
		Token DOT4=null;
		ParserRuleReturnScope nt =null;
		ParserRuleReturnScope los =null;

		Object ARROW3_tree=null;
		Object DOT4_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:83:2: (nt= lhs ARROW los= rhs DOT )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:83:4: nt= lhs ARROW los= rhs DOT
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_lhs_in_productionRule107);
			nt=lhs();
			state._fsp--;

			adaptor.addChild(root_0, nt.getTree());


			if(this.PARSING_PHASE == ParsingPhases.COLLECT_NONTERMINALS) {
			    this.symbols.put((nt!=null?((SynBioCFGParser.lhs_return)nt).nt:null));
			}	
				
			ARROW3=(Token)match(input,ARROW,FOLLOW_ARROW_in_productionRule111); 
			ARROW3_tree = (Object)adaptor.create(ARROW3);
			adaptor.addChild(root_0, ARROW3_tree);

			pushFollow(FOLLOW_rhs_in_productionRule115);
			los=rhs();
			state._fsp--;

			adaptor.addChild(root_0, los.getTree());


			if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	

			    List<List<Symbol>> rhsAlternatives = (los!=null?((SynBioCFGParser.rhs_return)los).rhsAlternatives:null);
			    
			    for(List<Symbol> alternative : rhsAlternatives) {
			        this.symbols.put((nt!=null?((SynBioCFGParser.lhs_return)nt).nt:null), alternative);	
			    }
			}
				
			DOT4=(Token)match(input,DOT,FOLLOW_DOT_in_productionRule119); 
			DOT4_tree = (Object)adaptor.create(DOT4);
			adaptor.addChild(root_0, DOT4_tree);

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
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:99:1: lhs returns [Nonterminal nt] : ID ;
	public final SynBioCFGParser.lhs_return lhs() throws RecognitionException {
		SynBioCFGParser.lhs_return retval = new SynBioCFGParser.lhs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID5=null;

		Object ID5_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:101:2: ( ID )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:101:4: ID
			{
			root_0 = (Object)adaptor.nil();


			ID5=(Token)match(input,ID,FOLLOW_ID_in_lhs136); 
			ID5_tree = (Object)adaptor.create(ID5);
			adaptor.addChild(root_0, ID5_tree);


			retval.nt = new Nonterminal((ID5!=null?ID5.getText():null));	
				
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
		public List<List<Symbol>> rhsAlternatives;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rhs"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:106:1: rhs returns [List<List<Symbol>> rhsAlternatives] : alt= rhs_alternative ( ALTERNATIVE r= rhs_alternative )* ;
	public final SynBioCFGParser.rhs_return rhs() throws RecognitionException {
		SynBioCFGParser.rhs_return retval = new SynBioCFGParser.rhs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ALTERNATIVE6=null;
		ParserRuleReturnScope alt =null;
		ParserRuleReturnScope r =null;

		Object ALTERNATIVE6_tree=null;


		retval.rhsAlternatives = new ArrayList<List<Symbol>>();

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:111:2: (alt= rhs_alternative ( ALTERNATIVE r= rhs_alternative )* )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:111:4: alt= rhs_alternative ( ALTERNATIVE r= rhs_alternative )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_rhs_alternative_in_rhs163);
			alt=rhs_alternative();
			state._fsp--;

			adaptor.addChild(root_0, alt.getTree());


			if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
			    retval.rhsAlternatives.add(
			        (alt!=null?((SynBioCFGParser.rhs_alternative_return)alt).rhsSymbols:null));	
			}
				
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:117:3: ( ALTERNATIVE r= rhs_alternative )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==ALTERNATIVE) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:117:4: ALTERNATIVE r= rhs_alternative
					{
					ALTERNATIVE6=(Token)match(input,ALTERNATIVE,FOLLOW_ALTERNATIVE_in_rhs171); 
					ALTERNATIVE6_tree = (Object)adaptor.create(ALTERNATIVE6);
					adaptor.addChild(root_0, ALTERNATIVE6_tree);

					pushFollow(FOLLOW_rhs_alternative_in_rhs175);
					r=rhs_alternative();
					state._fsp--;

					adaptor.addChild(root_0, r.getTree());


					if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
					    retval.rhsAlternatives.add(
					                (r!=null?((SynBioCFGParser.rhs_alternative_return)r).rhsSymbols:null));
					}	
						
					}
					break;

				default :
					break loop2;
				}
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
	// $ANTLR end "rhs"


	public static class rhs_alternative_return extends ParserRuleReturnScope {
		public List<Symbol> rhsSymbols;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rhs_alternative"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:125:1: rhs_alternative returns [List<Symbol> rhsSymbols] : ( ID )+ ;
	public final SynBioCFGParser.rhs_alternative_return rhs_alternative() throws RecognitionException {
		SynBioCFGParser.rhs_alternative_return retval = new SynBioCFGParser.rhs_alternative_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID7=null;

		Object ID7_tree=null;


		retval.rhsSymbols = new ArrayList<Symbol>();

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:130:2: ( ( ID )+ )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:130:4: ( ID )+
			{
			root_0 = (Object)adaptor.nil();


			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:130:4: ( ID )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ID) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:130:5: ID
					{
					ID7=(Token)match(input,ID,FOLLOW_ID_in_rhs_alternative203); 
					ID7_tree = (Object)adaptor.create(ID7);
					adaptor.addChild(root_0, ID7_tree);


					if(this.PARSING_PHASE == ParsingPhases.COLLECT_PRODUCTION_RULES) {	
					    retval.rhsSymbols.add(
					        this.symbols.get((ID7!=null?ID7.getText():null)));	
					}
						
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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
	// $ANTLR end "rhs_alternative"

	// Delegated rules



	public static final BitSet FOLLOW_productionRule_in_prog88 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EOF_in_prog94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lhs_in_productionRule107 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_productionRule111 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_rhs_in_productionRule115 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DOT_in_productionRule119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_lhs136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rhs_alternative_in_rhs163 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ALTERNATIVE_in_rhs171 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_rhs_alternative_in_rhs175 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ID_in_rhs_alternative203 = new BitSet(new long[]{0x0000000000000802L});
}
