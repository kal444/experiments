package com.yellowaxe.cglibtest;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class MyClassFactory {
	public static Object getInstance(Class<?> cls) {
		try {
			Callback interceptor = new MyClassNew();
			Enhancer e = new Enhancer();
			e.setSuperclass(cls);
			e.setCallback(interceptor);
			Object record = e.create();
			return record;
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return null;
	}
}
