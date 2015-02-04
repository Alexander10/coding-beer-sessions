package sk.erni.ban.answers.chapter3;


import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;
import sk.erni.ban.model.SampleData;
import sk.erni.ban.model.Track;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * User: ban
 * Date: 1/21/15
 * Time: 1:13 PM
 */

public class Question3 {

	private static List<Album> albumList = SampleData.albums;
	private static List<Artist> artistList = SampleData.membersOfTheBeatles;


	/**
	 * Group albums by production year
	 *
	 * @param albums
	 * @return
	 */
	public static Map<Integer, List<Album>> getGroupedAlbumsByProductionYear(List<Album> albums) {
		Map<Integer, List<Album>> groupedArtists = albums.stream().collect(Collectors.groupingBy(Album::getProductionYear));
		return groupedArtists;
	}

	/**
	 * One album has more tracks. For this album sum all track lengths
	 *
	 * @param album
	 * @return
	 */
	public static Integer getSumTimeOfAllTracks(Album album) {
		Integer result = album.getTrackList().stream().collect(Collectors.summingInt(Track::getLength));
		return result;
	}

	/**
	 * For each country count number of artists
	 *
	 * @param artists
	 * @return
	 */
	public static Map<String, Long> getCntArtistsByNationalities(List<Artist> artists) {
		Map<String, Long> nationalitiesCounts = artists.stream().collect(Collectors.groupingBy(Artist::getNationality, Collectors.counting()));
		return nationalitiesCounts;
	}

	/**
	 * Solo artist should be put for key - true
	 * None solo artist should be put for key - false
	 *
	 * @param artists
	 * @return
	 */
	public Map<Boolean, List<Artist>> getSoloAndNoneSoloArtistsGrouped(List<Artist> artists) {
		return artists.stream().collect(partitioningBy(Artist::isSolo));
	}

	/**
	 * What is average count of tracks for one album?
	 *
	 * @param albums
	 * @return
	 */
	public double getAvgCntOfTracks(List<Album> albums) {
		return albums.stream()
				.collect(averagingInt(album -> album.getTrackList().size()));
	}

	/**
	 * @param album
	 */
	public static Track findLongestTrack(Album album) {
		Optional<Track> track = album.getTrackList().stream().collect(Collectors.maxBy(Comparator.comparingInt(Track::getLength)));
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
	 * For album calculates tracks stats: Avg, Min, Max, Sum
	 *
	 * @param album
	 * @return
	 */
	public static IntSummaryStatistics albumStats(Album album) {
		IntSummaryStatistics result = album.getTrackList().stream().collect(Collectors.summarizingInt(Track::getLength));
		return result;
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
		Map<String, Map<Integer, List<Artist>>> groupedArtist = artists.stream().
				collect(Collectors.groupingBy(Artist::getNationality, Collectors.groupingBy(a -> a.getYearOfBirth())));
		return groupedArtist;
	}

	/**
	 * All artists are formatted into one string: The format of output is : [firstName secondName], [firstName secondName],
	 *
	 * @param artists
	 * @return
	 */
	public static String formatArtists(List<Artist> artists) {

		String result =
				artists.stream()
						.map(a -> a.getFirstName() + " " + a.getSecondName())
						.collect(Collectors.joining(", ", "[", "]"));

		return result;
	}


	private static Comparator<Artist> byNameLength = comparing(artist -> artist.getFirstName().length());

	public static Artist byReduce(List<Artist> artists) {
		return artists.stream()
				.reduce((acc, artist) -> {
					return (byNameLength.compare(acc, artist) >= 0) ? acc : artist;
				})
				.orElseThrow(RuntimeException::new);
	}


	public void toCollectionTreeset() {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		stream.collect(toCollection(TreeSet::new));
	}


	public Optional<Artist> biggestGroup(Stream<Artist> artists) {
		Function<Artist, Long> getCount = artist -> artist.getMembers().count();
		return artists.collect(maxBy(comparing(getCount)));
	}


	public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
		return artists.collect(partitioningBy(artist -> artist.isSolo()));
	}


	public Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
		return artists.collect(partitioningBy(Artist::isSolo));
	}


	public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
		return albums.collect(groupingBy(album -> album.getMainMusician()));
	}


	public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
		return albums.collect(groupingBy(album -> album.getMainMusician(),
				counting()));
	}

	public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
		return albums.collect(groupingBy(Album::getMainMusician,
				mapping(Album::getName, toList())));
	}


	public void findOldestArtistForSoloAndNoneSolo() {
//		Map<Boolean, Artist> oldestArtists = artistList.stream().collect(partitioningBy(Artist::isSolo, maxBy(comparingInt(Artist::getYearOfBirth))));
	}


}
