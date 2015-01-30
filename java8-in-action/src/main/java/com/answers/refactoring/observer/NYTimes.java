package com.answers.refactoring.observer;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 3:01 PM
 */

public class NYTimes implements Observer {
	@Override
	public void notify(String tweet) {
		if(tweet != null && tweet.contains("money")){
			System.out.println("Breaking news int NYTimes: " + tweet);
		}
	}
}
