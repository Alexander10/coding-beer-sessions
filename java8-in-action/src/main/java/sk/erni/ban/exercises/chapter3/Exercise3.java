package sk.erni.ban.exercises.chapter3;

import sk.erni.ban.exercises.Exercises;
import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;
import sk.erni.ban.model.Track;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

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
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * One album has more tracks. For this album sum all track lengths
	 *
	 * @param album
	 * @return
	 */
	public static Integer getSumDurationOfAllTracks(Album album) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * For each country count number of artists
	 *
	 * @param artists
	 * @return
	 */
	public static Map<String, Long> cntArtistsByNationalities(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Solo artist should be - true
	 * Band should be  - false
	 *
	 * @param artists
	 * @return
	 */
	public static Map<Boolean, List<Artist>> findSoloArtistsAndBands(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * What is average count of tracks for one album?
	 *
	 * @param albums
	 * @return
	 */
	public static double getAvgCntOfTracks(List<Album> albums) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * @param album
	 */
	public static Track findTheLongestTrack(Album album) {
		return Exercises.replaceThisWithSolution();
	}


	/**
	 * Classifies album tracks by following rules:
	 * Track shorter than 35 min: classify like a SHORT TRACK
	 * length >=35 && length <=100 MEDIUM TRACK
	 * length > 100 LONG TRACK
	 */
	public static Map<String, List<Track>> getCustomGroupedTracks(Album album) {
		return Exercises.replaceThisWithSolution();
	}


	/**
	 * For album calculate tracks stats (for duration): Avg, Min, Max, Sum
	 *
	 * @param album
	 * @return
	 */
	public static IntSummaryStatistics calculateStats(Album album) {
		return Exercises.replaceThisWithSolution();
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
		return Exercises.replaceThisWithSolution();
	}


	/**
	 * All artists are formatted to the one string: The format of output is : [firstName secondName, firstName secondName ...]
	 *
	 * @param artists
	 * @return
	 */
	public static String formatArtists(List<Artist> artists) {
		return Exercises.replaceThisWithSolution();
	}
}
