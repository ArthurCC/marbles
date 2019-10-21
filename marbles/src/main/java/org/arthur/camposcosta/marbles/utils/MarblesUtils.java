package org.arthur.camposcosta.marbles.utils;

/**
 * Class utils for processing operations on marble boxes
 * @author Arthur
 *
 */
public class MarblesUtils {
	
	/**
	 * Sum up all the different combinations between two boxes
	 * @param currentBoxCount superior than 0
	 * @param comparedBoxCount superior than 0
	 * @return the sum of all different combinations
	 */
	public static int getCountCurrentBoxes(int currentBoxCount, int comparedBoxCount) {
		if(currentBoxCount > 1 && comparedBoxCount > 1) {
			// we do -1 on the compared box count to remove duplicates
			if (currentBoxCount <= comparedBoxCount) {
				return currentBoxCount * (comparedBoxCount - 1);
			}
			else {
				return (currentBoxCount - 1) * comparedBoxCount;
			}
		}
		else {
			// if one box has only one marble we substract 1 to the total
			return currentBoxCount * comparedBoxCount - 1;
		}
	}
}
