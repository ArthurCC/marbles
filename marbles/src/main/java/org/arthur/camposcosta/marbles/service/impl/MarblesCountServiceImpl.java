package org.arthur.camposcosta.marbles.service.impl;

import org.arthur.camposcosta.marbles.service.MarblesCountService;
import org.arthur.camposcosta.marbles.utils.MarblesUtils;

public class MarblesCountServiceImpl implements MarblesCountService {

	/**
	  * {@inheritDoc}
	  * 
	  * Calculate the count using Java 8 streams and lambdas
	  */
	@Override
	public int getNumberAlternatives(int[] marbleBoxes) {
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
						count += MarblesUtils.getCountCurrentBoxes(currentBoxCount, comparedBoxCount);
					}
				}
			}
		}
		
		return count;
	}
}
