package  com.answers.chapter2;

import com.model.Album;
import com.model.Artist;
import com.model.SampleData;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * User: ban
 * Date: 1/20/15
 * Time: 10:40 AM
 */

public class Question2 {
	private static List<Artist> artistList = SampleData.membersOfTheBeatles;
	private static List<Album> albumList = SampleData.albums;

	public static void streamProcessing() {

		List<String> artistsNames = artistList.stream().filter((a) -> {
			System.out.println("filter " + a.getFirstName());
			return a.getYearOfBirth() > 1941;
		}).map((n) -> {
			System.out.println("map " + n.getYearOfBirth());
			return n.getFirstName();
		}).collect(Collectors.toList());
	}

	/**
	 * Given two lists of numbers, how would you return all pairs of numbers? For example,
	 * given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3,3), (3, 4)].
	 * For simplicity, you can represent a pair as an array with two elements.
	 */
	public static void returnPairs() {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		List<int[]> result = numbers1.stream().flatMap(
				n1 -> numbers2.stream().map(
						n2 -> new int[]{n1, n2})
		).collect(Collectors.toList());
		result.forEach(System.out::println);
	}

	/**
	 * Given two lists of numbers, how would you return all pairs of numbers? For example,
	 * given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3,3), (3, 4)].
	 * For simplicity, you can represent a pair as an array with two elements + return only pairs whose sum is divisible by 3
	 */
	public static void getPairsWhereSumIsDivisibleBy3() {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		List<int[]> result = numbers1.stream().flatMap(n1 -> numbers2.stream().map(n2 -> new int[]{n1, n2})).filter((n1) -> (n1[0] + n1[1]) % 3 == 0).collect(Collectors.toList());
//		List<int[]> result2 = numbers1.stream().flatMap( n1 -> numbers2.stream().filter( n2 -> (n1+n2)%3==0).map( n2 -> new int[] {n1,n2})).collect(Collectors.toList());
		System.out.println(result.size());
	}


	public static void testMap() {
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> lengthOfWords = words.stream().map(String::length).collect(Collectors.toList());
		lengthOfWords.forEach(System.out::println);


	}

	public static List<Integer> getLengthOfNames() {

		List<Integer> result = artistList.stream().map(Artist::getFirstName).map(String::length).collect(Collectors.toList());
		result.forEach(System.out::println);
		return null;
	}

	/**
	 * return unique date of birth
	 */
	public static List<Integer> getUniqueDateOfBirth() {
		List<Integer> result = artistList.stream().map((a) -> a.getYearOfBirth()).distinct().collect(Collectors.toList());
		result.forEach(System.out::println);
		return null;
	}

	public static List<Character> getUniqueCharacters() {
		List<String> words = Arrays.asList("Java8", "In", "Action", "Lambdas");
		List<String> characters = words.stream().map(a -> a.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());//map( a -> a.split("")).distinct().collect(Collectors.toList());
		return null;
	}


	public static void findMekyZbirka() {
		artistList.stream().filter(a -> a.getFirstName().equalsIgnoreCase("Meky")).findAny().ifPresent(d -> System.out.println(d.getFirstName()));
	}

	/**
	 * By this task please use reduce and map functions and ....
	 *
	 * @return number of american singers
	 */
	public static Integer getNumberOfAmericansWithUsingReduce() {
		Integer americans = artistList.stream().filter(a -> a.isFrom("US")).map(d -> 1).reduce(0, Integer::sum);
		return americans;
	}

	/**
	 * Find all Albums whose were produced in the year 1980 and sort them by name
	 */
	public static void findAlbums() {
		List<Album> result = albumList.stream().filter(a -> a.getProductionYear() == 1980).sorted(Comparator.comparing(Album::getName)).collect(Collectors.toList());
		albumList.stream().filter(a -> a.getProductionYear() == 1980).sorted(Comparator.comparing(Album::getName)).forEach(System.out::println);

	}

	public static void getOldestArtist() {

	}

	/**
	 * Unique years when was CD produced
	 */
	public static void findUniqueYearsForAlbumProduction() {
		List<Integer> result = albumList.stream().map(Album::getProductionYear).distinct().collect(Collectors.toList());
		albumList.stream().map(Album::getProductionYear).distinct().forEach(System.out::println);
	}

	/**
	 * Get names of all albums in one string delimited by ;
	 * or return empty string
	 */
	public static void getAllAlbumsInOne() {
		String str = albumList.stream().map(a -> a.getName() + ";").reduce(String::concat).orElse("");
		System.out.println(str);
	}

	/**
	 * Get album with only one track
	 */
	public static void getUniqueAlbumsWithOneArtist() {
//		Album album = albumList.stream().filter( a -> a.getTrackList().size() > 0);
	}

	/**
	 * Pythagorean triples
	 */
	public static void getPythagoreanTriples() {
		Stream<int[]> triples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a ->
						IntStream.rangeClosed(1, 100)
								.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
								.mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
				);
		triples.forEach(t-> System.out.println(t[0] + " " + t[1] + " " + t[2]));

		//better solution sqrt is calculated only once
//		Stream<double[]> pythagoreanTriples2 =
//				IntStream.rangeClosed(1, 100).boxed()
//						.flatMap(a ->
//								IntStream.rangeClosed(a, 100)
//										.mapToObj(
//												b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
//										.filter(t -> t[2] % 1 == 0));
	}

	public static long getNumberOfUniqueWordsInNewSong(){
	   long uniqueWords = 0;
		try(Stream<String> lines = Files.lines(Paths.get("src/main/resources/newSong.txt"), Charset.defaultCharset())){
			uniqueWords = lines.flatMap( f -> Arrays.stream(f.split("\\s"))).distinct().count();
		} catch (IOException e) {
			System.out.println("Some problems with newSong file: " + e.toString() );
		}
		System.out.println("unique words" + uniqueWords);
		return uniqueWords;
	}

	/**
	 * Fibonacci tuples series
	 * The series of Fibonacci tuples is similar; you have a sequence of a number and its successor in the series:
	 * (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)….
	 * Your task is to generate the first 20 elements of the series of Fibonacci tuples using the iterate method!
	 */
	public static void fibonnacciSeries(){
		int init[] = new int[]{0,1};
		List<Integer> result = Stream.iterate(new int[]{ 0, 1}, t-> new int[]{t[1],t[0]+t[1]}).limit(20).map(t->t[0]).collect(Collectors.toList()) ;
		result.stream().forEach(System.out::println);
	}
}
