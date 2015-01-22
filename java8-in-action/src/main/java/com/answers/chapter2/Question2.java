package com.answers.chapter2;

import com.model.Album;
import com.model.Artist;
import com.model.SampleData;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * User: ban
 * Date: 1/20/15
 * Time: 10:40 AM
 */

public class Question2 {
	private static List<Artist> artistList = SampleData.membersOfTheBeatles;
	private static List<Album> albumList = SampleData.albums;


	public static List<Integer> getLengthOfNames() {

		List<Integer> result = artistList.stream().map(Artist::getFirstName).map(String::length).collect(Collectors.toList());
		result.forEach(System.out::println);
		return null;
	}

	/**
	 * return unique date of birth
	 */
	public static List<Integer> getUniqueDateOfBirth() {
		List<Integer> result = artistList.stream().map((a) -> a.getYearOfBirth()).distinct().collect(Collectors.toList());
		result.forEach(System.out::println);
		return null;
	}

	public static void findMekyZbirka() {
		artistList.stream().filter(a -> a.getFirstName().equalsIgnoreCase("Meky")).findAny().ifPresent(d -> System.out.println(d.getFirstName()));
	}

	/**
	 * By this task please use reduce and map functions and ....
	 *
	 * @return number of american singers
	 */
	public static Integer getNumberOfAmericansWithUsingReduce() {
		Integer americans = artistList.stream().filter(a -> a.isFrom("US")).map(d -> 1).reduce(0, Integer::sum);
		return americans;
	}

	/**
	 * Find all Albums whose were produced in the year 1980 and sort them by name
	 */
	public static void findAlbums() {
		List<Album> result = albumList.stream().filter(a -> a.getProductionYear() == 1980).sorted(Comparator.comparing(Album::getName)).collect(Collectors.toList());
		albumList.stream().filter(a -> a.getProductionYear() == 1980).sorted(Comparator.comparing(Album::getName)).forEach(System.out::println);

	}

	/**
	 * Unique years when was CD produced
	 */
	public static void findUniqueYearsForAlbumProduction() {
		List<Integer> result = albumList.stream().map(Album::getProductionYear).distinct().collect(Collectors.toList());
		albumList.stream().map(Album::getProductionYear).distinct().forEach(System.out::println);
	}

	/**
	 * Get names of all albums in one string delimited by ;
	 * or return empty string
	 */
	public static void getAllAlbumsInOne() {
		String str = albumList.stream().map(a -> a.getName() + ";").reduce(String::concat).orElse("");
		System.out.println(str);
	}

	/**
	 * Get album with only one track
	 */
	public static void getUniqueAlbumsWithOneArtist() {
//		Album album = albumList.stream().filter( a -> a.getTrackList().size() > 0);
	}


	public static long getNumberOfUniqueWordsInNewSong() {
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/newSong.txt"), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(f -> Arrays.stream(f.split("\\s"))).distinct().count();
		} catch (IOException e) {
			System.out.println("Some problems with newSong file: " + e.toString());
		}
		System.out.println("unique words" + uniqueWords);
		return uniqueWords;
	}


	public static List<String> getNamesAndOrigins(List<Artist> artists) {
		return artists.stream()
				.flatMap(artist -> Stream.of(artist.getFirstName(), artist.getSecondName(), artist.getNationality()))
				.collect(toList());
	}

	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
		return input.stream()
				.filter(album -> album.getTrackList().size() <= 3)
				.collect(toList());
	}

	public static int countBandMembersInternal(List<Artist> artists) {
		return artists.stream()
				.map(artist -> artist.getMembers().count())
				.reduce(0L, Long::sum)
				.intValue();
	}

	public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {

		Map<Artist, Integer> countOfAlbums = new HashMap<>();
		albumsByArtist.forEach((artist, albums) -> {
			countOfAlbums.put(artist, albums.size());
		});

		return countOfAlbums;
	}

	public static String formatArtists(List<Artist> artists) {

		String result =
				artists.stream()
						.map(a -> a.getFirstName() + " " + a.getSecondName())
						.collect(Collectors.joining(", ", "[", "]"));

		return result;
	}

	public Set<String> originsOfBands(Album album) {

		Set<String> origins = album.getMusicians()
				.filter(artist -> artist.getFirstName().startsWith("The"))
				.map(artist -> artist.getNationality())
				.collect(toSet());

		return origins;
	}

	public Set<String> findLongTracks(List<Album> albums) {
		return albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.collect(toSet());
	}


}
