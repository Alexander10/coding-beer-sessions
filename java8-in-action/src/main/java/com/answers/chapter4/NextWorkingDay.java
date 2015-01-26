package com.answers.chapter4;

import java.time.DayOfWeek;
import java.time.temporal.*;

/**
 * User: ban
 * Date: 1/26/15
 * Time: 12:18 PM
 */

public class NextWorkingDay implements TemporalAdjuster {
	@Override
	public Temporal adjustInto(Temporal temporal) {
		int daysToAdd = 1;
		DayOfWeek dow =
				DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

		if (dow == DayOfWeek.FRIDAY) daysToAdd = 3;
		else if (dow == DayOfWeek.SATURDAY) daysToAdd = 2;
		return temporal.plus(daysToAdd, ChronoUnit.DAYS);
	}
}
