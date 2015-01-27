package com.answers.forfun;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * User: ban
 * Date: 1/22/15
 * Time: 10:24 AM
 */

public class PrimeNumberCollector implements Collector<Integer,
														Map<Boolean, List<Integer>>,
														Map<Boolean, List<Integer>>> {
	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		return () -> new HashMap<Boolean, List<Integer>>() {{
			put(true, new ArrayList<>());
			put(false, new ArrayList<>());
		}};
	}

	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
			acc.get(isPrime(acc.get(true), candidate))
					.add(candidate);
		};
	}

	/**
	 * This method could be empty because we are processing only sequential, Parallel processing is not possible here
	 *
	 * @return
	 */
	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		//merge second map into first one
		return (Map<Boolean, List<Integer>> map1,
				Map<Boolean, List<Integer>> map2) -> {
			map1.get(true).addAll(map2.get(true));
			map1.get(false).addAll(map2.get(false));
			return map1;
		};
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		//no transformation is needed than end it with identity method
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
	}

	public static boolean isPrime(List<Integer> primes, int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return takeWhile(primes, i -> i <= candidateRoot)
				.stream()
				.noneMatch(p -> candidate % p == 0);
	}

	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
		int i = 0;
		for (A item : list) {
			if (!p.test(item)) {
				return list.subList(0, i);
			}
			i++;
		}
		return list;
	}
}