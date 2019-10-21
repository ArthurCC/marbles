package org.arthur.camposcosta.marbles.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.arthur.camposcosta.marbles.service.MarblesCountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized test class for the different implementations of the Interface MarblesCountService
 * @author Arthur
 *
 */
@RunWith(Parameterized.class)
public class MarblesCountServiceTest {
	/**
	 * input as the marble boxes array that we want to test
	 */
	private int[] marbleBoxes;
	
	/**
	 * expected result as the count of alternative marbles
	 */
	private int count;
	
	/**
	 * the service to test
	 */
	private MarblesCountService countService;
	
	/**
	 * Constructor of the class
	 * @param marbleBoxes
	 * @param count
	 */
	public MarblesCountServiceTest(int[] marbleBoxes, int count) {
		this.marbleBoxes = marbleBoxes;
		this.count = count;
	}
	
	/**
	 * Parameters as {input, expected_result}
	 * @return the collection of test case
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
			 * Test for two boxes with random numbers and box 1 < box 2
			 * box 1 = 2, box 2 = 3 Alternative should be 4 (1,2) (1,3) (2,1) (2,3)
			 */
			{new int[] {2, 3}, 4},
			
			/**
			 * Test for two boxes with random numbers and box 1 > box 2
			 * box 1 = 2, box 2 = 3 Alternative should be 4 (1,2) (1,3) (2,1) (2,3)
			 */
			{new int[] {3, 2}, 4},
			
			/**
			 * Test for two boxes with random numbers and box 1 = box 2
			 * box 1 = 3, box 2 = 3 Alternative should be 6 (1,2) (1,3) (2,1) (2,3) (3,1) (3,2)
			 */
			{new int[] {3, 3}, 6},
			
			/**
			 * Test for two boxes with first box having one marble
			 * box 1 = 2, box 2 = 1 Alternative should be 1 (1,2)
			 */
			{new int[] {1, 2}, 1},
			
			/**
			 * Test for two boxes with second box having one marble
			 * box 1 = 2, box 2 = 1 Alternative should be 1 (2,1)
			 */
			{new int[] {2, 1}, 1},
			
			/**
			 * Test for more than two boxes with random numbers
			 * box 1 = 2, box 2 = 2, box 3 = 3
			 * Alternatives (1,2) (2,1) ((1,2) (1,3) (2,1) (2,3) * 2) = 10
			 */
			{new int[] {2, 2, 3}, 10},
			
			/**
			 * Test for more than two boxes with first box with 1 marble
			 * box 1 = 1, box 2 = 2, box 3 = 2
			 * Alternatives (1, 2) (1,2) (1,2) (2,1) = 4
			 */
			{new int[] {1, 2, 2}, 4},
			
			/**
			 * Test for more than two boxes with middle box with 1 marble
			 * box 1 = 2, box 2 = 1, box 3 = 2
			 * Alternatives (1, 2) (1,2) (1,2) (2,1) = 4
			 */
			{new int[] {2, 1, 2}, 4},
			
			/**
			 * Test for more than two boxes with last box with 1 marble
			 * box 1 = 2, box 2 = 2, box 3 = 1
			 * Alternatives (1, 2) (1,2) (1,2) (2,1) = 4
			 */
			{new int[] {2, 2, 1}, 4},
			
			/**
			 * Test for multiple boxes with 1, 0 and multiple marbles count
			 * box 1 = 2, box 2 = 0, box 3 = 1, box 4 = 2
			 * Alternatives (2,1) (1,2) (2,1) (1,2) = 4
			 */
			{new int[] {2, 0, 1, 2}, 4}
		});
	}
	
	/**
	 * Test of the method getNumberAlternatives for the normal implementation of the service
	 */
	@Test
	public void testGetNumberAlternative() {
		countService = new MarblesCountServiceImpl(); 
		assertEquals(count, countService.getNumberAlternatives(marbleBoxes));
	}
	
	/**
	 * Test of the method getNumberAlternatives for the Java 8 implementation of the service
	 */
	@Test
	public void testGetNumberAlternativeStream() {
		countService = new MarblesCountServiceJava8Impl();
		assertEquals(count, countService.getNumberAlternatives(marbleBoxes));
	}
}
