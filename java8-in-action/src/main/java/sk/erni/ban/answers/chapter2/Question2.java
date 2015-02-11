package sk.erni.ban.answers.chapter2;


import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;
import sk.erni.ban.model.SampleData;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * User: ban
 * Date: 1/20/15
 * Time: 10:40 AM
 */

public class Question2 {

	private static List<Artist> artistList = SampleData.membersOfTheBeatles;
	private static List<Album> albumList = SampleData.albums;


	/**
	 * number of tracks <= 3
	 *
	 * @param albums
	 * @return
	 */
	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
		return albums.stream().filter((album) -> album.getTrackList().size() <= 3).collect(Collectors.toList());
	}

	public static int countBandMembersInternal(List<Artist> artists) {
		return artists.stream()
				.map(artist -> artist.getMembers().count())
				.reduce(0L, Long::sum)
				.intValue();
	}

	/**
	 * @param artists
	 * @param name
	 * @return first founded artist by first name
	 */
	public static Artist findArtistByFirstName(List<Artist> artists, String name) {
		return artists.stream().filter(artist -> artist.getFirstName().equals(name)).findFirst().get();
	}

	/**
	 * @param artists return unique dates of birth
	 */
	public static List<Integer> getUniqueDatesOfBirth(List<Artist> artists) {
		return artists.stream().map(art -> art.getYearOfBirth()).distinct().collect(Collectors.toList());
	}

	/**
	 * @param album
	 * @return origin (nationality) for bands (album has a stream of musicians)
	 */
	public static List<String> originsOfBands(Album album) {
		return album.getMusicianList().stream().filter(art -> !art.isSolo()).map(art -> art.getNationality()).distinct().collect(Collectors.toList());
	}

	/**
	 * @param albums
	 * @return names of tracks which are longer than 60 minutes
	 */
	public static List<String> getNamesForLongTracks(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60).map(track -> track.getName()).collect(Collectors.toList());
	}

	/**
	 * @param artists
	 * @return list of integers where each integer represent length of artist first name
	 */
	public static List<Integer> getLenghtOfFirstNames(List<Artist> artists) {
		return artists.stream().map(artist -> artist.getFirstName().length()).collect(Collectors.toList());
	}


	/**
	 * Please find a way how to read file to Stream<String>
	 *
	 * @param path
	 * @return
	 */
	public static long numberOfUniqueWordsInSong(Path path) {
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/newSong.txt"), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(f -> Arrays.stream(f.split("\\s"))).distinct().count();
		} catch (IOException e) {
			System.out.println("Some problems with newSong file: " + e.toString());
		}
		System.out.println("unique words" + uniqueWords);
		return uniqueWords;
	}

	/**
	 * i. e.
	 * 0 - John Coltrane
	 * 1 - US
	 *
	 * @param artists
	 * @return - list of items where first item will be firstName + secondName followed by nationality for every artist
	 */
	public static List<String> getNamesAndOrigins(List<Artist> artists) {
		return artists.stream().flatMap(art -> Stream.of(art.getFirstName() + " " + art.getSecondName(), art.getNationality())).collect(Collectors.toList());
	}



	 /********************************************************* Questions END **************************************************************/


	public static Artist findArtistByName(String name) {
		return artistList.stream().filter(a -> a.getFirstName().equalsIgnoreCase(name)).limit(0).findFirst().get();
	}

	/**
	 * return unique date of birth
	 */
	public static List<Integer> getUniqueDatesOfBirth() {
		List<Integer> result = artistList.stream().map((a) -> a.getYearOfBirth()).distinct().collect(Collectors.toList());
		result.forEach(System.out::println);
		return null;
	}


	public static List<Integer> getLengthOfNames() {

		List<Integer> result = artistList.stream().map(Artist::getFirstName).map(String::length).collect(Collectors.toList());
		result.forEach(System.out::println);
		return null;
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


	public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {

		Map<Artist, Integer> countOfAlbums = new HashMap<>();
		albumsByArtist.forEach((artist, albums) -> {
			countOfAlbums.put(artist, albums.size());
		});

		return countOfAlbums;
	}


}
