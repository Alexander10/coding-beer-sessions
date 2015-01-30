package com.answers.chapter3;

import com.exercises.chapter3.Exercise3;
import com.model.Album;
import com.model.Artist;
import com.model.Track;
import org.junit.Test;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import static com.model.SampleData.*;
import static org.junit.Assert.assertEquals;

/**
 * User: ban
 * Date: 1/21/15
 * Time: 1:14 PM
 */

public class Question3Test {

	private List<Artist> worldStars = new ArrayList<>(membersOfTheBeatles);

	@Test
	public void init() {
		worldStars.addAll(slovakStars);
		worldStars.add(johnColtrane);
	}

	@Test
	public void groupedAlbumsByProductionYear() {
		Map<Integer, List<Album>> groupedAlbums = Exercise3.groupAlbumsByProductionYear(albums);
		List<Album> albumsRecorded1980 = groupedAlbums.get(1980);
		List<Album> albumsRecorded1990 = groupedAlbums.get(1990);

		assertEquals(2, albumsRecorded1980);
		assertEquals(1, albumsRecorded1990);

	}

	@Test
	public void sumOfTracksDurationForAlbum() {
		long duration = Exercise3.getDurationSumOfAllTracks(manyTrackAlbum);

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
	public void soloAndNonSoloArtists(){
		Map<Boolean, List<Artist>> soloNonSoloArtists = Exercise3.findSoloAndNoneSoloArtists(worldStars);

	}


	@Test
	public void averageCountOfTracksForOneAlbum(){
		double avg = Exercise3.getAvgCntOfTracks(albums);
	}

	@Test
	public void findTheLongestTrackFromAlbum(){
		Track track = Exercise3.findTheLongestTrack(manyTrackAlbum);
	}

	@Test
	public void customGroupedTracks(){
		Map<String, List<Track>> groupedTracks = Exercise3.getCustomGroupedTracks(manyTrackAlbum);

	}

	@Test
	public void calculateAlbumStatsForAllTracks(){
		DoubleSummaryStatistics stats = Exercise3.calculateStats(manyTrackAlbum);
	}

	@Test
	public void groupedArtistsByNationalitiesAndByDateOfBirth(){
		Map<String, Map<Integer, List<Artist>>> groupedArtists = Exercise3.doubleGroupedArtists(worldStars);
	}

	@Test
	public void formatAllArtistsInList(){
		String formattedArtists = Exercise3.formatArtists(worldStars);
	}


}
