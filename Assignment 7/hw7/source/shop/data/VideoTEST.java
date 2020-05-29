package shop.data;

import junit.framework.Assert;
import junit.framework.TestCase;

// TODO:  complete the tests
public class VideoTEST extends TestCase {
  public VideoTEST(String name) {
    super(name);
  }
  public void testEquals() { 
	  VideoObj v1 = new VideoObj("Halloween", 1972, "John Carpenter");
      VideoObj v2 = new VideoObj("Halloween", 1972, "John Carpenter");
      assertTrue(v1.equals(v2));
      v2 = new VideoObj("Thing", 1997, "John Carpenter");
      assertFalse(v1.equals(v2));
  }

  public void testCompareTo() { 
  
	  VideoObj v1 = new VideoObj("Halloween", 1994, "Carpenter");
      VideoObj v2 = new VideoObj("Halloween", 1994, "Carpenter");
      assertEquals(v1.compareTo(v2), 0);
      v2 = new VideoObj("My name", 1994, "Carpenter");
      assertTrue(v1.compareTo(v2) < 0);
      v2 = new VideoObj("Check", 1994, "Carpenter");
      assertTrue(v1.compareTo(v2) > 0);
      v2 = new VideoObj("Halloween", 1995, "Carpenter");
      assertTrue(v1.compareTo(v2) < 0);
      v2 = new VideoObj("Halloween", 1993, "Kristofer");
      assertTrue(v1.compareTo(v2) > 0);
      v2 = new VideoObj("Halloween", 1994, "John");
      assertTrue(v1.compareTo(v2) < 0);
  }

  public void testToString() { 
  
      VideoObj v1 = new VideoObj("Halloween", 1972, "John Carpenter");
      assertEquals(v1.toString(), "Halloween (1972) : John Carpenter");
  }

  public void testHashCode() {
    Assert.assertEquals
      (-875826552,
       new VideoObj("None", 2009, "Zebra").hashCode());
    Assert.assertEquals
      (-1391078111,
       new VideoObj("Blah", 1954, "Cante").hashCode());
  }
}
