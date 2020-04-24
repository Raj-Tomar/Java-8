package com.java8.examples;

import java.util.Comparator;

public class LamdaExample1 {

	// First Example
	// A basic Comparator
	Comparator<String> comparator = new Comparator<String>() {

		public int compare(String s1, String s2) {
			return Integer.compare(s1.length(), s2.length());
		}
	};

	// We can use it to sort an array of String
	// Arrays.sort(tabString, comparator);
	
	// Becomes below code in Java 8
	Comparator<String> com = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
	
	// In the case there is returned value:
	Comparator<String> c = (String s1, String s2) -> {
		System.out.println("I am comparing Strings");
		return Integer.compare(s1.length(), s2.length());
	};
	
	// We can omits the types of the parameters.
	// Becomes
	Comparator<String> c1 = (s1, s2) -> {
		System.out.println("I am comparing Strings");
		return Integer.compare(s1.length(), s2.length());
	};

	// ======================================================================================================================

	// Second Example

	Runnable r = new Runnable() {

		@Override
		public void run() {
			int i = 0;
			while (i++ < 10) {
				System.out.println("It works!");
			}
		}
	};
	
	// We can execute this in another thread
	// Executors.newSingleThreadExecute().execute(r);
	
	// Becomes below code in Java 8
	Runnable r1 = () -> {
		int i = 0;
		while (i++ < 10) {
			System.out.println("It works!");
		}
	};
	
	// ======================================================================================================================
	
	// What did we do?
	
	// We wrote some code in an anonymous class
	// and we passed it to another piece of code
	// that executed it "later"
	// and another context (thread)
	
	// We need to understand
	// We passed code as a parameter
	// and we used anonymous class, because it is the only way to do  in Java.
	
	// We can put modifiers on the parameter of a lambda expression
		// The final keyword
		// Annotation
	// It is not possible to specify returned type of a lambda expression
	
}
