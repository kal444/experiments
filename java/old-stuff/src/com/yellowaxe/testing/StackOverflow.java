package com.yellowaxe.testing;

public class StackOverflow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		foobar();
	}

	public static void foo() {
		bar();
	}

	public static void bar() {
		foo();
	}

	public static void foobar() {
		foobar();
	}

}
