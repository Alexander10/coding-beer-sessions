package sk.erni.ban.answers.chapter5;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.Arrays;

/**
 * User: ban
 * Date: 11.2.2015
 * Time: 11:54
 */

public class Question5 {

	public static String helloWorld(String name){
		return "Hello world " + name;
	}

	public static void fun2(Object obj){
		System.out.println(obj.getClass());
	}

	public static void fun3(ScriptObjectMirror mirror){
		System.out.println(mirror.getClassName() + ":" + Arrays.toString(mirror.getOwnKeys(true)));
	}
}
