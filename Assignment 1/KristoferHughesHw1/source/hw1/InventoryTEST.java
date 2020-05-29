package hw1;
//Kristofer Hughes
//SE 350
import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.HashSet;

// TODO:  complete the tests
@SuppressWarnings("deprecation")
public class InventoryTEST extends TestCase {
  public InventoryTEST(String name) {
    super(name);
  }
  InventorySet s = new InventorySet();
  VideoObj firstobj = new VideoObj( "A", 2020, "B");
  VideoObj secobj = new VideoObj( "B", 2020, "B");

  @Test
  public void testSize() {
	  Assert.assertEquals(0,  s.size());
	  s.addNumOwned(firstobj, 1);
	  Assert.assertEquals(1,  s.size());
	  s.addNumOwned(firstobj, 2);
	  Assert.assertEquals(1,  s.size());
	  s.addNumOwned(secobj, 1);
	  Assert.assertEquals(2,  s.size());
	  s.addNumOwned(secobj, -1);
	  Assert.assertEquals(1,  s.size());
	  s.addNumOwned(firstobj, -3);
	  Assert.assertEquals(0,  s.size());
	  try { 
		  s.addNumOwned(firstobj, -3);
	  } catch (IllegalArgumentException e){}
	  Assert.assertEquals( 0, s.size());
  }
@Test
  public void testAddNumOwned() {
	  Assert.assertEquals( 0, s.size() );
	  s.addNumOwned(firstobj, 1);
	  Assert.assertEquals( firstobj, s.get(firstobj).video);
	  Assert.assertEquals( 1, s.get(firstobj).numOwned );
  }

@Test
  public void testCheckOutCheckIn() {
    // TODO
	 s.addNumOwned(firstobj, 5);
     s.checkOut(firstobj);
     s.checkOut(firstobj);
     Assert.assertEquals( 2, s.get(firstobj).numOut );
     Assert.assertEquals( 5, s.get(firstobj).numOwned );
     s.checkIn(firstobj);
     Assert.assertEquals( 1, s.get(firstobj).numOut );
     Assert.assertEquals( 5, s.get(firstobj).numOwned );
     try {
         s.checkOut(secobj);
         fail();
     } catch (IllegalArgumentException e) { }
 
     try {
         s.checkOut(secobj);
         fail();
     } catch (IllegalArgumentException e) { }
}

@Test
  public void testClear() {
	  s.clear();
	  Assert.assertEquals(s.size(), 0);
  }

@Test
  public void testGet() {
    // TODO
	  Assert.assertEquals(null,s.get(firstobj));
	  s.addNumOwned(firstobj, 2);
	  s.checkOut(firstobj);
	  Record testRec = new Record(firstobj,2,1,0);
  }

@Test
  public void testToCollection() {
	  InventorySet set = new InventorySet();
		VideoObj obj = new VideoObj("El Mariachi", 1996, "Rodriguez");
		set.addNumOwned(obj, 10);
		set.equals(set.toCollection());
      
}

  }
