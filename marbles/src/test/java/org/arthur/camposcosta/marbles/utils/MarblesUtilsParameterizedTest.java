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
 * @author Arthur
 *
 */
@RunWith(Parameterized.class)
public class MarblesUtilsParameterizedTest {
	
	/**
	 * count for the current boxCount
	 */
	private int currentBoxCount;
	
	/**
	 * count for the compared boxCount
	 */
	private int comparedBoxCount;
	
	/**
	 * expected result as the count of alternative marbles
	 */
	private int count;

	/**
	 * Constructor of the class
	 * @param currentBoxCount
	 * @param comparedBoxCount
	 */
	public MarblesUtilsParameterizedTest(int currentBoxCount, int comparedBoxCount, int count) {
		this.currentBoxCount = currentBoxCount;
		this.comparedBoxCount = comparedBoxCount;
		this.count = count;
	}
	
	/**
	 * Parameters as {input1, input2, expected_result}
	 * 
	 * We don't test argument value = 0 because it has already been tested in the service method
	 * for MarblesCountService. We are not supposed to have value = 0 at this stage
	 * @return the collection of test case
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			/**
			 * Test with one marble each
			 * sum = 0
			 */
			{1, 1, 0},
			
			/**
			 * Test with box 1 = 1, box 2 = 2
			 * sum = 1
			 */
			{1, 2, 1},
			
			/**
			 * Test with box 1 = 2, box 2 = 1
			 * sum = 1
			 */
			{2, 1, 1},
			
			/**
			 * Test with box 1 = 2, box 2 = 2
			 * sum = 2
			 */
			{2, 2, 2},
			
			/**
			 * Test with box 1 = 2, box 2 = 3
			 * sum = 4
			 */
			{2, 3, 4},
			
			/**
			 * Test with box 1 = 3, box 2 = 2
			 * sum = 4
			 */
			{3, 2, 4},
			
			/**
			 * Test with box 1 = 3, box 2 = 3
			 * sum = 6
			 */
			{3, 3, 6},
			
			/**
			 * Test with box 1 = 3, box 2 = 4
			 * sum = 9
			 */
			{3, 4, 9},
			
			/**
			 * Test with box 1 = 4, box 2 = 3
			 * sum = 9
			 */
			{4, 3, 9}
		});
	}
	
	/**
	 * Test for the method getCountCurrentBoxes
	 */
	@Test
	public void testGetCountCurrentBoxes() {
		assertEquals(count, MarblesUtils.getCountCurrentBoxes(currentBoxCount, comparedBoxCount));
	}
}
