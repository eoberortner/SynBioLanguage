package gov.lbl.jgi.grammar.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import gov.lbl.jgi.grammar.Enumerator;
import gov.lbl.jgi.grammar.dom.Grammar;
import gov.lbl.jgi.grammar.dom.Nonterminal;
import gov.lbl.jgi.grammar.dom.ProductionRule;
import gov.lbl.jgi.grammar.dom.Symbol;
import gov.lbl.jgi.grammar.dom.Terminal;

import org.junit.Test;

public class EnumeratorTest {

	@Test
	public void testEnumerate_OneTerminal() {

		/*
		 * build the grammar
		 * 
		 * S --> t1
		 */
		Terminal t1 = new Terminal("t1");
		Nonterminal S = new Nonterminal("S");
		
		List<ProductionRule> prodRules = new ArrayList<ProductionRule>();

		// S --> t1 
		List<Symbol> lot1 = new ArrayList<Symbol>();
		lot1.add(t1);
		prodRules.add(new ProductionRule(S, lot1));		

		Grammar g = new Grammar(prodRules, S);
		List<List<Symbol>> sentences = Enumerator.enumerate(g);
		
		assertTrue(null != sentences);
		assertTrue(sentences.size() == 1);
		
		List<Symbol> sentence = sentences.get(0);
		assertTrue(null != sentence);
		assertTrue(sentence.size() == 1);
		
		assertTrue(sentence.get(0) instanceof Terminal);
		assertTrue(((Terminal)sentence.get(0)) == t1);
		
		assertTrue(((Terminal)sentence.get(0)).isTerminal());
		assertTrue(((Terminal)sentence.get(0)).getName() == "t1");
	}
	
	
	@Test
	public void testSpecifyGrammar() {
		String script = "S --> t1";
		
		Enumerator.enumerate(script);
		
	}

}
