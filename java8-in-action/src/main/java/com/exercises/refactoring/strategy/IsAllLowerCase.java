package com.exercises.refactoring.strategy;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 2:45 PM
 */

public class IsAllLowerCase implements ValidationStrategy{
	@Override
	public boolean execute(String s) {
		return s.matches("[a-z]+");
	}
}
