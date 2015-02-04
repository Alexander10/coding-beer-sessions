package sk.erni.ban.answers.refactoring.observer;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:02 PM
 */

public class Guardian implements Observer {
	@Override
	public void notify(String tweet) {
		if(tweet != null && tweet.contains("queen")) {
			System.out.println("Yet another news in London: " + tweet);
		}
	}
}
