package com.answers.chapter3;

import org.junit.Test;

/**
 * User: ban
 * Date: 1/21/15
 * Time: 1:14 PM
 */

public class Question3Test {

	@Test
	public void initTest(){
		Question3.getNumbOfArtistFromDiffNational();
		Question3.getCustomGroupedTracks();
		Question3.getTotalTrackLengthStatsOfManyTrackAlbum();
		Question3.getTotalLengthOfManyTrackAlbum();
		Question3.getTheLongestTrackFromManyTrackAlbum();
		Question3.getGroupedAlbumsByProductionYear();
	}
}
