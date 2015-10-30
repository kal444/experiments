package com.yellowaxe.cglibtest;

public class CglibTester {

	/**
	 * @param args - not used
	 */
	public static void main(String[] args) {

		/*
		 * only change in the main program is that instead of doing
		 * new MyClassOrig(), we need to use the Factory
		 */
		Object obj = MyClassFactory.getInstance(MyClassOrig.class);

		assert MyClassOrig.class.isAssignableFrom(obj.getClass());

		MyClassOrig br = (MyClassOrig) obj;

		br.openResource();

		br.doWork();

		br.closeResource();
	}

}
