package gov.lbl.jgi.grammar.dom;

/**
 * In Biology, a Type represents a ``family'' of biological components 
 * (either primitive or composites).
 * 
 * In Languages and Compilers, a ComponentType represents a Non-Terminal.
 * 
 * @author Ernst Oberortner
 */
public class Nonterminal 
	extends Symbol {
	
    /**
     * Creates a new nonterminal symbol with the given name, which must not be
     * null or the empty string.
     *
     * @param name The name of the type.
     */
    public Nonterminal(String name) {
        super(name, false);
    }
}