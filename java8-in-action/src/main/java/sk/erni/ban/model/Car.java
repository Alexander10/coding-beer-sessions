package sk.erni.ban.model;

import java.util.Optional;

/**
 * User: ban
 * Date: 1/23/15
 * Time: 12:53 PM
 */

public class Car {

	private Optional<Insurance> insurance;
	private Insurance insuranceNoneOptional;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public Insurance getInsuranceNoneOptional() {
		return insuranceNoneOptional;
	}
}
