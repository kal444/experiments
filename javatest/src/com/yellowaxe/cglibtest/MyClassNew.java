package com.yellowaxe.cglibtest;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author khuang
 *
 * a new class created with cglib interface that added some additional function calls around
 * the original doWork function
 *
 * this is the class that will be considered a proxy class
 *
 * NOTE: you can't create new methods, we can only modify existing methods
 *
 * Q: what happens if the method we want to intercept uses primitive params?
 *
 */
public class MyClassNew implements MethodInterceptor {

	public void randomFunction1() {
		System.out.println("calling some random function_1");
	}

	public void randomFunction2() {
		System.out.println("calling some random function_2");
	}

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		Object retValFromSuper = null;

		if (method.getName().equals("doWork")) {
			randomFunction1();
			retValFromSuper = proxy.invokeSuper(obj, args);
			randomFunction2();
		} else {
			retValFromSuper = proxy.invokeSuper(obj, args);
		}

		return retValFromSuper;
	}

}
