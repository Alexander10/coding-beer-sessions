package com.erni.java8.answers.chapter1;

import com.erni.java8.model.Artist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			final Artist returnArtist;
			artists.forEach(art -> {
				if (isSpecificItem(artists, (Artist artInner) -> artInner.getYearOfBirth() > art.getYearOfBirth())) {
					returnArtist = art;
				}
			});
			return returnArtist;
		};
	}


}
