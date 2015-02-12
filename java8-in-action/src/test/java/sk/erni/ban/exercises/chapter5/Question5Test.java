package sk.erni.ban.exercises.chapter5;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import sk.erni.ban.answers.chapter5.Question5;
import sk.erni.ban.model.Person;

import javax.script.ScriptException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * User: ban
 * Date: 11.2.2015
 * Time: 12:00
 */

public class Question5Test {

	@Before
	public void init() {
		Exercise5.init();
	}

	@Test
	public void checkPersonCreation() {
		try {
			Person person = Exercise5.createPerson("jano maly", 3);

			assertNotNull(person);
			assertEquals("jano maly", person.getName());
			assertTrue(3 == person.getAge());

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void checkPersonLongName(){
		try {
			boolean isLongName = Exercise5.isLongName("Sofonias");
			assertTrue(isLongName);

		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void checkPersonShortName(){
		try {
			boolean isLongName = Exercise5.isLongName("Jan");
			assertFalse(isLongName);

		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void checkProductCreatedInJs() {
		try {
			String expectedResult = "Beer 2 BA";
			String storeStr = Exercise5.getProductName();
			assertEquals(expectedResult, storeStr);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}


}
