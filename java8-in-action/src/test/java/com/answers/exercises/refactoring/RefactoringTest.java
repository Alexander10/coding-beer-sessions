package com.answers.exercises.refactoring;

import com.answers.refactoring.chainofresponsibility.HeaderTextProcessing;
import com.answers.refactoring.chainofresponsibility.ProcessingObject;
import com.answers.refactoring.chainofresponsibility.SpellCheckerProcessing;
import com.answers.refactoring.observer.Feed;
import com.answers.refactoring.observer.Guardian;
import com.answers.refactoring.observer.LeMonde;
import com.answers.refactoring.observer.NYTimes;
import com.answers.refactoring.strategy.IsAllLowerCase;
import com.answers.refactoring.strategy.IsNumeric;
import com.answers.refactoring.strategy.Validator;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 2:47 PM
 */

public class RefactoringTest {

	@Test
	public void testStrategy() {
		String input = "aaaa";
		Validator numericValidator = new Validator(new IsNumeric());
		boolean b1 = numericValidator.validate(input);

		Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
		boolean b2 = lowerCaseValidator.validate(input);

		boolean b1Lambda = new Validator((String str) -> str.matches("\\d+")).validate(input);

		boolean b2Lambda = new Validator((str) -> str.matches("[a-z]+")).validate(input);
	}

	@Test
	public void testObserver() {
		Feed f = new Feed();
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

		//lambda solution
		f.registerObserver((String tweet) -> {
			if (tweet != null && tweet.contains("money")) {
				System.out.println("Breaking news in NY! " + tweet);
			}
		});
		f.registerObserver((String tweet) -> {
			if (tweet != null && tweet.contains("queen")) {
				System.out.println("Yet another news in London... " + tweet);
			}
		});
	}

	public void chainOfResponsibility() {
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckerProcessing();
		p1.setSuccessor(p2);
		String result = p1.handle("Aren't labdas really sexy?!!");
		System.out.println(result);

		//lambda solution

		UnaryOperator<String> headerProcessing =
				(String text) -> "From Raoul, Mario and Alan: " + text;
		UnaryOperator<String> spellCheckerProcessing =
				(String text) -> text.replaceAll("labda", "lambda");
		Function<String, String> pipeline =
				headerProcessing.andThen(spellCheckerProcessing);
		String resultLambda = pipeline.apply("Aren't labdas really sexy?!!");
	}
}
