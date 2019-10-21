package org.arthur.camposcosta.marbles.utils;

import java.util.stream.IntStream;

/**
 * Class utils for processing operations on marble boxes
 * @author Arthur
 *
 */
public class MarblesUtils {
	
	/**
	 * Method that takes an array of integer that corresponds to the number of marbles in each box
	 * return the number of possible combinations of two marbles that has a different number
	 * @param marbleBoxes
	 * @return the number of possible combinations
	 */
	public static int getNumberAlternative(int[] marbleBoxes) {
		// if no or only one box, no alternatives
		if(marbleBoxes.length <= 1) {
			return 0;
		}
		
		int count = 0;
		// We iterate through each box
		for(int i = 0; i < marbleBoxes.length; i++) {
			
			int currentBoxCount = marbleBoxes[i];
			// no alternative if box empty
			if(currentBoxCount > 0) {
				// We iterate through each other box that comes after the current box
				// We don't take previous boxes because we already did that count 
				// and we don't want to count the alternatives for two boxes twice
				for(int j = i + 1; j < marbleBoxes.length; j++) {
					int comparedBoxCount = marbleBoxes[j];
					// no alternative if box empty
					if(comparedBoxCount > 0) {
						if(comparedBoxCount > 1) {
							// we do -1 on the compared box count to remove duplicates
							count += currentBoxCount * (comparedBoxCount - 1);
						}
						else {
							// the compared box has only one marble
							// we do minus 1 on the whole count to remove the only duplicate (1, 1)
							count += currentBoxCount * comparedBoxCount - 1;
						}
					}
				}
			}
		}
		
		return count;
	}
	
	/**
	 * Method that does the same process as the {@link #getNumberAlternative(int[])} method using Java 8 streams and lambda expressions
	 * @param marbleBoxes
	 * @return the number of possible combinations of two marbles with a different number
	 */
	public static int getNumberAlternativeStream(int[] marbleBoxes) {
		// if no or only one box, no alternatives
		if(marbleBoxes.length <= 1) {
			return 0;
		}
		
		// We stream the indexes of the array
		return IntStream.range(0, marbleBoxes.length)
			// We remove the indexes whose related box has no marbles
			.filter(index -> marbleBoxes[index] != 0)
			// We perform a map on each element which is going to return a stream with the counts for each box with the next other boxes
			.flatMap(currentBoxIndex -> 
				// We stream the indexes of the next boxes to calculate the count with the current box
				// We don't take previous boxes because we already did that count 
				IntStream.range(currentBoxIndex + 1, marbleBoxes.length)
				// We remove the boxes with no marbles
				.filter(index -> marbleBoxes[index] != 0)
				// We perform a map on every compared boxes and count the possibilities with the current box
				.map(comparedBoxIndex -> {
					if (marbleBoxes[comparedBoxIndex] > 1) {
						// we do -1 on the compared box count to remove duplicates
						return marbleBoxes[currentBoxIndex] * (marbleBoxes[comparedBoxIndex] - 1);
					} 
					else {
						// the compared box has only one marble
						// we do minus 1 on the whole count to remove the only ducplicate (1, 1)
						return marbleBoxes[currentBoxIndex] * marbleBoxes[comparedBoxIndex] - 1;
					}
				}
			// We sum up all the elements of the stream 
			)).sum();
	}
}
