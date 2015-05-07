package gov.lbl.jgi.grammar.tests;

import static org.junit.Assert.*;
import gov.lbl.jgi.grammar.dom.Nonterminal;
import gov.lbl.jgi.grammar.dom.ProductionRule;
import gov.lbl.jgi.grammar.dom.Symbol;
import gov.lbl.jgi.grammar.dom.Terminal;
import gov.lbl.jgi.grammar.parser.SymbolTables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class SymbolTablesTest {

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
	public void testInstantiate() {
	
		// SymbolTables is a singleton.
		// hence, when instantiating it multiple times, then 
		// all returned references must point to the same equal 
		// instance
		SymbolTables st1 = SymbolTables.instantiate();
		SymbolTables st2 = SymbolTables.instantiate();
		
		assertTrue(st1 == st2);
	}
	
	
	@Test
	public void testPut() {

		Terminal t1 = new Terminal("t1");
		Nonterminal S = new Nonterminal("S");
		
		// S --> t1
		List<Symbol> rhs = new ArrayList<Symbol>();
		rhs.add(t1);
		this.st.put(S, rhs);		// put into SymbolTables

		// start symbol
		assertTrue(st.getStartSymbol().equals(S));
		
		// production rule
		Set<ProductionRule> rules = this.st.getProductionRules();		
		assertTrue(null != rules);		
		assertTrue(rules.size() == 1);
		
		for(ProductionRule rule : rules) {
			assertTrue(rule.getNonterminal() == S);
			
			assertTrue(null != rule.getProduction());
			assertTrue(rule.getProduction().size() == 1);
		}
	}
	
	@Test
	public void testUnionSameNameNonterminals() {
		
		Nonterminal S = new Nonterminal("S");

		// S --> t1
		Terminal t1 = new Terminal("t1");
		List<Symbol> rhs1 = new ArrayList<Symbol>();
		rhs1.add(t1);
		this.st.put(S, rhs1);		// put into SymbolTables

		// S --> t2
		Terminal t2 = new Terminal("t2");
		List<Symbol> rhs2 = new ArrayList<Symbol>();
		rhs2.add(t2);
		this.st.put(S, rhs2);		// put into SymbolTables

		// ==>
		// S --> t1 | t2
		
		// start symbol
		assertTrue(this.st.getStartSymbol() == S);

		// production rule
		Set<ProductionRule> rules = this.st.getProductionRules();		
		assertTrue(null != rules);
		assertTrue(rules.size() == 2);
		
		for(ProductionRule rule : rules) {
			assertTrue(rule.getNonterminal() == S);
			
			assertTrue(null != rule.getProduction());
			assertTrue(rule.getProduction().size() == 1);
		}
	}
	
	
	
	@Test
	public void test_PutProductionRules_GetSymbols() {

		Nonterminal S = new Nonterminal("S");

		// S --> t1
		Terminal t1 = new Terminal("t1");
		List<Symbol> rhs1 = new ArrayList<Symbol>();
		rhs1.add(t1);
		this.st.put(S, rhs1);		// put into SymbolTables

		// S --> t2
		Terminal t2 = new Terminal("t2");
		List<Symbol> rhs2 = new ArrayList<Symbol>();
		rhs2.add(t2);
		this.st.put(S, rhs2);		// put into SymbolTables
		
		
		// now, there should be 3 symbols: S, t1, t2
		Set<Symbol> symbols = this.st.getSymbols();
		assertTrue(null != symbols);
		assertTrue(symbols.size() == 3);
		
	}

}
