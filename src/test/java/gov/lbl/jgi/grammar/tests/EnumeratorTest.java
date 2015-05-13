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
import gov.lbl.jgi.grammar.parser.SymbolTables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnumeratorTest {

	@After
	public void tearDown() 
			throws Exception {
		SymbolTables.instantiate().clear();
	}

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
		String script = "S --> t1.";
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
		assertTrue(null != sentences);
		assertTrue(sentences.size() == 1);		
	}
	
	@Test
	public void testOneHierarchyGrammar() {
		String script = "S --> NT. NT --> t1.";
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
		assertTrue(null != sentences);
		assertTrue(sentences.size() == 1);	
		
		// get the sentence
		List<Symbol> sentence = sentences.get(0);
		assertTrue(null != sentence);
		assertTrue(sentence.size() == 1);
	}

	@Test
	public void testOneHierarchyGrammar_2words() {
		String script = "S --> NT. NT --> t1 t2.";
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
		assertTrue(null != sentences);
		assertTrue(sentences.size() == 1);	
		
		// get the sentence
		List<Symbol> sentence = sentences.get(0);
		assertTrue(null != sentence);
		assertTrue(sentence.size() == 2);
	}
	
	@Test
	public void testOneLevelAlernatives() {
		String script = "S --> t1 | t2.";
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
		assertTrue(null != sentences);
		assertTrue(sentences.size() == 2);	

		for(List<Symbol> sentence : sentences) {
			assertTrue(null != sentence);
			assertTrue(sentence.size() == 1);
		}
	}

	@Test
	public void testSentencesOfDifferentLength() {
		String script = "S --> t1 | t2 t3 | t4.";
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
		assertTrue(null != sentences);
		assertTrue(sentences.size() == 3);
		
	}
	
	@Test
	public void testTwoLevelAlternatives_SentencesOfDifferentLength() {
		String script = "S --> N N. N --> t1 | t2 t3 | t4.";
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
		assertTrue(null != sentences);
		
	}

}
