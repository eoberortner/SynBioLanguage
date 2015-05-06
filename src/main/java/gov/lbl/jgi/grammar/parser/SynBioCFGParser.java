// $ANTLR 3.5.1 /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g 2015-05-06 15:48:59

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
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:59:1: prog returns [Grammar grammar] : ( productionRule )* EOF ;
	public final SynBioCFGParser.prog_return prog() throws RecognitionException {
		SynBioCFGParser.prog_return retval = new SynBioCFGParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope productionRule1 =null;

		Object EOF2_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:61:2: ( ( productionRule )* EOF )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:61:4: ( productionRule )* EOF
			{
			root_0 = (Object)adaptor.nil();


			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:61:4: ( productionRule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:61:5: productionRule
					{
					pushFollow(FOLLOW_productionRule_in_prog78);
					productionRule1=productionRule();
					state._fsp--;

					adaptor.addChild(root_0, productionRule1.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog82); 
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
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:64:1: productionRule : lhs ARROW rhs ;
	public final SynBioCFGParser.productionRule_return productionRule() throws RecognitionException {
		SynBioCFGParser.productionRule_return retval = new SynBioCFGParser.productionRule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ARROW4=null;
		ParserRuleReturnScope lhs3 =null;
		ParserRuleReturnScope rhs5 =null;

		Object ARROW4_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:65:2: ( lhs ARROW rhs )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:65:4: lhs ARROW rhs
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_lhs_in_productionRule93);
			lhs3=lhs();
			state._fsp--;

			adaptor.addChild(root_0, lhs3.getTree());

			ARROW4=(Token)match(input,ARROW,FOLLOW_ARROW_in_productionRule95); 
			ARROW4_tree = (Object)adaptor.create(ARROW4);
			adaptor.addChild(root_0, ARROW4_tree);

			pushFollow(FOLLOW_rhs_in_productionRule97);
			rhs5=rhs();
			state._fsp--;

			adaptor.addChild(root_0, rhs5.getTree());

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lhs"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:68:1: lhs : ID ;
	public final SynBioCFGParser.lhs_return lhs() throws RecognitionException {
		SynBioCFGParser.lhs_return retval = new SynBioCFGParser.lhs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID6=null;

		Object ID6_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:68:5: ( ID )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:68:7: ID
			{
			root_0 = (Object)adaptor.nil();


			ID6=(Token)match(input,ID,FOLLOW_ID_in_lhs107); 
			ID6_tree = (Object)adaptor.create(ID6);
			adaptor.addChild(root_0, ID6_tree);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rhs"
	// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:71:1: rhs : ( ID rhs | ID ALTERNATIVE rhs |);
	public final SynBioCFGParser.rhs_return rhs() throws RecognitionException {
		SynBioCFGParser.rhs_return retval = new SynBioCFGParser.rhs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID7=null;
		Token ID9=null;
		Token ALTERNATIVE10=null;
		ParserRuleReturnScope rhs8 =null;
		ParserRuleReturnScope rhs11 =null;

		Object ID7_tree=null;
		Object ID9_tree=null;
		Object ALTERNATIVE10_tree=null;

		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:71:5: ( ID rhs | ID ALTERNATIVE rhs |)
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ID) ) {
				switch ( input.LA(2) ) {
				case ALTERNATIVE:
					{
					alt2=2;
					}
					break;
				case EOF:
				case ID:
					{
					alt2=1;
					}
					break;
				case ARROW:
					{
					alt2=3;
					}
					break;
				default:
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
				alt2=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:71:7: ID rhs
					{
					root_0 = (Object)adaptor.nil();


					ID7=(Token)match(input,ID,FOLLOW_ID_in_rhs118); 
					ID7_tree = (Object)adaptor.create(ID7);
					adaptor.addChild(root_0, ID7_tree);

					pushFollow(FOLLOW_rhs_in_rhs120);
					rhs8=rhs();
					state._fsp--;

					adaptor.addChild(root_0, rhs8.getTree());

					}
					break;
				case 2 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:72:4: ID ALTERNATIVE rhs
					{
					root_0 = (Object)adaptor.nil();


					ID9=(Token)match(input,ID,FOLLOW_ID_in_rhs125); 
					ID9_tree = (Object)adaptor.create(ID9);
					adaptor.addChild(root_0, ID9_tree);

					ALTERNATIVE10=(Token)match(input,ALTERNATIVE,FOLLOW_ALTERNATIVE_in_rhs127); 
					ALTERNATIVE10_tree = (Object)adaptor.create(ALTERNATIVE10);
					adaptor.addChild(root_0, ALTERNATIVE10_tree);

					pushFollow(FOLLOW_rhs_in_rhs129);
					rhs11=rhs();
					state._fsp--;

					adaptor.addChild(root_0, rhs11.getTree());

					}
					break;
				case 3 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:74:2: 
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



	public static final BitSet FOLLOW_productionRule_in_prog78 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_prog82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lhs_in_productionRule93 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_productionRule95 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rhs_in_productionRule97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_lhs107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_rhs118 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rhs_in_rhs120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_rhs125 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ALTERNATIVE_in_rhs127 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_rhs_in_rhs129 = new BitSet(new long[]{0x0000000000000002L});
}
