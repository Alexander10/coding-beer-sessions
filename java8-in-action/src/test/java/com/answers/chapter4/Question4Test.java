package com.answers.chapter4;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * User: ban
 * Date: 1/23/15
 * Time: 2:00 PM
 */

public class Question4Test {

	@Test
	public void testDuration(){
		Question4.initDuration();
		Properties param = new Properties();

		assertEquals(5, Question4.readDurationOldApproach(param, "a"));
		assertEquals(0, Question4.readDurationOldApproach(param, "b"));
		assertEquals(0, Question4.readDurationOldApproach(param, "c"));
		assertEquals(0, Question4.readDurationOldApproach(param, "d"));


		assertEquals(5, Question4.readDuration(param, "a"));
		assertEquals(0, Question4.readDuration(param, "b"));
		assertEquals(0, Question4.readDuration(param, "c"));
		assertEquals(0, Question4.readDuration(param, "d"));
	}
}
