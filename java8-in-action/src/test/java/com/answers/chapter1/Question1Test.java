package com.answers.chapter1;


import com.exercises.chapter1.Exercise1;
import com.model.Artist;
import com.model.SampleData;
import org.junit.Test;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:22 AM
 */

public class Question1Test {

	private List<Artist> artists = SampleData.membersOfTheBeatles;

	@Test
	public void dateFormatter() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 19);
		String formatted = Exercise1.formatter.get().format(cal.getTime());
		assertEquals("19.Jan.2015", formatted);
	}

	@Test
	public void isSomeArtistFromUS() {
		assertTrue(Exercise1.isSomeArtistFromUS(artists));
	}

	@Test
	public void existJohnBornAt1943() {
		assertTrue(Exercise1.existJohnBornAt1943(artists));
	}

	@Test
	public void isJohnOldestMan() {
		//This is a bit stupid example but please first create lambda for fetching Artist with John name
		Function<List<Artist>, List<Artist>> johnsFunc = Exercise1.getArtistsWithFirstNameJohn();
		//Create another lambda which will be fetching artist year of birth for the oldest man
		Function<List<Artist>, Artist> oldestNameFunc = Exercise1.getOldestArtist();

		Function<List<Artist>, String> finalFunc = Exercise1.concate(johnsFunc, oldestNameFunc);

		assertEquals("John", finalFunc.apply(artists) );
	}

	@Test
	public void artistCreation(){
		Artist artist = Exercise1.createArtist("Palko","Habera", 1965, "SK");

		assertNotNull(artist);
	}

	@Test
	public void sortDataASCByFirstName() {

		assertEquals("John", artists.get(0).getFirstName());
		Comparator<Artist> sortArtists = (Artist a1, Artist a2) -> a1.getFirstName().compareTo(a2.getFirstName());

		artists.sort(sortArtists);
		assertEquals("George", artists.get(0).getFirstName());

	}
}
