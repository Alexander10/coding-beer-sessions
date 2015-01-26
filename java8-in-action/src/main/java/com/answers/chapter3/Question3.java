package com.answers.chapter3;

import com.model.Album;
import com.model.Artist;
import com.model.SampleData;
import com.model.Track;

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
	 */
	public static void getGroupedAlbumsByProductionYear() {
		Map<Integer, List<Album>> groupedArtists = albumList.stream().collect(Collectors.groupingBy(Album::getProductionYear));
		System.out.println(groupedArtists.size());
	}

	public static void getTheLongestTrackFromManyTrackAlbum() {
		Optional<Track> track = SampleData.manyTrackAlbum.getTrackList().stream().collect(Collectors.maxBy(Comparator.comparingInt(Track::getLength)));
		System.out.println(track.get().getName());
	}

	public static void getTotalLengthOfManyTrackAlbum() {
		Integer result = SampleData.manyTrackAlbum.getTrackList().stream().collect(Collectors.summingInt(Track::getLength));
		System.out.println(result);
	}

	public static void getTotalTrackLengthStatsOfManyTrackAlbum() {
		IntSummaryStatistics result = SampleData.manyTrackAlbum.getTrackList().stream().collect(Collectors.summarizingInt(Track::getLength));
		System.out.println(result);
	}

	public static void getJoinedTrackNames() {
		String trackNames = SampleData.manyTrackAlbum.getTrackList().stream().map(t -> t.getName()).collect(Collectors.joining());
		System.out.println(trackNames);
	}

	/**
	 * Classify tracks from manyTrackAlbum by following:
	 * shorter then 35 min like a SHORT TRACK
	 * length >=35 && length <=100 MEDIUM TRACK
	 * length > 100 LONG TRACK
	 */
	public static void getCustomGroupedTracks() {
		Map<String, List<Track>> groupedTracks = SampleData.manyTrackAlbum.getTrackList().stream().collect(
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
		groupedTracks.forEach((k, v) -> v.forEach(System.out::println));
	}

	/**
	 * Group artist first by nationalities and second by year of birth
	 */
	public static void getGroupedArtistExtended() {
		Map<String, Map<Integer, List<Artist>>> groupedArtist = artistList.stream().
				collect(Collectors.groupingBy(Artist::getNationality, Collectors.groupingBy(a -> a.getYearOfBirth())));
	}

	public static void getNumbOfArtistFromDiffNational() {
		Map<String, Long> nationalitiesCounts = artistList.stream().collect(Collectors.groupingBy(Artist::getNationality, Collectors.counting()));
		nationalitiesCounts.forEach((k, v) -> System.out.println(v));
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


	public double averageNumberOfTracks(List<Album> albums) {
		return albums.stream()
				.collect(averagingInt(album -> album.getTrackList().size()));
	}

	public void soloAndNoneSoloArtists() {
		Map<Boolean, List<Artist>> byContinentDivided = artistList.stream().collect(partitioningBy(Artist::isSolo));
	}

	public void findOldestArtistForSoloAndNoneSolo() {
//		Map<Boolean, Artist> oldestArtists = artistList.stream().collect(partitioningBy(Artist::isSolo, maxBy(comparingInt(Artist::getYearOfBirth))));
	}


}
