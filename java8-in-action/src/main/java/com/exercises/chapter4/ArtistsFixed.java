package com.exercises.chapter4;

import com.exercises.Exercises;
import com.model.Artist;

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

	public Optional<Artist> getArtist(int index) {
		return Exercises.replaceThisWithSolution();
	}

	public String getArtistFirstName(int index) {
		return Exercises.replaceThisWithSolution();
	}
}
