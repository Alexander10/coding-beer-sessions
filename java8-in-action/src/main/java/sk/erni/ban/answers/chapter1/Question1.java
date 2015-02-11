package sk.erni.ban.answers.chapter1;


import sk.erni.ban.model.Album;
import sk.erni.ban.model.Artist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * User: ban
 * Date: 1/19/15
 * Time: 10:15 AM
 */

public class Question1 {


	public static ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MMM.yyyy")) ;

	/**
	 * Checks whether the artist comes from US
	 *
	 * @return
	 */
	public static boolean isSomeArtistFromUS(List<Artist> artists) {
		return itemMatchPredicate(artists, (artist) -> artist.isFrom("US"));
	}

	public static boolean existJohnBornAt1943(List<Artist> artists) {
		return itemMatchPredicate(artists, (artist) -> artist.getFirstName().equals("John") && artist.getYearOfBirth() == 1943);

	}

	/**
	 * Creates Lambda expression which will find all artists with first name John
	 *
	 * @return
	 */
	public static Function<List<Artist>, List<Artist>> getArtistsWithFirstNameJohn() {
		return (artists) -> {
			List<Artist> johns = new ArrayList<>();
			artists.forEach( artist -> {
				if(artist.getFirstName().equalsIgnoreCase("John")){
					johns.add(artist);
				}
			});
			return  johns;
		};
	}

	/**
	 * Creates Lambda expression which will find the oldest artist
	 *
	 * @return
	 */
	public static Function<List<Artist>, Artist> getOldestArtist() {
		return (List<Artist> artists) -> {
			for (Artist art : artists) {
				if (itemMatchPredicate(artists, (Artist artInner) -> artInner.getYearOfBirth() > art.getYearOfBirth())) {
					return art;
				}
			}
			return null;
		};
	}


	/**
	 * Method creates new Artist object, but by using constructor reference !!! => Artist::new
	 *
	 * @return
	 */
	public static Artist createArtist(String firstName, String secondName, Integer yearOfBirth, String nationality) {
		FourFunction<String, String,Integer,String, Artist> function = Artist::new;
		return function.apply("Palko", "Habera", 1965, "SK");
	}

	/**
	 *
	 * @param f
	 * @param g
	 * @return
	 */
	public static Function<List<Artist>, Artist> concat(Function<List<Artist>, List<Artist>> f, Function<List<Artist>, Artist> g){
		return f.andThen(g);
	}

	/**
	 * Simple method for checking if item match with the predicate condition
	 *
	 * @param items
	 * @param predicate -
	 * @param <T>
	 * @return
	 */
	public static <T> boolean itemMatchPredicate(List<T> items, Predicate<T> predicate) {
		for (T item : items) {
			if (predicate.test(item)) {
				return true;
			}
		}
		return true;
	}

	/**************************************************** END OF QUESTIONS ***********************************************/

	/**
	 *
	 * @param albums
	 * @return
	 */
	public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
		return albums.collect(groupingBy(Album::getMainMusician));
	}

	/**
	 * Sort artist by first name
	 * Because there can exist more artists with the same name sort artists also by second name
	 *
	 * @return
	 */
	public static List<Artist> doubleSort(List<Artist> artists) {
		artists.sort(Comparator.comparing((Artist a) -> a.getFirstName()).thenComparing(Artist::getSecondName));
		return artists;
	}


}
