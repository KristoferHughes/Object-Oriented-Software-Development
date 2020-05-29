//Kristofer Hughes
package secondHW;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class AssertTEST extends TestCase {
		  public AssertTEST(String name) {
		    super(name);
		  }
		  @Test
			public void testMinValue() {
				assertEquals(AssertExp1.minValue(new double[]{19, 97, 12, 31, 8, 2, 90}),2,0);
				assertEquals(AssertExp1.minValue(new double[]{-19, 97, 12, 31, 8, 2, 90 }),-19,0);
				assertEquals(AssertExp1.minValue(new double[]{19, 97, 12, 31, 8, 5, 90}), 5,0);
				
			}

			@Test
			public void testMinPosition() {
				assertEquals(AssertExp1.minPosition(new double[] {-19}),0,0);
				assertEquals(AssertExp1.minPosition(new double[] {-19, -5, -9, 9, 10, 12}),0,0);
				assertEquals(AssertExp1.minPosition(new double[] {1, -9, -5, 5, 10, 30, -3}),1,0);
				assertEquals(AssertExp1.minPosition(new double[] {19, 97, 12, 31, 8, 5, 90}),5,0);
				assertEquals(AssertExp1.minPosition(new double[] {23, -19, -5, 5, 40, 12, -7}),1,0);
				
			}

			@Test
			public void testNumUnique() {
				assertEquals(AssertExp1.numUnique(new double[] { }),0,0);
				assertEquals(AssertExp1.numUnique(new double[] {19}),1,0);
				assertEquals(AssertExp1.numUnique(new double[] {19, 19}),1,0);
				assertEquals(AssertExp1.numUnique(new double[] {19, 19, 19, 97, 97, 97, 12, 12, 12, 31, 31, 31, 8}),5,0);
				assertEquals(AssertExp1.numUnique(new double[] {19, 97, 12, 31, 8, 5, 90}),7,0);	
				
			}

			@Test
			public void testRemoveDuplicates() {
				assertEquals(Arrays.toString(AssertExp1.removeDuplicates(new double[] {19})), Arrays.toString(new double[] {19}));
				assertEquals(Arrays.toString(AssertExp1.removeDuplicates(new double[] {19, 19})), Arrays.toString(new double[] {19}));
				assertEquals(Arrays.toString(AssertExp1.removeDuplicates(new double[] {19, 19, 19, 97, 97, 97, 12, 12, 12, 31, 31, 31, 8})), Arrays.toString(new double[] {19, 97, 12, 31, 8}));
				
			}

		}