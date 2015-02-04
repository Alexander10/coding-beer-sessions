package sk.erni.ban.answers.refactoring.observer;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:04 PM
 */

public interface Subject {

	void registerObserver(Observer o);
	void notifyObservers(String tweet);
}
