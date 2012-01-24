package pl.edu.amu.wmi.daut.base;

import java.util.HashSet;
import java.util.Arrays;
import junit.framework.TestCase;

/**
* Test metody makeMultiples
*/
public class TestMakeMultiples extends TestCase {
/**
* Pierwszy test. Wielokrotnosci 5
*/
    public final void test1() {
       
        
	final AutomatonByStack automat_pierwszy = new AutomatonByStack(AutomatonSpecification.makeMultiples('a',5));
	      
        assertTrue(automat_pierwszy.accepts(""));
        assertTrue(automat_pierwszy.accepts("aaaaa"));
        assertTrue(automat_pierwszy.accepts("aaaaaaaaaa"));
        assertTrue(automat_pierwszy.accepts("aaaaaaaaaaaaaaa"));
        assertFalse(automat_pierwszy.accepts("aaaaaaaaaaaaaa"));
        assertFalse(automat_pierwszy.accepts("bbbbbbbbaaaaac"));
        assertFalse(automat_pierwszy.accepts("bbbbbbbbaaaaaaaaa"));
        
   }
/**
* Drugi test.Wielokrotnosci 1
*/
    public final void test2() {
       
        
	final AutomatonByStack automat_drugi = new AutomatonByStack(AutomatonSpecification.makeMultiples('a',1));
	      
        assertTrue(automat_drugi.accepts(""));
        assertTrue(automat_drugi.accepts("a"));
        assertTrue(automat_drugi.accepts("aaaaaaaaaa"));
        assertTrue(automat_drugi.accepts("aaaaaaaaaaaaaaa"));
        assertTrue(automat_drugi.accepts("aaaaaaaaaaaaaa"));
        assertFalse(automat_drugi.accepts("bbbbbbbbaaaaac"));
        assertFalse(automat_drugi.accepts("bbbbbbbbaaaaaaaaa"));
        
   }
/**
* Trzeci test.Wielokrotnosci 2
*/  
  public final void test3() {
       
        
	final AutomatonByStack automat_trzeci = new AutomatonByStack(AutomatonSpecification.makeMultiples('a',2));
	      
        assertTrue(automat_trzeci.accepts(""));
        assertTrue(automat_trzeci.accepts("aa"));
        assertTrue(automat_trzeci.accepts("aaaaaaaaa"));
        assertTrue(automat_trzeci.accepts("aaaaaaaaaaaaaa"));
        assertFalse(automat_trzeci.accepts("a"));
        assertFalse(automat_trzeci.accepts("bbbbbbbbaaaaac"));
        assertFalse(automat_trzeci.accepts("bbbbbbbbaaaaaaaaa"));
        assertFalse(automat_trzeci.accepts("aaa"));
   }
}
