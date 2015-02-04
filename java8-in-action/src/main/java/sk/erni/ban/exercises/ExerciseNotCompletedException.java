package sk.erni.ban.exercises;

/**
 * User: ban
 * Date: 1/26/15
 * Time: 1:17 PM
 */

public class ExerciseNotCompletedException extends RuntimeException {

	public ExerciseNotCompletedException(){
		super("Please remove this line of code and implement the exercise");
	}
}
