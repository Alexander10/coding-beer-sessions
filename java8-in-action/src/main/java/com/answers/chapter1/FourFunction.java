package com.answers.chapter1;

@FunctionalInterface
public interface FourFunction<T, U, V, Z, R> {
	R apply(T t, U u, V v, Z z);
}