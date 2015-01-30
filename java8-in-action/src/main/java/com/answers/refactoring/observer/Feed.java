package com.answers.refactoring.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:05 PM
 */

public class Feed implements Subject {

	private List<Observer> observsers = new ArrayList<>();

	@Override
	public void registerObserver(Observer o) {
		observsers.add(o);

	}

	@Override
	public void notifyObservers(String tweet) {
		observsers.forEach( o -> o.notify(tweet));
	}
}
