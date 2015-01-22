package com.exercises.refactoring.chainofresponsibility;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:13 PM
 */

public class HeaderTextProcessing extends ProcessingObject<String> {
	@Override
	protected String handleWork(String input) {
		return "Some text" + input;
	}
}
