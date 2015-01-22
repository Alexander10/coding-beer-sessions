package com.exercises.refactoring.chainofresponsibility;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:14 PM
 */

public class SpellCheckerProcessing extends ProcessingObject<String> {
	@Override
	protected String handleWork(String input) {
		return input.replaceAll("labda", "lambda");
	}
}
