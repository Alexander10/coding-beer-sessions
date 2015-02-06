package sk.erni.ban.exercises.forfun;

import sk.erni.ban.exercises.Exercises;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * User: ban
 * Date: 2/4/15
 * Time: 5:32 PM
 */

public class Exercise {

	public static int countLowercaseLetters(String string) {
		return Exercises.replaceThisWithSolution();
	}


	public static Optional<String> mostLowercaseString(List<String> strings) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Fibonacci tuples series
	 * The series of Fibonacci tuples is similar; you have a sequence of a number and its successor in the series:
	 * (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)….
	 * Your task is to generate the first 20 elements of the series of Fibonacci tuples using the iterate method!
	 */
	public static List<Integer> fibonnacciSeries(int upperBound) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Method for generating all pythagorean triples
	 *
	 * @param upperBound -
	 */
	public static Stream<int[]> generatePythagoreanTriples(int upperBound) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Given two lists of numbers, how would you return all pairs of numbers? For example,
	 * given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3,3), (3, 4)].
	 * For simplicity, you can represent a pair as an array with two elements + return only pairs whose sum is divisible by 3
	 * @param upperBound -
	 */
	public static List<int[]> getPairsWhereSumIsDivisibleBy3(int upperBound) {
		return Exercises.replaceThisWithSolution();
	}


	/**
	 *
	 * @param upperBound
	 * @return
	 */
	public static Map<Boolean, List<Integer>> getPrimeAndNonPrimeNumbers(int upperBound) {
		return Exercises.replaceThisWithSolution();
	}
}
