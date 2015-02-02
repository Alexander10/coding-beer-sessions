package com.exercises.chapter4;

import com.exercises.Exercises;
import com.model.Car;
import com.model.Insurance;
import com.model.Person;

import java.util.Optional;
import java.util.Properties;

/**
 * User: ban
 * Date: 1/30/15
 * Time: 5:01 PM
 */

public class Exercise4 {


	public static int readDurationOldApproach(Properties props, String name) {
		String value = props.getProperty(name);
		if (value != null) {
			try {
				int i = Integer.parseInt(value);
				if (i > 0) {
					return i;
				}
			} catch (NumberFormatException nfe) {
			}
		}
		return 0;
	}

	/**
	 * Please rewrite {@link #readDurationOldApproach(java.util.Properties, String)}  by using Optional class
	 *
	 * @param props
	 * @param name
	 * @return value when is greater than 1 otherwise return 0
	 */
	public static int readDuration(Properties props, String name) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Finding a car’s insurance company name with Optionals
	 * if Car insurance name doesn't exist return Unknown
	 * rewrite {@link #getCarInsuranceNameOldStyle(com.model.Person)}
	 */
	public String getCarInsuranceName(Optional<Person> person) {
		return Exercises.replaceThisWithSolution();
	}

	public String getCarInsuranceNameOldStyle(Person person) {
		if (person != null) {
			Car car = person.getCarNoneOptional();
			if (car != null) {
				Insurance insurance = car.getInsuranceNoneOptional();
				if (insurance != null) {
					return insurance.getName();
				}
			}

		}
		return "Unknown";
	}

}
