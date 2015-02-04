package sk.erni.ban.exercises.chapter2;


import sk.exercises.chapter2.Exercise2;
import sk.model.Album;
import sk.model.Artist;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * User: ban
 * Date: 1/20/15
 * Time: 10:46 AM
 */

public class Question2Test {

	private List<Artist> worldStars;
	@Before
	public void init(){
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
	public void findLongTracks() {
		List<String> longTracks = Exercise2.getNamesForLongTracks(albums);

		assertTrue(longTracks.contains("Acknowledgement"));
		assertTrue(longTracks.contains("Resolution"));
		assertTrue(longTracks.contains("long track 4"));
		assertTrue(longTracks.contains("long track 5"));

	}

	@Test
	public void findOriginsOfBands() {
		List<String> origins = Exercise2.originsOfBands(aLoveSupreme);
		assertEquals("US", origins.get(0));
	}

	@Test
	public void findUniqueDatesOfBirth() {


		assertEquals(3, Exercise2.getUniqueDatesOfBirth(worldStars));
	}

	@Test
	public void numberOfCharactersInArtistsNames(){

		List<Integer> lengthOfNames = Exercise2.getLenghtOfNames(worldStars);
		long sum = lengthOfNames.stream().collect(Collectors.summingInt( a -> a));

		assertEquals(344,sum);
	}

	@Test
	public void numberOfUniqueWordsInNewSong(){
		Path path = Paths.get("src/main/resources/newSong.txt");

		assertEquals(289, Exercise2.countOfUniqueWordsInSong(path));
	}

	@Test
	public void extractsNamesAndOriginsOfArtists() {
		List<String> namesAndOrigins = Exercise2.getNamesAndOrigins(membersOfTheBeatles);
		assertEquals(asList("John Coltrane", "US", "John Lennon", "UK", "The Beatles", "UK"), namesAndOrigins);
	}
}
