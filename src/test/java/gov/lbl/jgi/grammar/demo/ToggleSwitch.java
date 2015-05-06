package gov.lbl.jgi.grammar.demo;

import gov.lbl.jgi.grammar.Enumerator;
import gov.lbl.jgi.grammar.dom.Grammar;
import gov.lbl.jgi.grammar.dom.Nonterminal;
import gov.lbl.jgi.grammar.dom.ProductionRule;
import gov.lbl.jgi.grammar.dom.Symbol;
import gov.lbl.jgi.grammar.dom.Terminal;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ernst Oberortner
 */
public class ToggleSwitch {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * STEP I:
		 * build a grammar
		 */
		Grammar g = buildToggleSwitchGrammar();		
		Enumerator.enumerate(g);
		
		
	}
	
	/**
	 * Example: A grammar to describe the structure
	 * of a genetic toggle switch in a hierarchical manner.
	 * 
	 * @return
	 */
	private static Grammar buildToggleSwitchGrammar() {
		/*
		 * Grammar ToggleSwitch := <
		 * 
		 * NT := {ToggleSwitch, revCassette, fwdCassette},
		 * 
		 * T  := {reporter1, promoter1, promoter2, repressor1, repressor2},
		 * 
		 * PR := {
		 *     ToggleSwitch --> revCassette fwdCassette Reporter
		 *     revCassette  --> Repressor Promoter
		 *     fwdCassette  --> Promoter Repressor
		 *     
		 *     Reporter     --> reporter1
		 *     
		 *     Promoter     --> promoter1 
		 *                    | promoter2
		 *                    
		 *     Repressor    --> repressor1 
		 *                    | repressor2
		 * },
		 * 
		 * S  := {ToggleSwitch}
		 *
		 * >
		 */
		

		/*---------------
		 * NON-TERMINALS
		 *---------------*/

		// Part Types
		Nonterminal ToggleSwitch = new Nonterminal("ToggleSwitch");
		Nonterminal revCassette = new Nonterminal("revCassette");
		Nonterminal fwdCassette = new Nonterminal("fwdCassette");
		Nonterminal Promoter = new Nonterminal("Promoter");
		Nonterminal Repressor = new Nonterminal("Repressor");
		Nonterminal Reporter = new Nonterminal("Reporter");
		
		/*---------------
		 * TERMINALS
		 *---------------*/
		
		// Promoters
		Terminal prom1 = new Terminal("promoter1");
		Terminal prom2 = new Terminal("promoter2");
		
		// Repressors
		Terminal repr1 = new Terminal("repressor1");
		Terminal repr2 = new Terminal("repressor2");
		
		// Reporters
		Terminal repo1 = new Terminal("reporter1");
		Terminal repo2 = new Terminal("reporter2");
		
		/*------------------
		 * PRODUCTION RULES
		 *------------------*/
		List<ProductionRule> prodRules = new ArrayList<ProductionRule>();
		
		// ToggleSwitch --> revCassette fwdCassette Reporter		
		List<Symbol> lhs_ts = new ArrayList<Symbol>();
		lhs_ts.add(revCassette);
		lhs_ts.add(fwdCassette);
		lhs_ts.add(Reporter);
		prodRules.add(new ProductionRule(ToggleSwitch, lhs_ts));
		
		// revCassette  --> Repressor Promoter
		List<Symbol> lhs_rev = new ArrayList<Symbol>();
		lhs_rev.add(Repressor);
		lhs_rev.add(Promoter);
		prodRules.add(new ProductionRule(revCassette, lhs_rev));
		
		// fwdCassette  --> Promoter Repressor
		List<Symbol> lhs_fwd = new ArrayList<Symbol>();
		lhs_fwd.add(Promoter);
		lhs_fwd.add(Repressor);
		prodRules.add(new ProductionRule(fwdCassette, lhs_fwd));
		
		// Promoter --> promoter1 
		//            | promoter2
		List<Symbol> loProm1 = new ArrayList<Symbol>();
		loProm1.add(prom1);
		prodRules.add(new ProductionRule(Promoter, loProm1));

		List<Symbol> loProm2 = new ArrayList<Symbol>();
		loProm2.add(prom2);
		prodRules.add(new ProductionRule(Promoter, loProm2));
		
		
		// Repressor --> repressor1 
		//             | repressor2
		List<Symbol> loRepr1 = new ArrayList<Symbol>();
		loRepr1.add(repr1);
		prodRules.add(new ProductionRule(Repressor, loRepr1));		

		List<Symbol> loRepr2 = new ArrayList<Symbol>();
		loRepr2.add(repr2);
		prodRules.add(new ProductionRule(Repressor, loRepr2));		

		// Reporter --> reporter1
		//			  | reporter2
		List<Symbol> loRepos1 = new ArrayList<Symbol>();
		loRepos1.add(repo1);
		prodRules.add(new ProductionRule(Reporter, loRepos1));
		
		List<Symbol> loRepos2 = new ArrayList<Symbol>();
		loRepos2.add(repo2);
		prodRules.add(new ProductionRule(Reporter, loRepos2));

		/*---------
		 * GRAMMAR
		 *---------*/
		return new Grammar(prodRules, ToggleSwitch);
	}

}
