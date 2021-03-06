package gov.lbl.jgi.grammar;

import gov.lbl.jgi.grammar.dom.Grammar;
import gov.lbl.jgi.grammar.dom.Nonterminal;
import gov.lbl.jgi.grammar.dom.ProductionRule;
import gov.lbl.jgi.grammar.dom.Symbol;
import gov.lbl.jgi.grammar.dom.Terminal;
import gov.lbl.jgi.grammar.parser.SynBioCFGLexer;
import gov.lbl.jgi.grammar.parser.SynBioCFGParser;
import gov.lbl.jgi.grammar.parser.SynBioCFGParser.prog_return;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

/**
 * This algorithm is inspired by:
 * http://stackoverflow.com/questions/17387686/how-to-enumerate-the-strings-of-a-context-free-grammar
 * 
 * 
 * Remove the first sentence in the queue.
 * If it contains only terminals, output it.
 * Otherwise, 
 *     for each production for the first non-terminal in the sentence,
 *          append to the queue the result of expanding that production.
 *          
 *         
 * @author Ernst Oberortner
 */
public class Enumerator {

	public static List<List<Symbol>> enumerate(String grammar) {

		collectNonterminals(grammar);
		
		Grammar g = collectProductionRules(grammar);
		
		if(null != grammar) {
			return enumerate(g);
		}
		
		return null;		
	}
	
	private static void collectNonterminals(String grammar) {
		SynBioCFGLexer lexer = new SynBioCFGLexer(new ANTLRStringStream(grammar));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		SynBioCFGParser parser = new SynBioCFGParser(tokens);
		parser.PARSING_PHASE = SynBioCFGParser.ParsingPhases.COLLECT_NONTERMINALS;
		try {
			parser.prog();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Grammar collectProductionRules(String grammar) {
		SynBioCFGLexer lexer = new SynBioCFGLexer(new ANTLRStringStream(grammar));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		SynBioCFGParser parser = new SynBioCFGParser(tokens);
		parser.PARSING_PHASE = SynBioCFGParser.ParsingPhases.COLLECT_PRODUCTION_RULES;
		try {
			prog_return ret = parser.prog();
			
			return ret.grammar;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<List<Symbol>> enumerate(Grammar grammar) {

		/*
		 * STEP I: TRANSFORMATION
		 * convert the grammar to Chomsky Normal Form
		 * 
		 * for the time being, we assume the grammar IS in CNF
		 */
		Grammar cnfGrammar = transformToCNF(grammar);
		
		/*
		 * STEP II: ENUMERATION
		 */
		List<Symbol> symbols = new ArrayList<Symbol>();
		symbols.add(cnfGrammar.getStartSymbol());

		List<List<Symbol>> sentences = new ArrayList<List<Symbol>>();
		enumerate(cnfGrammar, symbols, 0, sentences);
		
		return sentences;		
	}
	
	private static void enumerate(
			Grammar grammar, List<Symbol> currentSentence, int idx, List<List<Symbol>> sentences) {
		
		List<Symbol> newSymbols = new ArrayList<Symbol>();		
		while(idx < currentSentence.size()) {
			
			Symbol currentSymbol = currentSentence.get(idx);
			
			if(currentSymbol instanceof Terminal) {			
	
				newSymbols.addAll(currentSentence.subList(0, idx));
				newSymbols.add(currentSymbol);
				newSymbols.addAll(currentSentence.subList(idx + 1, currentSentence.size()));
				
			} else if(currentSymbol instanceof Nonterminal) {
				
				for(ProductionRule production : grammar.getProductions((Nonterminal)currentSymbol)) {
					
					newSymbols = new ArrayList<Symbol>();
							 
					newSymbols.addAll(currentSentence.subList(0, idx));
					newSymbols.addAll(production.getProduction());
					newSymbols.addAll(currentSentence.subList(idx + 1, currentSentence.size()));
					
					enumerate(grammar, newSymbols, idx, sentences);
				}
				
			}
			
			idx++;
		}

		// if the list only contains Terminals, then print it
		if(!currentSentence.isEmpty()) {
			boolean bIsSentence = true;
			for(Symbol sym : currentSentence) {
				if(sym instanceof Nonterminal) {
					bIsSentence = false;
					break;
				}
			}
			
			if(bIsSentence) {
				sentences.add(currentSentence);
			}
		}
	}
	

	private static Grammar transformToCNF(Grammar grammar) {
		
		// TODO:
		
		return grammar;
	}
	
	
}
