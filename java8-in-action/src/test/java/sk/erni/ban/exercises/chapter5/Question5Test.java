package sk.erni.ban.exercises.chapter5;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * User: ban
 * Date: 11.2.2015
 * Time: 12:00
 */

public class Question5Test {

	@Test
	public void test(){
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval("print('Hello world!');");
			engine.eval(new FileReader("src/main/resources/function.js"));

			Invocable invocable = (Invocable) engine;
			Object result = invocable.invokeFunction("fun1","Peter parker");

			System.out.println(result);
			System.out.println(result.getClass());



		} catch (ScriptException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		} catch (FileNotFoundException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		} catch (NoSuchMethodException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

		}
	}
}
