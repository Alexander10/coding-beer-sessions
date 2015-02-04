package sk.erni.ban.answers.refactoring.observer;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:03 PM
 */

public class LeMonde implements Observer {
	@Override
	public void notify(String tweet) {
		if(tweet != null && tweet.contains("wine")){
			System.out.println("Today cheese, wine and news: " + tweet);
		}
	}
}
