// $ANTLR 3.5.1 /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g 2015-05-06 21:34:09

package gov.lbl.jgi.grammar.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SynBioCFGLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SynBioCFGLexer() {} 
	public SynBioCFGLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SynBioCFGLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g"; }

	// $ANTLR start "ALTERNATIVE"
	public final void mALTERNATIVE() throws RecognitionException {
		try {
			int _type = ALTERNATIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:11:13: ( '|' )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:11:15: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALTERNATIVE"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:12:7: ( '-->' )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:12:9: '-->'
			{
			match("-->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:122:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:122:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:122:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:126:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='/') ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='/') ) {
					alt5=1;
				}
				else if ( (LA5_1=='*') ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:126:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:126:14: (~ ( '\\n' | '\\r' ) )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop2;
						}
					}

					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:126:28: ( '\\r' )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0=='\r') ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:126:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					_channel=HIDDEN;
					}
					break;
				case 2 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:127:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:127:14: ( options {greedy=false; } : . )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0=='*') ) {
							int LA4_1 = input.LA(2);
							if ( (LA4_1=='/') ) {
								alt4=2;
							}
							else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '.')||(LA4_1 >= '0' && LA4_1 <= '\uFFFF')) ) {
								alt4=1;
							}

						}
						else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:127:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop4;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:130:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:130:9: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:138:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:138:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:138:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\\') ) {
					alt6=1;
				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '[')||(LA6_0 >= ']' && LA6_0 <= '\uFFFF')) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:138:14: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:138:24: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:141:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:141:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:141:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='\\') ) {
				alt7=1;
			}
			else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '&')||(LA7_0 >= '(' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:141:15: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:141:25: ~ ( '\\'' | '\\\\' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:146:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:150:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
					{
					alt8=1;
					}
					break;
				case 'u':
					{
					alt8=2;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt8=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:150:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:151:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:152:9: OCTAL_ESC
					{
					mOCTAL_ESC(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:157:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt9=3;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='\\') ) {
				int LA9_1 = input.LA(2);
				if ( ((LA9_1 >= '0' && LA9_1 <= '3')) ) {
					int LA9_2 = input.LA(3);
					if ( ((LA9_2 >= '0' && LA9_2 <= '7')) ) {
						int LA9_4 = input.LA(4);
						if ( ((LA9_4 >= '0' && LA9_4 <= '7')) ) {
							alt9=1;
						}

						else {
							alt9=2;
						}

					}

					else {
						alt9=3;
					}

				}
				else if ( ((LA9_1 >= '4' && LA9_1 <= '7')) ) {
					int LA9_3 = input.LA(3);
					if ( ((LA9_3 >= '0' && LA9_3 <= '7')) ) {
						alt9=2;
					}

					else {
						alt9=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:157:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:158:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 3 :
					// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:159:9: '\\\\' ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:164:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:164:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
			match('\\'); 
			match('u'); 
			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNICODE_ESC"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:8: ( ALTERNATIVE | ARROW | ID | COMMENT | WS | STRING | CHAR )
		int alt10=7;
		switch ( input.LA(1) ) {
		case '|':
			{
			alt10=1;
			}
			break;
		case '-':
			{
			alt10=2;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case '_':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt10=3;
			}
			break;
		case '/':
			{
			alt10=4;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt10=5;
			}
			break;
		case '\"':
			{
			alt10=6;
			}
			break;
		case '\'':
			{
			alt10=7;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 10, 0, input);
			throw nvae;
		}
		switch (alt10) {
			case 1 :
				// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:10: ALTERNATIVE
				{
				mALTERNATIVE(); 

				}
				break;
			case 2 :
				// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:22: ARROW
				{
				mARROW(); 

				}
				break;
			case 3 :
				// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:28: ID
				{
				mID(); 

				}
				break;
			case 4 :
				// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:31: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 5 :
				// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:39: WS
				{
				mWS(); 

				}
				break;
			case 6 :
				// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:42: STRING
				{
				mSTRING(); 

				}
				break;
			case 7 :
				// /Users/eoberortner/Projects/JGI/Grammars/git/SynBioLanguage/grammar/SynBioCFG.g:1:49: CHAR
				{
				mCHAR(); 

				}
				break;

		}
	}



}
