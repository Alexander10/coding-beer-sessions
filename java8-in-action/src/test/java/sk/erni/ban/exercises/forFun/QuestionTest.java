package sk.erni.ban.exercises.forFun;

import org.junit.Test;
import sk.erni.ban.answers.forfun.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 11:37 AM
 */

public class QuestionTest {


	private static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ut molestie sem. Vivamus finibus eget mi sit amet porta. " +
			"Etiam aliquet non enim sed ornare. Donec fermentum consequat sem nec aliquet. " +
			"Maecenas iaculis tempor nunc, quis volutpat orci efficitur non. Suspendisse congue arcu metus, quis sagittis eros tristique id. " +
			"Curabitur rutrum sodales lectus, at pharetra odio. Pellentesque sapien nunc, consectetur eu diam vitae, rhoncus pulvinar augue. " +
			"Integer sagittis, lectus eget vehicula pretium, diam elit dictum felis, in volutpat dui elit a tellus.";


	@Test
	public void numberOfLowerCaseLettersInString() {
		assertEquals(446, Question.countLowercaseLetters(text));
	}

	@Test
	public void findSentenceWithTheMostLowercaseLetters() {
		String[] texts = text.split("\\.");
		Optional<String> result = Question.mostLowercaseString(Arrays.asList(texts));
		String expectedResult = "Integer sagittis, lectus eget vehicula pretium, diam elit dictum felis, in volutpat dui elit a tellus";
		assertEquals(expectedResult, result.get().trim());

	}

	@Test
	public void firstFibonacciSeries_20() {
		List<Integer> fibonacciSerie = Question.fibonnacciSeries(20);

		assertThat(fibonacciSerie, is(equalTo(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181))));
	}

	@Test
	public void pythagoreanTriples_100() {
		Stream<int[]> triples = Question.generatePythagoreanTriples(100);
		int sum = triples.map(value -> IntStream.of(value).sum()).reduce(0, Integer::sum);
		assertEquals(19776, sum);
	}

	@Test
	public void numbersPairDivisibleBy_3() {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 5, 6);
		List<Integer> numbers2 = Arrays.asList(3, 4, 8, 10);

		List<int[]> numbersPair = Question.getPairsWhereSumIsDivisibleBy3(numbers1, numbers2);

		int sum = numbersPair.stream().map(value -> IntStream.of(value).sum()).reduce(0, Integer::sum);
		assertEquals(66, sum);
	}

	@Test
	public void primeNumbersLowerThan_1000() {
		Map<Boolean, List<Integer>> primeAndNonPrimeNumbers = Question.partitionPrimes(1000);
		List<Integer> primeNumbers = primeAndNonPrimeNumbers.get(true);
		int sum = primeNumbers.stream().reduce(0, Integer::sum);
		assertEquals(76127, sum);

	}
}
