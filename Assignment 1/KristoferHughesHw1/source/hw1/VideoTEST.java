package hw1;
//Kristofer Hughes
//SE 350
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

// TODO:  complete the tests
@SuppressWarnings("deprecation")
public class VideoTEST extends TestCase {
  public VideoTEST(String name) {
    super(name);
  }
  
  @Test
  public void testConstructorAndAttributes() {
    String title1 = "XX";
    String director1 = "XY";
    String title2 = " XX ";
    String director2 = " XY ";
    int year = 2002;

    VideoObj v1 = new VideoObj(title1, year, director1);
    Assert.assertSame(title1, v1.title());
    Assert.assertEquals(year, v1.year());
    Assert.assertSame(director1, v1.director());

    VideoObj v2 = new VideoObj(title2, year, director2);
    Assert.assertEquals(title1, v2.title());
    Assert.assertEquals(director1, v2.director());
  }

  @Test
  public void testConstructorExceptionYear() {
    try {
      new VideoObj("X", 1800, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("X", 5000, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("X", 1801, "Y");
      new VideoObj("X", 4999, "Y");
    } catch (IllegalArgumentException e) {
      Assert.fail();
    }
  }

  @Test
  public void testConstructorExceptionTitle() {
	  try {
	      new VideoObj(null, 2002, "Y");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj("", 2002, "Y");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj(" ", 2002, "Y");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  }

  @Test
  public void testConstructorExceptionDirector() {
	  try {
	      new VideoObj(null, 2002, "Y");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj("", 2002, "Y");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj(" ", 2002, "Y");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  }
  
  @Test
  public void testHashCode() {
    Assert.assertEquals
      (-875826552,
       new VideoObj("None", 2009, "Zebra").hashCode());
    Assert.assertEquals
      (-1391078111,
       new VideoObj("Blah", 1954, "Cante").hashCode());
  }

  @Test
  public void testEquals() { 
	  VideoObj video = new VideoObj("El Mariachi", 1996, "Rodriguez");
	  Assert.assertTrue(video.title().equals("El Mariachi"));
	  }

  @Test
  public void testCompareTo() { 
	  VideoObj v1 = new VideoObj("Hello", 1999, "Hey");
	  VideoObj v2 = new VideoObj("Hey", 1999, "Hello");
	  int comp_result = v1.title().compareTo(v2.title());
	  assert (comp_result != v1.compareTo(v2));
	  }

  @Test
  public void testToString() { 
	  VideoObj video =  new VideoObj("El Mariachi", 1996, "Rodriguez");
	  String test_result = video.toString();
	  String output = "El Mariachi (1996) : Rodriguez";
	
      Assert.assertEquals(test_result,output);
      }
}
