package pl.edu.amu.wmi.daut.base;

import java.util.HashSet;
import java.util.Arrays;
import junit.framework.TestCase;

/**
* Test metody makeMultiples
*/
public class TestMakeMultiples extends TestCase {
/**
* Pierwszy test.
*/
    public final void test1() {
       final AutomatonSpecification spec = new NaiveAutomatonSpecification();

	spec.makeMultiples("a",5);
	final AutomatonByStack automaton = new AutomatonByStack(spec);
	
        State q0a = spec.addState();
        State q1a = spec.addState();
        State q2a = spec.addState();
        State q3a = spec.addState();
        State q4a = spec.addState();
        State q5a = spec.addState();
     

        assertTrue(automaton.accepts(""));

        assertTrue(automaton.accepts("aaaaa"));
        assertTrue(automaton.accepts("aaaaaaaaaa"));
        assertTrue(automaton.accepts("aaaaaaaaaaaaaaa"));
        assertFalse(automaton.accepts("aaaaaaaaaaaaaa"));
        assertFalse(automaton.accepts("bbbbbbbbaaaaac"));
        assertFalse(automaton.accepts("bbbbbbbbaaaaaaaaa"));
        
   }

}
