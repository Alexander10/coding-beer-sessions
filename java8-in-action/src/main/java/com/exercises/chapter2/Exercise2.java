package com.exercises.chapter2;

import com.exercises.Exercises;
import com.model.Album;
import com.model.Artist;

import java.nio.file.Path;
import java.util.List;

/**
 * User: ban
 * Date: 1/26/15
 * Time: 2:29 PM
 */

public class Exercise2 {


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
	 * @return names of tracks whose are longer than 60 minutes
	 */
	public static List<String> getNamesForLongTracks(List<Album> albums) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param artists
	 * @return list of integers where each integer represent length of artist first name
	 */
	public static List<Integer> getLenghtOfNames(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}


	public static long countOfUniqueWordsInSong(Path path) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param artists
	 * @return - list of items where first item will be firstName + secondName followed by nationality for every artist
	 */
	public static List<String> getNamesAndOrigins(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}
}
