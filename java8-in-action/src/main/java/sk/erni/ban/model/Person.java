package sk.erni.ban.model;

import java.util.Optional;

/**
 * User: ban
 * Date: 1/23/15
 * Time: 12:54 PM
 */

public class Person {

	private Optional<Car> car;
	private Integer age;
	private Car	carNoneOptional;


	public Optional<Car> getCar() {
		return car;
	}

	public Car getCarNoneOptional() {
		return carNoneOptional;
	}

	public Integer getAge(){
		return age;
	}
}
