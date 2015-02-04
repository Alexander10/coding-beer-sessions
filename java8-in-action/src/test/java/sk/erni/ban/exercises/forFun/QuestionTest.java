package sk.erni.ban.exercises.forFun;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 11:37 AM
 */

public class QuestionTest {

	@Test
	public void test() {
		LocalDate date = LocalDate.of(2014, 3, 18);
		System.out.println(date.toString());
		date.withDayOfMonth(10);
		date = date.withDayOfYear(100);
		date.with(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH, 7);
		date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		System.out.println(date.toString());
		LocalTime time = LocalTime.of(12,12,12);
		date = date.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(date);
		 time.atDate(date);
		date.atTime(time);

		LocalDate date1 = LocalDate.of(2014, 3, 18);
		date1 = date1.with(ChronoField.MONTH_OF_YEAR, 9);
		date1 = date1.plusYears(2).minusDays(2);
		date.withYear(2016);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
		LocalDate date2 = LocalDate.of(2014, 04, 18);
		String fomrattedDate = date2.format(formatter);

		DateTimeFormatter italianFormater = new DateTimeFormatterBuilder()
									.appendText(ChronoField.DAY_OF_MONTH)
									.appendLiteral(". ")
									.appendText(ChronoField.DAY_OF_MONTH)
									.appendLiteral(" ")
									.appendText(ChronoField.YEAR)
									.parseCaseInsensitive()
									.toFormatter(Locale.ITALIAN);

		ZoneId zone = ZoneId.of("Europe/Rome");
		ZonedDateTime zonedDateTime = date1.atStartOfDay(zone);


		//LocalTime time2 = LocalTime.from(ChronoField.t);
	}

	@Test
	public void numberOfLowerCaseLettersInString(){

	}

	@Test
	public void whichStringHasTheMostLowercaseLetters(){

	}

	@Test
	public void firstFibonacciSeries_20(){

	}

	@Test
	public void pythagoreanTriples_100(){

	}

	@Test
	public void numbersDivisiableBy_3(){

	}

	@Test
	public void primeNumbersLowerThan_1000(){

	}
}
