package gov.lbl.jgi.grammar.tests;

import static org.junit.Assert.*;
import gov.lbl.jgi.grammar.dom.Nonterminal;
import gov.lbl.jgi.grammar.dom.ProductionRule;
import gov.lbl.jgi.grammar.dom.Symbol;
import gov.lbl.jgi.grammar.dom.Terminal;
import gov.lbl.jgi.grammar.parser.SymbolTables;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class SymbolTablesTest {

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
		/*
		 * instantiate the symbol tables
		 */
		SymbolTables st = SymbolTables.instantiate();
		

		Terminal t1 = new Terminal("t1");
		Nonterminal S = new Nonterminal("S");
		
		// S --> t1
		List<Symbol> rhs = new ArrayList<Symbol>();
		rhs.add(t1);
		st.put(S, rhs);		// put into SymbolTables

		// start symbol
		assertTrue(st.getStartSymbol().equals(S));
		
		// production rule
		Set<ProductionRule> rules = st.getProductionRules();		
		assertTrue(null != rules);		
		assertTrue(rules.size() == 1);
		
		for(ProductionRule rule : rules) {
			assertTrue(rule.getNonterminal() == S);
			
			assertTrue(null != rule.getProduction());
			assertTrue(rule.getProduction().size() == 1);
		}
		
		/*
		 * clear the symbol tables
		 */
		st.clear();
	}
	
	@Test
	public void testUnionSameNameNonterminals() {
		
		/*
		 * instantiate the symbol tables
		 */
		SymbolTables st = SymbolTables.instantiate();
		
		Nonterminal S = new Nonterminal("S");

		// S --> t1
		Terminal t1 = new Terminal("t1");
		List<Symbol> rhs1 = new ArrayList<Symbol>();
		rhs1.add(t1);
		st.put(S, rhs1);		// put into SymbolTables

		// S --> t2
		Terminal t2 = new Terminal("t2");
		List<Symbol> rhs2 = new ArrayList<Symbol>();
		rhs2.add(t2);
		st.put(S, rhs2);		// put into SymbolTables

		// ==>
		// S --> t1 | t2
		
		// start symbol
		assertTrue(st.getStartSymbol() == S);

		// production rule
		Set<ProductionRule> rules = st.getProductionRules();		
		assertTrue(null != rules);
		assertTrue(rules.size() == 2);
		
		for(ProductionRule rule : rules) {
			assertTrue(rule.getNonterminal() == S);
			
			assertTrue(null != rule.getProduction());
			assertTrue(rule.getProduction().size() == 1);
		}
				
		/*
		 * clear the symbol tables
		 */
		st.clear();
	}

}
