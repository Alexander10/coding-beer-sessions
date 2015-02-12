package sk.erni.ban.model;

import java.util.Optional;

/**
 * User: ban
 * Date: 1/23/15
 * Time: 12:54 PM
 */

public class Person {

	private String name;
	private Integer age;
	private Car car;

	public Person() {

	}

	public Person(Car car) {
		this.car = car;
	}

	public Optional<Car> getCar() {
		return Optional.ofNullable(car);
	}

	public Car getCarNoneOptional() {
		return car;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
