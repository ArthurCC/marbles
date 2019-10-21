package org.arthur.camposcosta.marbles.main.utils;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.arthur.camposcosta.marbles.main.utils.ScannerUtils;
import org.junit.Test;

/**
 * Test class for the ScannerUtils class
 * @author Arthur
 *
 */
public class ScannerUtilsTest {

	/**
	 * Test for the method checkNumberInput
	 */
	@Test
	public void testCheckNumberInput() {
		// Scanner initialization
		// We create a manual input stream to simulate the user's input
		ByteArrayInputStream inputStream = new ByteArrayInputStream("a -1 1 2".getBytes());
		System.setIn(inputStream);
		Scanner sc = new Scanner(System.in);
		
		// Run
		int input = ScannerUtils.checkNumberInput(sc, "");
		sc.close();
		
		// Assert
		// The number should be the first integer in the input so 1
		assertEquals(1, input);
	}
}
