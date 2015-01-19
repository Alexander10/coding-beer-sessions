package com.model;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:49 AM
 */

public final class Track {

	private final String name;
	private final int length;

	public Track(String name, int length) {
		this.name = name;
		this.length = length;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the length of the track in milliseconds.
	 */
	public int getLength() {
		return length;
	}

	public Track copy() {
		return new Track(name, length);
	}

}