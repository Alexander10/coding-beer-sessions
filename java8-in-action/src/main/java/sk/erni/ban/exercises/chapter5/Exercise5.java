package sk.erni.ban.exercises.chapter5;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import sk.erni.ban.exercises.Exercises;
import sk.erni.ban.model.Person;

import javax.script.Invocable;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * User: ban
 * Date: 12.2.2015
 * Time: 11:38
 */

public class Exercise5 {


	private static NashornScriptEngine engine;
	private static String productInfo = "";

	public static void init() {
		engine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");

		try {
			engine.eval(new FileReader("src/main/resources/function.js"));
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create person object with js function
	 * @param name
	 * @param age
	 * @return
	 * @throws NoSuchMethodException
	 * @throws javax.script.ScriptException
	 */
	public static Person createPerson(String name, int age) throws NoSuchMethodException, ScriptException {
		String jsScript = "createPerson";
		Invocable invocable = engine;
		Person person = (Person)invocable.invokeFunction(jsScript,name,age);
		return person;
	}


	/**
	 * Method check whether name of created person is longer or equal 4
	 *
	 * @param name
	 * @throws ScriptException
	 * @throws NoSuchMethodException
	 */
	public static boolean isLongName(String name) throws ScriptException, NoSuchMethodException {

		Invocable invocable = engine;

		Person person = new Person();
		person.setName(name);

		String predicate = Exercises.replaceThisWithSolution();
		Object result = invocable.invokeFunction("runJavaMethod", predicate, person);
		return (boolean) result;
	}


	/**
	 * Return product in string form
	 * @return
	 * @throws ScriptException
	 * @throws NoSuchMethodException
	 */
	public static String getProductName() throws ScriptException, NoSuchMethodException {
		init();
		Invocable invocable = engine;
		invocable.invokeFunction("createProduct");
		return productInfo;
	}

	/**
	 * Method is called by js
	 * @param mirror - js object
	 */
	public static void fillData(ScriptObjectMirror mirror){

		String productName = Exercises.replaceThisWithSolution();
		String productPrice = Exercises.replaceThisWithSolution();
		String stock = Exercises.replaceThisWithSolution();

		productInfo = productName + " " + productPrice + " " + stock;

	}
}
