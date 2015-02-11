package sk.erni.ban.exercises.chapter4;

import sk.erni.ban.exercises.Exercises;
import sk.erni.ban.model.Artist;

import java.util.List;
import java.util.Optional;

/**
 * User: ban
 * Date: 2/2/15
 * Time: 4:54 PM
 */

public class ArtistsFixed {

	private List<Artist> artists;

	public ArtistsFixed(List<Artist> artists) {
		this.artists = artists;
	}

	/**
	 * Rewrite:
	 * @see Artists#getArtist(int)
	 * @param index
	 * @return
	 */
	public Optional<Artist> getArtist(int index) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Rewrite:
	 * @see Artists#getArtistFirstName(int)
	 * @param index
	 * @return
	 */
	public String getArtistFirstName(int index) {
		return Exercises.replaceThisWithSolution();
	}
}
