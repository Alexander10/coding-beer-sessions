package sk.erni.ban.exercises.chapter4;

import sk.erni.ban.exercises.Exercises;
import sk.erni.ban.model.Car;
import sk.erni.ban.model.Insurance;
import sk.erni.ban.model.Person;

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
	 * Please rewrite {@link #readDurationOldApproach(java.util.Properties, String)}  by using {@code Optional} Java 8 feature
	 * Consider using {@link OptionalUtility#stringToInt(String)}
	 * @param props
	 * @param name
	 * @return
	 */
	public static int readDuration(Properties props, String name) {
		return Exercises.replaceThisWithSolution();
	}

	/**
	 * Use {@code Optional}
	 * if car insurance name doesn't exist return Unknown
	 * rewrite {@link #getCarInsuranceNameOldStyle(sk.erni.ban.model.Person)}
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
