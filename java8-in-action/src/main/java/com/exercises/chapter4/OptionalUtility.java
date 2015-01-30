package com.exercises.chapter4;

import java.util.Optional;

/**
 * User: ban
 * Date: 1/23/15
 * Time: 2:32 PM
 */

public class OptionalUtility {

	public static Optional<Integer> stringToInt(String str) {
		try {
			return Optional.of(Integer.parseInt(str));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
}
