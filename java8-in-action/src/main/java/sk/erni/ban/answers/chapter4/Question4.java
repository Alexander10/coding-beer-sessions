package sk.erni.ban.answers.chapter4;



import sk.erni.ban.exercises.chapter4.OptionalUtility;
import sk.erni.ban.model.Car;
import sk.erni.ban.model.Insurance;
import sk.erni.ban.model.Person;

import java.util.Optional;
import java.util.Properties;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 12:28 PM
 */

public class Question4 {


	/**
	 * Finding a car’s insurance company name with Optionals
	 * if Car insurance name doesn't exist return Unknown
	 */
	public String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
				.flatMap(Car::getInsurance)
				.map(Insurance::getName)
				.orElse("Unknown");
	}

	public String getCarInsuranceNameOldStyle(Person person) {
		if (person != null) {
			Car car = person.getCarNoneOptional();
			if(car != null){
				Insurance insurance = car.getInsuranceNoneOptional();
				if(insurance != null){
					return insurance.getName();
				}
			}

		}
		return "Unknown";
	}

	public String getCarInsuranceName(Optional<Person> person, int minAge) {
		return person
				.filter(p -> minAge <= p.getAge())
				.flatMap(Person::getCar)
				.flatMap(Car::getInsurance)
				.map(Insurance::getName)
				.orElse("Unknown");
	}

	public static void initDuration(){
		Properties props = new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");
		props.setProperty("c", "-3");
	}

	/**
	 * Please write new method for reading duration by using Optional class
	 *
	 * @param props
	 * @param name
	 * @return  value when is greater than 1 otherwise return 0
	 */
	public static int readDuration(Properties props, String name) {
		return Optional.ofNullable(props.getProperty(name))
				.flatMap(OptionalUtility::stringToInt)
				.filter(i -> i > 0)
				.orElse(0);
	}

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


}
