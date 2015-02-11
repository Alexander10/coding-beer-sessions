package sk.erni.ban.answers.forfun;


import sk.erni.ban.model.Artist;
import sk.erni.ban.model.SampleData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.charset.Charset.defaultCharset;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * User: ban
 * Date: 1/21/15
 * Time: 4:14 PM
 */

public class Question {


	public static int countLowercaseLetters(String string) {
		return (int) string.chars()
				.filter(Character::isLowerCase)
				.count();
	}


	public static Optional<String> mostLowercaseString(List<String> strings) {
		return strings.stream()
				.max(Comparator.comparing(Question::countLowercaseLetters));
	}

	/**
	 * Fibonacci tuples series
	 * The series of Fibonacci tuples is similar; you have a sequence of a number and its successor in the series:
	 * (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)….
	 * Your task is to generate the first 20 elements of the series of Fibonacci tuples using the iterate method!
	 */
	public static List<Integer> fibonnacciSeries(int limit) {
		int init[] = new int[]{0, 1};
		List<Integer> result = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(limit).map(t -> t[0]).collect(Collectors.toList());
		return result;
	}

	/**
	 * Method for generating all pythagorean triples
	 * @param max -
	 */
	public static Stream<int[]> generatePythagoreanTriples(int max) {
		Stream<int[]> triples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a ->
						IntStream.rangeClosed(1, 100)
								.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
								.mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
				);

		return triples;
		//better solution sqrt is calculated only once
//		Stream<double[]> pythagoreanTriples2 =
//				IntStream.rangeClosed(1, 100).boxed()
//						.flatMap(a ->
//								IntStream.rangeClosed(a, 100)
//										.mapToObj(
//												b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
//										.filter(t -> t[2] % 1 == 0));
	}

	public static void getUniqueCharacters(String[] arr) {
		List<String> words = Arrays.asList("Java8", "In", "Action", "Lambdas");
		List<String> characters = words.stream().map(a -> a.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());//map( a -> a.split("")).distinct().collect(Collectors.toList());
		//return characters;
	}

	public static void testMap() {
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> lengthOfWords = words.stream().map(String::length).collect(Collectors.toList());
		lengthOfWords.forEach(System.out::println);
	}

	/**
	 * Given two lists of numbers, how would you return all pairs of numbers? For example,
	 * given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3,3), (3, 4)].
	 * For simplicity, you can represent a pair as an array with two elements + return only pairs whose sum is divisible by 3
	 */
	public static List<int[]> getPairsWhereSumIsDivisibleBy3(List<Integer> numbers1, List<Integer> numbers2) {

		List<int[]> result = numbers1.stream().flatMap(n1 -> numbers2.stream().map(n2 -> new int[]{n1, n2})).filter((n1) -> (n1[0] + n1[1]) % 3 == 0).collect(Collectors.toList());
//		List<int[]> result2 = numbers1.stream().flatMap( n1 -> numbers2.stream().filter( n2 -> (n1+n2)%3==0).map( n2 -> new int[] {n1,n2})).collect(Collectors.toList());
		return result;
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

	public static Map<String, Long> countWords(Stream<String> names) {
		return names.collect(groupingBy(name -> name, counting()));
	}

	public static List<String> elementFirstToUpperCaseLambdas(List<String> words) {
		return words.stream()
				.map(value -> { // <1>
					char firstChar = Character.toUpperCase(value.charAt(0));
					return firstChar + value.substring(1);
				})
				.collect(Collectors.<String>toList());
	}

	private static final Pattern SPACES = Pattern.compile("\\w+");

	public static Map<String, Long> countWordsIn(Path path) throws IOException {
		Stream<String> words = Files.readAllLines(path, defaultCharset())
				.stream()
				.flatMap(line -> SPACES.splitAsStream(line));

		return countWords(words);
	}

	public static List<Artist> useOverloadedCollectMethod(){
		List<Artist> artists = SampleData.membersOfTheBeatles.stream().filter( art -> art.getNationality().equals("us"))
				.collect(ArrayList::new, List::add, ArrayList::addAll);
		return artists;
	}

	public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
		return IntStream.rangeClosed(2, n).boxed()
				.collect(new PrimeNumberCollector());
	}

	public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
				.collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}

	public static boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot)
				.noneMatch(i -> candidate % i == 0);
	}

	/**
	 * This method measure executing time the called method
	 */
	public static void testCollectorApproaches(){
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			partitionPrimes(1_000_000);
			long duration = (System.nanoTime() - start) / 1_000_000;
			if (duration < fastest) fastest = duration;
		}
		System.out.println(
				"Fastest execution done in " + fastest + " msecs");
	}
}
