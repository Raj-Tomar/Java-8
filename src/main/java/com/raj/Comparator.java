package com.raj;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

	public int compare(T t1, T t2);

	/*
	 * public static Comparator<Person> comparing(Function<Person, Integer> f) {
	 * 
	 * return (p1, p2) -> f.apply(p1) - f.apply(p2); }
	 */

	// Does not compile below code

	/*
	 * public static Comparator<Person> comparing(Function<Person, String> f) {
	 * 
	 * return (p1, p2) -> -1; }
	 */

	// need to do some trick in above static method

	/*
	 * public static Comparator<Person> comparing(Function<Person, Comparable> f) {
	 * 
	 * return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2)); }
	 */

	public static <U> Comparator<U> comparing(Function<U, Comparable> f) {

		return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
	}

	public default Comparator<T> thenComparing(Comparator<T> cmp) {

		return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
	}

	public default Comparator<T> thenComparing(Function<T, Comparable> f) {
		return thenComparing(comparing(f));
	}
}
