package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:47 AM
 */

public final class Artist {

	private String firstName;
	private String secondName;
	private List<Artist> members;
	private String nationality;
	private Integer yearOfBirth;


	public Artist(String firstName, String secondName, Integer yearOfBirth, String nationality) {
		this(firstName, secondName, yearOfBirth, Collections.emptyList(), nationality);
	}

	public Artist(String firstName, String secondName, Integer yearOfBirth, List<Artist> members, String nationality) {
		Objects.requireNonNull(firstName);
		Objects.requireNonNull(secondName);
		Objects.requireNonNull(members);
		Objects.requireNonNull(nationality);
		Objects.requireNonNull(yearOfBirth);
		this.firstName = firstName;
		this.secondName = secondName;
		this.yearOfBirth = yearOfBirth;
		this.members = new ArrayList<>(members);
		this.nationality = nationality;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	/**
	 * @return the members
	 */
	public Stream<Artist> getMembers() {
		return members.stream();
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	public boolean isSolo() {
		return members.isEmpty();
	}

	public boolean isFrom(String nationality) {
		return this.nationality.equals(nationality);
	}

	@Override
	public String toString() {
		return getFirstName() + getSecondName();
	}

	public Artist copy() {
		List<Artist> members = getMembers().map(Artist::copy).collect(toList());
		return new Artist(firstName, secondName, yearOfBirth, members, nationality);
	}

}
