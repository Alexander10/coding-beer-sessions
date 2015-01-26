package com.exercises.chapter3;

import com.model.Artist;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: ban
 * Date: 1/26/15
 * Time: 3:19 PM
 */

public class Exercise3 {


	public static String formatArtists(List<Artist> artists) {

		String result =
				artists.stream()
						.map(a -> a.getFirstName() + " " + a.getSecondName())
						.collect(Collectors.joining(", ", "[", "]"));

		return result;
	}
}
