package sk.erni.ban.exercises.forFun;

import org.junit.Test;
import sk.erni.ban.exercises.forfun.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
		assertEquals(100, Exercise.countLowercaseLetters(text));
	}

	@Test
	public void findSentenceWithTheMostLowercaseLetters() {
		String[] texts = text.split(".");
		Exercise.mostLowercaseString(Arrays.asList(texts));

	}

	@Test
	public void firstFibonacciSeries_20() {
		List<Integer> fibonacciSerie = Exercise.fibonnacciSeries(20);

		assertThat(fibonacciSerie, is(equalTo(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55))));
	}

	@Test
	public void pythagoreanTriples_100() {
		Stream<int[]> triples = Exercise.generatePythagoreanTriples(100);
		int sum = triples.map(value -> IntStream.of(value).sum()).reduce(0, Integer::sum);
	}

	@Test
	public void numbersDivisiableBy_3() {
		List<int[]> numbersPair = Exercise.getPairsWhereSumIsDivisibleBy3(100);
		int sum = numbersPair.stream().map(value -> IntStream.of(value).sum()).reduce(0, Integer::sum);

	}

	@Test
	public void primeNumbersLowerThan_1000() {
		Map<Boolean, List<Integer>> primeAndNonPrimeNumbers = Exercise.getPrimeAndNonPrimeNumbers(1000);
		List<Integer> primeNumbers = primeAndNonPrimeNumbers.get(true);
		int sum = primeNumbers.stream().reduce(0, Integer::sum);
	}
}
