//Kristofer Hughes
package secondHW;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;



public class MyLinkedTEST extends TestCase{
	  public MyLinkedTEST(String name) {
		    super(name);
		  }
	@Test
	public void testDelete() {
		MyLinked b = new MyLinked ();
        b.add (1);
        b.delete (0);
        assertEquals(0, b.size());
        for (double i = 1; i < 13; i++) {
            b.add (i);
        }
        assertEquals(12, b.size()); 
        b.delete (0); //"deleted at beginning"
        assertEquals(11, b.size()); 
        b.delete (10); //"deleted at end"
        assertEquals(10, b.size()); 
        b.delete (4); //"deleted in middle"
        assertEquals(9, b.size());
	}

	@Test
	public void testReverse() {
		MyLinked b = new MyLinked ();
		b.reverse (); //reverse empty",
        b.add (1); //"singleton"
        assert (b != null);
        b.reverse (); //"reverse singleton"
        b.add (2); //"two"
        assertEquals(2, b.size());
        b.reverse (); //"reverse two"
        b.reverse (); //"reverse again""
        for (double i = 3; i < 7; i++) {
            b.add (i);
            b.add (i);
        }
        assertEquals(10, b.size()); //"bigger list"
        b.reverse (); //"reversed"
	}	
	
	@Test
	public void testRemove() {
		MyLinked b = new MyLinked ();
        b.remove (4); ////"removed 4 from empty"
        b.add (1);
        b.remove (4);
        assertEquals(1, b.size());  //"removed 4 from singelton
        b.remove (1); //"removed 1 from singelton"
        assertEquals(0, b.size());
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
        }
        assertEquals(8, b.size());
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
        }
        assertEquals(28, b.size()); //"longer list",
        b.remove (9); //"removed all 9s"
        assertEquals(28, b.size()); 
        b.remove (3); //"removed all 3s"
        assertEquals(21, b.size());
        b.remove (1); //"removed all 1s"
        assertEquals(14, b.size());
        b.remove (4); //"removed all 4s"
        assertEquals(7, b.size());
        b.remove (2); //"removed all 2s
        assertEquals(0, b.size()); //should be empty
		
	}
}