package com.yellowaxe.cglibtest;

/**
 * @author khuang
 *
 * Basic concrete class used in testing cglib
 * nothing special about this at all
 *
 */
public class MyClassOrig {

	public Object openResource() {
		System.out.println("opened");
		return this;
	}

	public void closeResource() {
		System.out.println("closed");
	}

	public void doWork() {
		System.out.println("done work");
	}

}
