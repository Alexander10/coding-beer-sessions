package sk.erni.ban.exercises.chapter3;

import org.junit.Before;
import org.junit.Test;
import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;
import sk.erni.ban.model.Track;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sk.erni.ban.model.SampleData.*;

/**
 * User: ban
 * Date: 1/21/15
 * Time: 1:14 PM
 */

public class Question3Test {

	private List<Artist> worldStars = new ArrayList<>(membersOfTheBeatles);

	@Before
	public void init() {
		worldStars.addAll(slovakStars);
		worldStars.add(johnColtrane);
	}

	@Test
	public void groupedAlbumsByProductionYear() {
		Map<Integer, List<Album>> groupedAlbums = Exercise3.groupAlbumsByProductionYear(albums);
		List<Album> albumsRecorded1980 = groupedAlbums.get(1980);
		List<Album> albumsRecorded1990 = groupedAlbums.get(1990);

		assertEquals(2, albumsRecorded1980.size());
		assertEquals(1, albumsRecorded1990.size());

	}

	@Test
	public void sumOfTracksDurationForAlbum() {
		long duration = Exercise3.getSumDurationOfAllTracks(manyTrackAlbum);
		assertEquals(275, duration);
	}

	@Test
	public void forEachNationalityCountNumberOfArtists() {
		Map<String, Long> nationalitiesCounts = Exercise3.cntArtistsByNationalities(worldStars);

		long numberOfUSArtists = nationalitiesCounts.get("US");
		long numberOfSKArtists = nationalitiesCounts.get("SK");
		long numberOfUKArtists = nationalitiesCounts.get("UK");

		assertEquals(1, numberOfUSArtists);
		assertEquals(2, numberOfSKArtists);
		assertEquals(4, numberOfUKArtists);

	}

	@Test
	public void soloArtistsAndBands() {
		List<Artist> artists = new ArrayList<>();
		artists.addAll(worldStars);
		artists.add(theBeatles);

		Map<Boolean, List<Artist>> soloArtistsAndBands = Exercise3.findSoloArtistsAndBands(artists);
		List<Artist> soloArtists = soloArtistsAndBands.get(true); //solo artists
		List<Artist> bands = soloArtistsAndBands.get(false);

		assertEquals(7, soloArtists.size());
		assertEquals(1, bands.size());

	}


	@Test
	public void averageCountOfTracksForOneAlbum() {
		double avg = Exercise3.getAvgCntOfTracks(albums);
		assertEquals(267, Math.round(avg * 100));
	}

	@Test
	public void findTheLongestTrackFromAlbum() {
		Track track = Exercise3.findTheLongestTrack(manyTrackAlbum);
		assertEquals("long track 5", track.getName());
		assertEquals(105, track.getLength());
	}

	@Test
	public void customGroupedTracks() {
		Map<String, List<Track>> groupedTracks = Exercise3.getCustomGroupedTracks(manyTrackAlbum);

		assertEquals(1, groupedTracks.get("LONG TRACK").size());
		assertEquals(1, groupedTracks.get("MEDIUM TRACK").size());
		assertEquals(3, groupedTracks.get("SHORT TRACK").size());

	}

	@Test
	public void calculateAlbumStatsForAllTracks() {
		IntSummaryStatistics stats = Exercise3.calculateStats(manyTrackAlbum);

		assertEquals(5, stats.getCount());
		assertEquals(275, stats.getSum());
		assertEquals(30, stats.getMin());
		assertEquals(105, stats.getMax());
	}

	@Test
	public void groupedArtistsByNationalitiesAndByDateOfBirth() {
		worldStars.add(new Artist("John","Lennon2",1940, "UK"));
		Map<String, Map<Integer, List<Artist>>> groupedArtists = Exercise3.doubleGroupedArtists(worldStars);
		Map<Integer, List<Artist>> artistsFromUK = groupedArtists.get("UK");
		Map<Integer, List<Artist>> artistsFromSK = groupedArtists.get("SK");
		Map<Integer, List<Artist>> artistsFromUS = groupedArtists.get("US");

		List<Artist> artistFromUKBornAt1942 = artistsFromUK.get(1940);
		assertEquals(2, artistFromUKBornAt1942.size());
		assertEquals(2, artistsFromSK.size());
		assertEquals(1, artistsFromUS.size());
	}

	@Test
	public void formatAllArtistsInList() {
		String formattedArtists = Exercise3.formatArtists(worldStars);
		String expectedResult = "[John Lennon, Paul McCartney, George Harrison, Ringo Starr, Pavol Hamel, Miro Zbirka, John Coltrane]";
		assertEquals(expectedResult, formattedArtists);
	}


}
