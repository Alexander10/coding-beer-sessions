package sk.erni.ban.answers.refactoring.strategy;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 2:45 PM
 */

public class Validator {
	private final ValidationStrategy strategy;
	public Validator(ValidationStrategy v){
		this.strategy = v;
	}
	public boolean validate(String s){
		return strategy.execute(s);
	}
}
