package com.answers.chapter4;

import com.exercises.chapter4.Exercise4;
import com.model.Artist;
import com.model.SampleData;
import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * User: ban
 * Date: 1/23/15
 * Time: 2:00 PM
 */

public class Question4Test {


	private final ArtistsFixed optionalExamples = new ArtistsFixed(SampleData.getThreeArtists());

	@Test
	public void indexWithinRange() {
		Optional<Artist> artist = optionalExamples.getArtist(0);
		assertTrue(artist.isPresent());
	}

	@Test
	public void indexOutsideRange() {
		Optional<Artist> artist = optionalExamples.getArtist(4);
		assertFalse(artist.isPresent());
	}

	@Test
	public void nameIndexInsideRange() {
		String artist = optionalExamples.getArtistFirstName(0);
		assertEquals("John", artist);
	}

	@Test
	public void nameIndexOutsideRange() {
		String artist = optionalExamples.getArtistFirstName(4);
		assertEquals("unknown", artist);
	}


	@Test
	public void durationsForOldStyleAndNewStyleMethods() {
		Question4.initDuration();
		Properties param = new Properties();

		assertEquals(5, Exercise4.readDurationOldApproach(param, "a"));
		assertEquals(0, Exercise4.readDurationOldApproach(param, "b"));
		assertEquals(0, Exercise4.readDurationOldApproach(param, "c"));
		assertEquals(0, Exercise4.readDurationOldApproach(param, "d"));


		assertEquals(5, Exercise4.readDuration(param, "a"));
		assertEquals(0, Exercise4.readDuration(param, "b"));
		assertEquals(0, Exercise4.readDuration(param, "c"));
		assertEquals(0, Exercise4.readDuration(param, "d"));
	}

	@Test
	public void insuranceCompanyNameOldStyleAndNewStyleMethods() {

	}
}
