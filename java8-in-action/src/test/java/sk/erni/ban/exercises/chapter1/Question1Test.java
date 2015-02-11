package sk.erni.ban.exercises.chapter1;


import org.junit.Test;
import sk.erni.ban.exercises.Exercises;
import sk.erni.ban.model.Artist;
import sk.erni.ban.model.SampleData;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

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
		assertEquals("19.jan.2015", formatted);
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
		//This is a bit stupid example but please first create lambda for fetching Artists with fist name John
		Function<List<Artist>, List<Artist>> johnsFunc = Exercise1.getArtistsWithFirstNameJohn();

		Function<List<Artist>, Artist> oldestNameFunc = Exercise1.getOldestArtist();

		Function<List<Artist>, Artist> finalFunc = Exercise1.concat(johnsFunc, oldestNameFunc);

		assertEquals("John", finalFunc.apply(artists).getFirstName());
	}

	@Test
	public void artistCreation() {
		Artist artist = Exercise1.createArtist("Palko", "Habera", 1965, "SK");

		assertNotNull(artist);
	}

	@Test
	public void sortDataASCByFirstName() {

		assertEquals("John", artists.get(0).getFirstName());
		Comparator<Artist> sortArtists = Exercises.replaceThisWithSolution();

		artists.sort(sortArtists);
		assertEquals("George", artists.get(0).getFirstName());

	}
}
