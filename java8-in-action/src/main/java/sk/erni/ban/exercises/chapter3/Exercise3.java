package sk.erni.ban.exercises.chapter3;

import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;
import sk.erni.ban.model.Track;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: ban
 * Date: 1/26/15
 * Time: 3:19 PM
 */

public class Exercise3 {


	/**
	 * Group albums by production year
	 *
	 * @param albums
	 * @return
	 */
	public static Map<Integer, List<Album>> groupAlbumsByProductionYear(List<Album> albums) {
		return albums.stream().collect(Collectors.groupingBy(Album::getProductionYear));
	}

	/**
	 * One album has more tracks. For this album sum all track lengths
	 *
	 * @param album
	 * @return
	 */
	public static Integer getSumDurationOfAllTracks(Album album) {
		return album.getTracks().map(track -> track.getLength()).reduce(0, Integer::sum);
	}

	/**
	 * For each country count number of artists
	 *
	 * @param artists
	 * @return
	 */
	public static Map<String, Long> cntArtistsByNationalities(List<Artist> artists) {
		return artists.stream().collect(Collectors.groupingBy(Artist::getNationality, Collectors.counting()));
	}

	/**
	 * Solo artist should be - true
	 * Band should be  - false
	 *
	 * @param artists
	 * @return
	 */
	public static Map<Boolean, List<Artist>> findSoloArtistsAndBands(List<Artist> artists) {
		return artists.stream().collect(Collectors.partitioningBy(Artist::isSolo));
	}

	/**
	 * What is average count of tracks for one album?
	 *
	 * @param albums
	 * @return
	 */
	public static double getAvgCntOfTracks(List<Album> albums) {
		return albums.stream().collect(Collectors.averagingDouble(album -> album.getTrackList().size()));
	}

	/**
	 * @param album
	 */
	public static Track findTheLongestTrack(Album album) {
		Optional<Track> track = album.getTracks().collect(Collectors.maxBy(Comparator.comparingInt(Track::getLength)));
		return track.get();
	}


	/**
	 * Classifies album tracks by following rules:
	 * Track shorter than 35 min: classify like a SHORT TRACK
	 * length >=35 && length <=100 MEDIUM TRACK
	 * length > 100 LONG TRACK
	 */
	public static Map<String, List<Track>> getCustomGroupedTracks(Album album) {
		Map<String, List<Track>> groupedTracks = album.getTrackList().stream().collect(
				Collectors.groupingBy(track -> {
					if (track.getLength() < 35) {
						return "SHORT TRACK";
					} else if (track.getLength() >= 35 && track.getLength() <= 100) {
						return "MEDIUM TRACK";
					} else {
						return "LONG TRACK";
					}
				})
		);
		return groupedTracks;
	}


	/**
	 * For album calculate tracks stats (for duration): Avg, Min, Max, Sum
	 *
	 * @param album
	 * @return
	 */
	public static IntSummaryStatistics calculateStats(Album album) {
		return album.getTracks().collect(Collectors.summarizingInt(Track::getLength));
	}

	/**
	 * Group artists
	 * 1) by nationalities
	 * 2) by year of birth
	 *
	 * @param artists
	 * @return
	 */
	public static Map<String, Map<Integer, List<Artist>>> doubleGroupedArtists(List<Artist> artists) {
		return artists.stream().collect(Collectors.groupingBy(Artist::getNationality, Collectors.groupingBy(Artist::getYearOfBirth)));
	}


	/**
	 * All artists are formatted to the one string: The format of output is : [firstName secondName, firstName secondName ...]
	 *
	 * @param artists
	 * @return
	 */
	public static String formatArtists(List<Artist> artists) {
		return artists.stream()
				.map(a -> a.getFirstName() + " " + a.getSecondName())
				.collect(Collectors.joining(", ", "[", "]"));
	}
}
