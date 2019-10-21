package org.arthur.camposcosta.marbles.utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized test class for the class MarbleUtils
 * This class is used for test that can be Parameterized as simple test (input, result)
 * @author Arthur
 *
 */
@RunWith(Parameterized.class)
public class MarblesUtilsParameterizedTest {
	
	/**
	 * input as the marble boxes array that we want to test
	 */
	private int[] marbleBoxes;
	
	/**
	 * expected result as the count of alternative marbles
	 */
	private int count;
	
	/**
	 * Constructor of the class
	 * @param marbleBoxes
	 * @param count
	 */
	public MarblesUtilsParameterizedTest(int[] marbleBoxes, int count) {
		this.marbleBoxes = marbleBoxes;
		this.count = count;
	}
	
	/**
	 * Parameters as {input, expected_result}
	 * @return
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			/**
			 * Test for no box
			 * Alternative should be 0 as there's no box
			 */
			{new int[] {}, 0},
			
			/**
			 * Test for one box
			 * Alternative should be 0 as we cannot pick 2 marbles from same box
			 */
			{new int[] {3}, 0},
			
			/**
			 * Test for one empty box
			 * Alternative should be 0 as the box is Empty
			 */
			{new int[] {0}, 0},
			
			/**
			 * Test for multiple empty box
			 * Alternative should be 0 as boxes are Empty
			 */
			{new int[] {0, 0, 0}, 0},
			
			/**
			 * Test for two boxes with first empty
			 * Alternative should be 0 as one box is empty
			 */
			{new int[] {0, 2}, 0},
			
			/**
			 * Test for two boxes with second empty
			 * Alternative should be 0 as one box is empty
			 */
			{new int[] {2, 0}, 0},
			
			/**
			 * Test for multiple boxes with one element in each
			 * Alternative should be 0 as there is only one marble in each box
			 */
			{new int[] {1, 1, 1}, 0},
			
			/**
			 * Test for two boxes with random numbers
			 * box 1 = 2, box 2 = 3 Alternative should be 4 (1,2) (1,3) (2,1) (2,3)
			 */
			{new int[] {2, 3}, 4},
			
			/**
			 * Test for two boxes with first box having one marble
			 * box 1 = 2, box 2 = 1 Alternative should be 1 (1,2)
			 */
			{new int[] {1, 2}, 1},
			
			/**
			 * Test for two boxes with second box having one marble
			 * box 1 = 2, box 2 = 1 Alternative should be 1 (2,1)
			 */
			{new int[] {2, 1}, 1}
		});
	}
	
	/**
	 * Test of the method getNumberAlternative
	 * @throws MarblesIllegalCountException
	 */
	@Test
	public void testGetNumberAlternative() {
		assertEquals(count, MarblesUtils.getNumberAlternative(marbleBoxes));
	}
	
	@Test
	public void testGetNumberAlternativeStream() {
		assertEquals(count, MarblesUtils.getNumberAlternativeStream(marbleBoxes));
	}
}
