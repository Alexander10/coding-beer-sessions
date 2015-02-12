package sk.erni.ban.model;

import java.util.Optional;

/**
 * User: ban
 * Date: 1/23/15
 * Time: 12:53 PM
 */

public class Car {


	private Insurance insurance;

	public Optional<Insurance> getInsurance() {
		return Optional.ofNullable(insurance);
	}

	public Insurance getInsuranceNoneOptional() {
		return insurance;
	}
}
