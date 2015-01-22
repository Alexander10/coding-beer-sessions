package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:48 AM
 */
public final class Album {


	private String name;
	private Integer productionYear;
	private List<Track> tracks;
	private List<Artist> musicians;

	public Album(String name, Integer productionYear, List<Track> tracks, List<Artist> musicians) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(tracks);
		Objects.requireNonNull(musicians);
		Objects.requireNonNull(productionYear);

		this.productionYear = productionYear;
		this.name = name;
		this.tracks = new ArrayList<>(tracks);
		this.musicians = new ArrayList<>(musicians);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the tracks
	 */
	public Stream<Track> getTracks() {
		return tracks.stream();
	}

	/**
	 * Used in imperative code examples that need to iterate over a list
	 */
	public List<Track> getTrackList() {
		return unmodifiableList(tracks);
	}

	/**
	 * @return the musicians
	 */
	public Stream<Artist> getMusicians() {
		return musicians.stream();
	}

	/**
	 * Used in imperative code examples that need to iterate over a list
	 */
	public List<Artist> getMusicianList() {
		return unmodifiableList(musicians);
	}

	public Artist getMainMusician() {
		return musicians.get(0);
	}

	public Integer getProductionYear() {
		return productionYear;
	}

	public Album copy() {
		List<Track> tracks = getTracks().map(Track::copy).collect(toList());
		List<Artist> musicians = getMusicians().map(Artist::copy).collect(toList());
		return new Album(name, productionYear, tracks, musicians);
	}
	@Override
	public String toString(){
		return name + productionYear;
	}

}