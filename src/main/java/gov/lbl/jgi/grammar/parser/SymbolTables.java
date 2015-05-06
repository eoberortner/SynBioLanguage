package gov.lbl.jgi.grammar.parser;

import gov.lbl.jgi.grammar.dom.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author Ernst Oberortner
 */
public class SymbolTables {

	/*
	 * PRODUCTION RULES
	 */
	private Map<Nonterminal, Set<ProductionRule>> productionRules;
	
	/*
	 * START symbol
	 */
	private Nonterminal start;
	
	private SymbolTables() {
		this.productionRules = new HashMap<Nonterminal, Set<ProductionRule>>();
		
		start = null;
	}
		
	public void put(Nonterminal nt, List<Symbol> rhs) {
		
		/*
		 * the first left-hand-side NT is the start symbol
		 */
		if(null == this.start) {
			this.start = nt;
		}
		
		if(!this.productionRules.containsKey(nt)) {
			this.productionRules.put(nt, new HashSet<ProductionRule>());
		}
		
		this.productionRules.get(nt).add(
				new ProductionRule(nt, rhs));
	}
	
	public Nonterminal getStartSymbol() {
		return this.start;		
	}

	public Set<ProductionRule> getProductionRules() {
		/*
		 * union all sets of production rules
		 */
		Set<ProductionRule> allRules = new HashSet<ProductionRule>();
		
		for(Nonterminal nt : this.productionRules.keySet()) {
			allRules.addAll(this.productionRules.get(nt));
		}
		
		return allRules;
	}
	
	
	/*------------------------------
	 * SymbolTables is a SINGLETON
	 *------------------------------*/
	private static SymbolTables symbols = null;
	
	public static SymbolTables instantiate() {
		if(null == symbols) {
			symbols = new SymbolTables();
		}
		
		return symbols;
	}
	
	public void clear() {
		if(null != this.productionRules) {
			this.productionRules.clear();
		}
	}
}
