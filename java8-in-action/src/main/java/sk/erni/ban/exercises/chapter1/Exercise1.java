package sk.erni.ban.exercises.chapter1;

import sk.erni.ban.exercises.Exercises;
import sk.erni.ban.model.Artist;

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
	 * Checks whether the artist comes from US
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
	 * Creates Lambda expression which will find all artists named john
	 *
	 * @return
	 */
	public static Function<List<Artist>, List<Artist>> getArtistsWithFirstNameJohn() {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Creates Lambda expression which will find the oldest artist
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


	public static Function<List<Artist>, String> concate(Function<List<Artist>, List<Artist>> f, Function<List<Artist>,Artist> g){
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Simple method for checking if item match with the predicate condition
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
