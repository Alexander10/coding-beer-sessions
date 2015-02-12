package sk.erni.ban.exercises.chapter2;

import sk.erni.ban.exercises.Exercises;
import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: ban
 * Date: 1/26/15
 * Time: 2:29 PM
 */

public class Exercise2 {

	/**
	 * number of tracks <= 3
	 *
	 * @param albums
	 * @return
	 */
	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
		return Exercises.replaceThisWithSolution();
	}

	public static int countBandMembersInternal(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param artists
	 * @param name
	 * @return first founded artist by first name
	 */
	public static Artist findArtistByFirstName(List<Artist> artists, String name) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param artists return unique dates of birth
	 */
	public static List<Integer> getUniqueDatesOfBirth(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param album
	 * @return origin (nationality) for bands (album has a stream of musicians)
	 */
	public static List<String> originsOfBands(Album album) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param albums
	 * @return names of tracks which are longer than 60 minutes
	 */
	public static List<String> getNamesForLongTracks(List<Album> albums) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param artists
	 * @return list of integers where each integer represent length of artist first name
	 */
	public static List<Integer> getLenghtOfFirstNames(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}


	/**
	 * Please find a way how to read file to Stream<String>
	 *
	 * @param path
	 * @return
	 */
	public static long numberOfUniqueWordsInSong(Path path) {
		return Exercises.replaceThisWithSolution();
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
		return Exercises.replaceThisWithSolution();
	}
}
