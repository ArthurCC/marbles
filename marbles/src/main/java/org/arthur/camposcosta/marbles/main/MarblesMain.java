package org.arthur.camposcosta.marbles.main;

import java.util.Scanner;

import org.arthur.camposcosta.marbles.main.utils.ScannerUtils;
import org.arthur.camposcosta.marbles.service.MarblesCountService;
import org.arthur.camposcosta.marbles.service.impl.MarblesCountServiceImpl;
import org.arthur.camposcosta.marbles.service.impl.MarblesCountServiceJava8Impl;

/**
 * Main class of the application that runs the main method
 * @author Arthur
 *
 */
public class MarblesMain {

	/**
	 * Main method of the project that showcase the application usage
	 * @param args args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// we ask the user the number of boxes and the number of marbles in each box
		int[] marbleBoxes = askMarbleBoxesCount(sc, askBoxCount(sc));
		
		// Close the scanner
		sc.close();
		
		// Instanciation of count services
		MarblesCountService countService = new MarblesCountServiceImpl();
		MarblesCountService countServiceJava8 = new MarblesCountServiceJava8Impl();
		
		// Print result
		System.out.println("Number of alternative : " + countService.getNumberAlternatives(marbleBoxes));
		System.out.print("Number of alternative using Java 8 streams : " + countServiceJava8.getNumberAlternatives(marbleBoxes));
	}
	
	/**
	 * Asks the user the number of marble boxes
	 * @param sc
	 * @return the number of boxes inputed by the user
	 */
	private static int askBoxCount(Scanner sc) {
		return ScannerUtils.checkNumberInput(sc, "input number of boxes (positive number) : ");
	}
	
	/**
	 * Asks the user the number of marbles in each box
	 * @param sc
	 * @param boxCount
	 * @return
	 */
	private static int[] askMarbleBoxesCount(Scanner sc, int boxCount) {
		int[] marbleBoxes = new int[boxCount];
		if (boxCount > 0) {
			for (int i = 0; i < boxCount; i++) {
				marbleBoxes[i] = ScannerUtils.checkNumberInput(sc, "input number of marbles in box " + (i + 1) + " (positive number) : ");
			}
		}
		
		return marbleBoxes;
	}
}
