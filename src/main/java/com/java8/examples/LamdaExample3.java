package com.java8.examples;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

import com.raj.Comparator;
import com.raj.Person;

public class LamdaExample3 {
	
	public static void main(String[] args) {
		
		Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
		
		Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		
		Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
		
		Function<Person, Integer> f1 = p -> p.getAge();
		Function<Person, String> f2 = p -> p.getFirstName();
		Function<Person, String> f3 = p -> p.getLastName();
		
		Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
		Comparator<Person> cmpPersonFirstName = Comparator.comparing(Person::getFirstName);
		Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);
		
		Comparator<Person> cmp = cmpPersonAge.thenComparing(cmpPersonFirstName);
		
		Comparator<Person> cmpPerson = Comparator.comparing(Person::getLastName)
				.thenComparing(Person::getFirstName)
				.thenComparing(Person::getAge);
	}

	// How to create new API
	
	// Lambdas + default methods + static methods
	
	// Interfaces have been modified in Java 8
	
	// Default methods
	
}


// Default Method
interface Iterable<T> {
	
	default void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		/*
		 * for (T t : this) { action.accept(t); }
		 */
	}
}

// Static method
@FunctionalInterface
interface function<T, R> {
	
	R apply(T t);
	
	static<T> Function<T, T> identity() {
		return t -> t;
	}
}
