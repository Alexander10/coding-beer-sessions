package com.answers.chapter1;



import com.model.Album;
import com.model.Artist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:15 AM
 */

public class Question1 {

	public static ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MMM.yyyy"));

	/**
	 * Simple method for checking if item match witch the predicate condition
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

	/**
	 * Find all artist with first name John
	 * @return
	 */
	public static Function<List<Artist>, List<Artist>> getArtistsWithNameJohn() {
		return (List<Artist> artists) -> {
			List<Artist> johns = new ArrayList<>();
			artists.forEach(art -> {
				if ("John".equalsIgnoreCase(art.getFirstName())) johns.add(art);
			});
			return johns;
		};
	}

	public static Function<List<Artist>, Artist> getOldestArtist() {
		return (List<Artist> artists) -> {
			for(Artist art : artists){
				if (itemMatchPredicate(artists, (Artist artInner) -> artInner.getYearOfBirth() > art.getYearOfBirth())) {
					return art;
				}
			}
			return null;
		};
	}

	public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
		return albums.collect(groupingBy(Album::getMainMusician));
	}



	/**
	 * Method creates new Artist object, but by using following syntax Artist::new
	 * you have to create proper Functional interface
	 * @return
	 */
	public static Artist createArtistWithLambdas(){

		FourFunction<String, String, Integer, String, Artist> fourFunctions = Artist::new;
		return fourFunctions.apply("Meky", "Zbirka", 1960, "SK");
	}

	/**
	 * Sort artist by first name
	 * Because there can exist more artists with the same name sort artists also by second name
	 * @return
	 */
	public static List<Artist> doubleSort(List<Artist> artists){
		artists.sort(Comparator.comparing((Artist a) -> a.getFirstName()).thenComparing(Artist::getSecondName));
		return artists;
	}


}
