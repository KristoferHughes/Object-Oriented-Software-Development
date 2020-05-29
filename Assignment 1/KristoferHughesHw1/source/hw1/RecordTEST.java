package hw1;
//Kristofer Hughes
//SE 350
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class RecordTEST extends TestCase {
  public RecordTEST(String name) {
    super(name);
  }

  @Test
  public void testCopy() {
    // be sure to test that copy returns a NEW reference!
    VideoObj video = new VideoObj( "A", 2000, "B" );
    Record r1 = new Record( video, 20, 10, 300 );
    Record r2 = r1.copy();
    Assert.assertTrue( r1 != r2 );
    Assert.assertTrue( r1.toString().equals(r2.toString()) );
  }
}
