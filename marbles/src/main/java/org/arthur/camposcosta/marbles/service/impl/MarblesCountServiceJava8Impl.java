package org.arthur.camposcosta.marbles.service.impl;

import java.util.stream.IntStream;

import org.arthur.camposcosta.marbles.service.MarblesCountService;
import org.arthur.camposcosta.marbles.utils.MarblesUtils;

public class MarblesCountServiceJava8Impl implements MarblesCountService {

	/**
	  * {@inheritDoc}
	  * 
	  * Calculate the count using classic java loop
	  */
	@Override
	public int getNumberAlternatives(int[] marbleBoxes) {
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
					return MarblesUtils.getCountCurrentBoxes(marbleBoxes[currentBoxIndex], marbleBoxes[comparedBoxIndex]);
				}
			// We sum up all the elements of the stream 
			)).sum();
	}
}
