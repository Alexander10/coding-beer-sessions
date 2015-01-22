package com.exercises.refactoring.strategy;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 2:44 PM
 */

public class IsNumeric implements ValidationStrategy {

	@Override
	public boolean execute(String s) {
		return s.matches("\\d+");
	}
}
