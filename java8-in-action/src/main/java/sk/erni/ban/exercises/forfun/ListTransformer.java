package sk.erni.ban.exercises.forfun;



import sk.erni.ban.exercises.Exercises;

import java.util.List;

/**
 * User: ban
 * Date: 2/4/15
 * Time: 10:07 AM
 */

public class ListTransformer {

	private final List<String> values;

	private ListTransformer(List<String> values) {
		this.values = values;
	}

	public static ListTransformer of(List<String> values) {

		return new ListTransformer(values);
	}

	/**
	 * This method should take the String List and sort all the String elements in ascending (ASCII) order.
	 *
	 * @return The sorted values in ascending ASCII order.
	 */
	public List<String> getSortedStrings() {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * This method should take the String List and:
	 * <ol>
	 * <li>filter the elements that contains one or more digits;</li>
	 * <li>transform (map) the remaining Strings into Integers;</li>
	 * <li>sort the Integers in ascending order.</li>
	 * </ol>
	 *
	 * @return
	 */
	public List<Integer> getSortedIntegers() {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * This method should take the String List and:
	 * <ol>
	 * <li>filter the elements that contains one or more digits;</li>
	 * <li>transform (map) the remaining Strings into Integers;</li>
	 * <li>sort the Integers in descending order.</li>
	 * </ol>
	 *
	 * @return
	 */
	public List<Integer> getSortedDescendingIntegers() {
		return Exercises.replaceThisWithSolution();
	}
}
