package com.answers.chapter4;

import com.model.Artist;

import java.util.List;
import java.util.Optional;

/**
 * User: ban
 * Date: 2/2/15
 * Time: 4:49 PM
 */
public class ArtistsFixed {

	private List<Artist> artists;

	public ArtistsFixed(List<Artist> artists) {
		this.artists = artists;
	}

	public Optional<Artist> getArtist(int index) {
		if (index < 0 || index >= artists.size()) {
			return Optional.empty();
		}
		return Optional.of(artists.get(index));
	}

	public String getArtistFirstName(int index) {
		Optional<Artist> artist = getArtist(index);
		return artist.map(Artist::getFirstName)
				.orElse("unknown");
	}

}
