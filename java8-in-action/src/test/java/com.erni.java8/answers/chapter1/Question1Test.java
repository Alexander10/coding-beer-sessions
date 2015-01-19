package com.erni.java8.answers.chapter1;


import com.answers.chapter1.Question1;

import com.model.Artist;
import com.model.SampleData;
import org.junit.Test;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:22 AM
 */

public class Question1Test {

	private List<Artist> data = SampleData.membersOfTheBeatles;

	@Test
	public void simpleFunctionalInterface() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 19);
		String formatted = Question1.formatter.get().format(cal.getTime());
		assertEquals("19.Jan.2015", formatted);
	}

	@Test
	public void isSomeArtistFromUS() {
		assertTrue(Question1.isSpecificItem(data, (Artist artist) -> artist.isFrom("US")));
	}

	@Test
	public void existJohnBornAt1943() {
		assertTrue(Question1.isSpecificItem(data, ((Artist artist) -> artist.getFirstName().equals("John") && artist.getYearOfBirth() == 1943)));
	}

	@Test
	public void sortDataASCByFirstName() {

		assertEquals("John", data.get(0).getFirstName());
		Comparator<Artist> sortArtists = (Artist a1, Artist a2) -> a1.getFirstName().compareTo(a2.getFirstName());
		data.sort(sortArtists);
		assertEquals("George", data.get(0).getFirstName());

	}

	@Test
	public void isJohnOldestMan() {
		//This is a bit stupid example but please first create lambda for fetching Artist with John name
		Function<List<Artist>, List<Artist>> johnsFunc = Question1.getFuncForJohns();
		//Create another lambda which will be fetching artist year of birth for the oldest man
		Function<List<Artist>, Artist> oldestNameFunc = Question1.getFuncForTheOldestArtist();

		Function<List<Artist>, String> finalFunc = null;

		assertEquals(finalFunc.apply(data), "John");
	}
}
