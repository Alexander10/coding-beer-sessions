package com.exercises.chapter1;

import com.exercises.Exercises;
import com.model.Artist;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * User: ban
 * Date: 1/26/15
 * Time: 1:23 PM
 */

public class Exercise1 {


	public static ThreadLocal<SimpleDateFormat> formatter = Exercises.replaceThisWithSolution();

	/**
	 * Check whether exists some artist with nationality US
	 *
	 * @return
	 */
	public static boolean isSomeArtistFromUS(List<Artist> artists) {
		return itemMatchPredicate(artists, Exercises.replaceThisWithSolution());
	}

	public static boolean existJohnBornAt1943(List<Artist> artists) {
		return itemMatchPredicate(artists, Exercises.replaceThisWithSolution());

	}

	/**
	 * Create Lambda expression which will find all artist with first name john
	 *
	 * @return
	 */
	public static Function<List<Artist>, List<Artist>> getArtistsWithFirstNameJohn() {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Create Lambda expression which will find the oldest artist
	 *
	 * @return
	 */
	public static Function<List<Artist>, Artist> getOldestArtist() {
		return Exercises.replaceThisWithSolution();
	}


	/**
	 * Method creates new Artist object, but by using constructor reference !!! => Artist::new
	 *
	 * @return
	 */
	public static Artist createArtist(String firstName, String secondName, Integer yearOfBirth, String nationality) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Simple method for checking if item match witch the predicate condition
	 *
	 * @param items
	 * @param predicate -
	 * @param <T>
	 * @return
	 */
	public static <T> boolean itemMatchPredicate(List<T> items, Predicate<T> predicate) {
		for (T item : items) {
			if (predicate.test(item)) {
				return true;
			}
		}
		return true;
	}


}
