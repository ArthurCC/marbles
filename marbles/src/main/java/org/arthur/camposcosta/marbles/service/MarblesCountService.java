package org.arthur.camposcosta.marbles.service;

/**
 * Interface that defines the method to count the possible alternatives between marble boxes
 * @author Arthur
 *
 */
public interface MarblesCountService {
	
	/**
	 * Method that takes an array of integer that corresponds to the number of marbles in each box
	 * return the number of possible combinations of two marbles that has a different number
	 * @param marbleBoxes the marble boxes array
	 * @return the number of possible combinations
	 */
	int getNumberAlternatives(int[] marbleBoxes);
}
