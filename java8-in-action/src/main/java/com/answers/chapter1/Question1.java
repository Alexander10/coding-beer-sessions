package com.answers.chapter1;



import com.model.Artist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:15 AM
 */

public class Question1 {

	public static ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MMM.yyyy"));

	public static <T> boolean isSpecificItem(List<T> items, Predicate<T> predicate) {
		for (T item : items) {
			if (predicate.test(item)) {
				return true;
			}
		}
		return true;
	}

	public static Function<List<Artist>, List<Artist>> getFuncForJohns() {
		return (List<Artist> artists) -> {
			List<Artist> johns = new ArrayList<>();
			artists.forEach(art -> {
				if ("John".equals(art.getFirstName())) johns.add(art);
			});
			return johns;
		};
	}

	public static Function<List<Artist>, Artist> getFuncForTheOldestArtist() {
		return (List<Artist> artists) -> {
			for(Artist art : artists){
				if (isSpecificItem(artists, (Artist artInner) -> artInner.getYearOfBirth() > art.getYearOfBirth())) {
					return art;
				}
			}
			return null;
		};
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
