package gov.lbl.jgi.grammar.tests;

import static org.junit.Assert.*;

import java.util.Set;

import gov.lbl.jgi.grammar.dom.Symbol;
import gov.lbl.jgi.grammar.parser.SymbolTables;
import gov.lbl.jgi.grammar.parser.SynBioCFGLexer;
import gov.lbl.jgi.grammar.parser.SynBioCFGParser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	private SymbolTables st;
	
	@Before
	public void setUp() 
			throws Exception {

		this.st = SymbolTables.instantiate();
	}

	@After
	public void tearDown() 
			throws Exception {

		if(null != this.st) {
			this.st.clear();
			this.st = null;
		}
	}


	@Test
	public void testParsingPhases() {
		
		String grammar = "S --> t1";

		// instantiate the lexer/parser based on the specified grammar
		SynBioCFGLexer lexer = new SynBioCFGLexer(new ANTLRStringStream(grammar));
		CommonTokenStream tokens = new CommonTokenStream(lexer);		
		SynBioCFGParser parser = new SynBioCFGParser(tokens);
		
		/*
		 * PHASE I:
		 * parse the grammar in order to collect the Nonterminals
		 */
		parser.PARSING_PHASE = SynBioCFGParser.ParsingPhases.COLLECT_NONTERMINALS;		
		try {
			parser.prog();			
			/*
			 * after the first pass of parsing,
			 * there should be only the start symbol in the 
			 * symbol tables 
			 */
			Set<Symbol> symbols = this.st.getSymbols();
			
			assertTrue(null != symbols);
			assertTrue(symbols.size() == 1);	// i.e. the start symbol S
			
		} catch(Exception e) {
			assertTrue(false);		// no exception allowed
		}
		

		/*
		 * PHASE II:
		 * parse the grammar in order to collect all production rules
		 * and to differentiate between Nonterminals and Terminals
		 */
		// instantiate the lexer/parser based on the specified grammar
		lexer = new SynBioCFGLexer(new ANTLRStringStream(grammar));
		tokens = new CommonTokenStream(lexer);		
		parser = new SynBioCFGParser(tokens);

		parser.PARSING_PHASE = SynBioCFGParser.ParsingPhases.COLLECT_PRODUCTION_RULES;		
		try {
			parser.prog();			
			
			/*
			 * after the second pass of parsing,
			 * there should be only the start symbol as well as
			 * the terminal t1 
			 */
			Set<Symbol> symbols = this.st.getSymbols();
			
			assertTrue(null != symbols);
			assertTrue(symbols.size() == 2);	
					// i.e. the start symbol S
					// and the terminal t1
			
		} catch(Exception e) {
			assertTrue(false);		// no exception allowed
		}

	}

}
