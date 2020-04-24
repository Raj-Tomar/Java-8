package com.java8.examples;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

import com.raj.Person;

public class LamdaExample2 {

	
	// What are Method References?
	// An alternative syntax for lambda expression
	
	
	// First Example
	Function<Person, Integer> f = person -> person.getAge();
	
	// By Method References
	Function<Person, Integer> f1 = Person::getAge;
	
	// ======================================================================================================================
	
	// Second Example
	
	BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
	
	BinaryOperator<Integer> sum1 = (i1, i2) -> Integer.sum(i1, i2);
	
	BinaryOperator<Integer> sum2 = Integer::sum;
	
	BinaryOperator<Integer> max = Integer::max;
	
	// ======================================================================================================================
	
	// Third Example
	
	Consumer<String> printer = s -> System.out.println(s);
	
	Consumer<String> printer1 = System.out::println;
	
	// So far lambda expression is a new syntax
	// and a new way of writing instances of anonymous classes
	// an alternative syntax: Method References
}
