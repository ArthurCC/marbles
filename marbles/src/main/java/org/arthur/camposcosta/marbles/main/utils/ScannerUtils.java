package org.arthur.camposcosta.marbles.main.utils;

import java.util.Scanner;

/**
 * Util class to verify the user input with the Scanner
 * @author Arthur
 *
 */
public class ScannerUtils {
	
	/**
	 * Checks if the user input is an int superior than 0
	 * @param sc the scanner
	 * @param message the message to print on the console
	 * @return the user input as an integer
	 */
	public static int checkNumberInput(Scanner sc, String message) {
		int input;
		System.out.print(message);
		
		do {
			while (!sc.hasNextInt()) {
				sc.next();
			}
			input = sc.nextInt();
		} while (input < 0);
		
		return input;
	}
}
