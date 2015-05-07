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
	
	/*
	 * SYMBOLS
	 */
	private Set<Symbol> symbols;
	
	
	private SymbolTables() {
		this.productionRules = new HashMap<Nonterminal, Set<ProductionRule>>();
		
		this.symbols = new HashSet<Symbol>();
		
		start = null;
	}
		
	public void put(Nonterminal nt) {
		/*
		 * the first left-hand-side NT is the start symbol
		 */
		if(null == this.start) {
			this.start = nt;
		}
		
		if(!this.productionRules.containsKey(nt)) {
			this.productionRules.put(nt, new HashSet<ProductionRule>());
		}
		
		/*
		 * put the Non-Terminal into the symbols set
		 */
		this.getSymbols().add(nt);
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

		/*
		 * put the Non-Terminal into the symbols set
		 */
		this.getSymbols().add(nt);

		/*
		 * put all right-hand side symbols into the symbols set
		 */
		for(Symbol symbol : rhs) {
			this.getSymbols().add(symbol);
		}

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
	
	public Symbol get(String name) {
		
		for(Symbol symbol : this.getSymbols()) {
			if(symbol.getName().equals(name)) {
				return symbol;
			}
		}
		
		/*
		 * in this case, we put the ID 
		 * as a terminal into the symbol tables
		 */
		Terminal t = new Terminal(name);
		this.getSymbols().add(t);
		
		return this.get(name);
	}
	
	public Set<Symbol> getSymbols() {
		return this.symbols;
	}
	
	
	/*------------------------------
	 * SymbolTables is a SINGLETON
	 *------------------------------*/
	private static SymbolTables symbolTable = null;
	
	public static SymbolTables instantiate() {
		
//		System.out.println("*** instantiate ***");
		
		if(null == symbolTable) {
			symbolTable = new SymbolTables();
		}
		
		return symbolTable;
	}
	
	public void clear() {
		
//		System.out.println("*** clear ***");
		
		if(null != this.symbols) {
			this.symbols.clear();
		}
		
		if(null != this.productionRules) {
			this.productionRules.clear();
		}
		
		this.start = null;
	}
}
