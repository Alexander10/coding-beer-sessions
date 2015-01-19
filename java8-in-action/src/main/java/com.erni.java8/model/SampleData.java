package com.erni.java8.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:50 AM
 */

public class SampleData {

	public static final Artist johnColtrane = new Artist("John","Coltrane", 1926, "US");

	public static final Artist johnLennon = new Artist("John","Lennon",1940, "UK");
	public static final Artist paulMcCartney = new Artist("Paul", "McCartney", 1942, "UK");
	public static final Artist georgeHarrison = new Artist("George", "Harrison", 1943, "UK");
	public static final Artist ringoStarr = new Artist("Ringo", "Starr", 1945, "UK");

	public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

	public static final Artist theBeatles = new Artist("The Beatles", "The Beatles", 1980, membersOfTheBeatles, "UK");

	public static final Album aLoveSupreme = new Album("A Love Supreme", asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)), asList(johnColtrane));

	public static final Album sampleShortAlbum = new Album("sample Short Album", asList(new Track("short track", 30)), asList(johnColtrane));

	public static final Album manyTrackAlbum = new Album("sample Short Album", asList(new Track("short track", 30), new Track("short track 2", 30), new Track("short track 3", 30), new Track("short track 4", 30), new Track("short track 5", 30)), asList(johnColtrane));

	public static final List<Album> albums = Arrays.asList(aLoveSupreme,sampleShortAlbum,manyTrackAlbum);

	//public static Stream<Album> albums = Stream.of(aLoveSupreme);

	public static Stream<Artist> threeArtists() {
		return Stream.of(johnColtrane, johnLennon, theBeatles);
	}

	public static List<Artist> getThreeArtists() {
		return Arrays.asList(johnColtrane, johnLennon, theBeatles);
	}
}
