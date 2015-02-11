package sk.erni.ban.exercises.chapter2;


import org.junit.Before;
import org.junit.Test;
import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static sk.erni.ban.model.SampleData.*;

/**
 * User: ban
 * Date: 1/20/15
 * Time: 10:46 AM
 */

public class Question2Test {

	private List<Artist> worldStars;

	@Before
	public void init() {
		worldStars = new ArrayList<>(membersOfTheBeatles);
		worldStars.addAll(slovakStars);
	}

	@Test
	public void findsShortAlbums() {
		List<Album> input = asList(manyTrackAlbum, sampleShortAlbum, aLoveSupreme);
		List<Album> result = Exercise2.getAlbumsWithAtMostThreeTracks(input);
		assertEquals(asList(sampleShortAlbum, aLoveSupreme), result);
	}

	@Test
	public void internal() {
		assertEquals(4, Exercise2.countBandMembersInternal(Arrays.asList(johnColtrane, theBeatles)));
	}

	@Test
	public void findArtistMiro() {
		assertNotNull(Exercise2.findArtistByFirstName(worldStars, "Miro"));
	}

	@Test
	public void findUniqueDatesOfBirth() {
		assertThat(Exercise2.getUniqueDatesOfBirth(worldStars), is(equalTo(Arrays.asList(1940, 1942, 1943, 1945))));
	}

	@Test
	public void findOriginsOfBands() {
		List<String> origins = Exercise2.originsOfBands(manyTrackAlbum);
		assertEquals("UK", origins.get(0));
	}

	@Test
	public void findLongTracks() {
		List<String> longTracks = Exercise2.getNamesForLongTracks(albums);

		assertTrue(longTracks.contains("Acknowledgement"));
		assertTrue(longTracks.contains("Resolution"));
		assertTrue(longTracks.contains("long track 4"));
		assertTrue(longTracks.contains("long track 5"));

	}


	@Test
	public void numberOfCharactersInArtistsNames() {

		List<Integer> lengthOfNames = Exercise2.getLenghtOfFirstNames(worldStars);
		long sum = lengthOfNames.stream().collect(Collectors.summingInt(a -> a));

		assertEquals(28, sum);
	}

	@Test
	public void numberOfUniqueWordsInNewSong() {
		Path path = Paths.get("/src/main/resources/newSong.txt");

		assertEquals(239, Exercise2.numberOfUniqueWordsInSong(path));
	}

	@Test
	public void extractsNamesAndOriginsOfArtists() {
		List<String> namesAndOrigins = Exercise2.getNamesAndOrigins(membersOfTheBeatles);
		assertEquals(asList("John Lennon", "UK", "Paul McCartney", "UK", "George Harrison", "UK", "Ringo Starr", "UK"), namesAndOrigins);
	}
}
