package sk.erni.ban.exercises.chapter4;

import sk.erni.ban.model.Artist;

import java.util.List;

/**
 * User: ban
 * Date: 2/2/15
 * Time: 4:50 PM
 */

public class Artists {

	private List<Artist> artists;

	public Artists(List<Artist> artists) {
		this.artists = artists;
	}

	/**
	 *
	 * @param index
	 * @return
	 */
	public Artist getArtist(int index) {
		if (index < 0 || index >= artists.size()) {
			indexException(index);
		}
		return artists.get(index);
	}

	private void indexException(int index) {
		throw new IllegalArgumentException(index +
				" doesn't correspond to an Artist");
	}

	public String getArtistFirstName(int index) {
		try {
			Artist artist = getArtist(index);
			return artist.getFirstName();
		} catch (IllegalArgumentException e) {
			return "unknown";
		}
	}

}
