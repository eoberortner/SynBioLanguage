package gov.lbl.jgi.grammar.demo;

import gov.lbl.jgi.grammar.Enumerator;
import gov.lbl.jgi.grammar.dom.Grammar;
import gov.lbl.jgi.grammar.dom.Nonterminal;
import gov.lbl.jgi.grammar.dom.ProductionRule;
import gov.lbl.jgi.grammar.dom.Symbol;

import java.util.List;
import java.util.ArrayList;

public class CircuitDesigns {

	public static void main(String[] args) {

		withoutPermutations();
		includeDevicePermutations();		
		includePartPermutations();
	}
	
	private static void withoutPermutations() {
		String script = buildCircuitGrammarScript();
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
//		System.out.println("sentences: ");
//		System.out.println(sentences);		
		System.out.println("there are " + sentences.size() + " designs without permutations.");
	}
	
	private static void includeDevicePermutations() {
		String script = buildCircuitGrammarScript_IncludeDevicePermutations();
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
//		System.out.println("sentences: ");
//		System.out.println(sentences);		
		System.out.println("there are " + sentences.size() + " designs including permutations.");
	}

	private static void includePartPermutations() {
		String script = buildCircuitGrammarScript_IncludePartOrientation();
		
		List<List<Symbol>> sentences = Enumerator.enumerate(script);
//		System.out.println("sentences: ");
//		System.out.println(sentences);		
		System.out.println("there are " + sentences.size() + " designs including permutations and orientations.");
	}

	private static String buildCircuitGrammarScript() {
		/*
		 * Device gate_NOR_A2_AmtR(+input_pTet, +BydvJ, +A2, +AmtR, +L3S2P55);
		 * Device gate_NOR_P3_PhlF(Promoter, Promoter, +RiboJ53, +P3, +PhlF, +ECK120033737);
		 * Device gate_output_YFP(+pPhlF, +output_YFP);
		 * 
		 * Device logic_gates(gate_NOR_P3_PhlF,  gate_NOR_A2_AmtR, gate_output_YFP);
		 */
		
		return  "logic_gates --> gate_NOR_P3_PhlF gate_NOR_A2_AmtR gate_output_YFP." +
				"gate_NOR_P3_PhlF --> Promoter Promoter RiboJ53 P3 PhlF ECK120033737." +
				"Promoter --> input_pTac | input_pTet | pAmtRjs | pPhlF." + 
				"gate_NOR_A2_AmtR --> input_pTet BydvJ A2 AmtR L3S2P55." + 
				"gate_output_YFP --> pPhlF output_YFP.";
	}

	private static String buildCircuitGrammarScript_IncludeDevicePermutations() {
		/*
		 * Device gate_NOR_A2_AmtR(+input_pTet, +BydvJ, +A2, +AmtR, +L3S2P55);
		 * Device gate_NOR_P3_PhlF(Promoter, Promoter, +RiboJ53, +P3, +PhlF, +ECK120033737);
		 * Device gate_output_YFP(+pPhlF, +output_YFP);
		 * 
		 * Device logic_gates(gate_NOR_P3_PhlF,  gate_NOR_A2_AmtR, gate_output_YFP);
		 */
		
		return  "logic_gates --> gate_NOR_P3_PhlF gate_NOR_A2_AmtR gate_output_YFP" +
				"              | gate_NOR_P3_PhlF gate_output_YFP gate_NOR_A2_AmtR" +
				"              | gate_NOR_A2_AmtR gate_NOR_P3_PhlF gate_output_YFP" +
				"              | gate_NOR_A2_AmtR gate_output_YFP gate_NOR_P3_PhlF" +
				"              | gate_output_YFP gate_NOR_A2_AmtR gate_NOR_P3_PhlF " +
				"              | gate_output_YFP gate_NOR_P3_PhlF gate_NOR_A2_AmtR." +
				// 
				"gate_NOR_P3_PhlF --> Promoter Promoter RiboJ53 P3 PhlF ECK120033737." +
				"gate_NOR_A2_AmtR --> input_pTet BydvJ A2 AmtR L3S2P55." + 
				"gate_output_YFP --> pPhlF output_YFP." + 
				
				"Promoter --> input_pTac | input_pTet | pAmtRjs | pPhlF.";
	}
	
	private static String buildCircuitGrammarScript_IncludePartOrientation() {
		/*
		 * Device gate_NOR_A2_AmtR(+input_pTet, +BydvJ, +A2, +AmtR, +L3S2P55);
		 * Device gate_NOR_P3_PhlF(Promoter, Promoter, +RiboJ53, +P3, +PhlF, +ECK120033737);
		 * Device gate_output_YFP(+pPhlF, +output_YFP);
		 * 
		 * Device logic_gates(gate_NOR_P3_PhlF,  gate_NOR_A2_AmtR, gate_output_YFP);
		 */
		
		return  "logic_gates --> gate_NOR_P3_PhlF gate_NOR_A2_AmtR gate_output_YFP" +
				"              | gate_NOR_P3_PhlF gate_output_YFP gate_NOR_A2_AmtR" +
				"              | gate_NOR_A2_AmtR gate_NOR_P3_PhlF gate_output_YFP" +
				"              | gate_NOR_A2_AmtR gate_output_YFP gate_NOR_P3_PhlF" +
				"              | gate_output_YFP gate_NOR_A2_AmtR gate_NOR_P3_PhlF " +
				"              | gate_output_YFP gate_NOR_P3_PhlF gate_NOR_A2_AmtR." +
				// 
				"gate_NOR_P3_PhlF --> Promoter Promoter RiboJ53 P3 PhlF ECK120033737" +
				"                   | ECK120033737 PhlF P3 RiboJ53 Promoter Promoter." +
				
				"gate_NOR_A2_AmtR --> input_pTet BydvJ A2 AmtR L3S2P55" + 
				"                   | L3S2P55 AmtR A2 BydvJ input_pTet." + 

				"gate_output_YFP --> pPhlF output_YFP" + 
				"                  | output_YFP pPhlF." + 
				
				"Promoter --> input_pTac | input_pTet | pAmtRjs | pPhlF.";
	}
}
