package com.yellowaxe.type;

import java.util.ArrayList;
import java.util.List;

public class Java5GenericsTest {

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		List<Object> b = new ArrayList<Object>();

		System.out.println(a.getClass());
		System.out.println(b.getClass());

		/*
		 * type erasure where the type information is removed during
		 * compilation. And the runtime only knows about the Raw types.
		 * 
		 * as you can see, both are instances of List, and the type information
		 * is gone
		 */
		assert (a instanceof List);
		assert (b instanceof List);

		Java5GenericsTest inst = new Java5GenericsTest();

		/*
		 * using <? extends T> indicates to the compiler that we NEED to read T
		 * from the collection, so only allow T and T's subclasses in the
		 * collection
		 * 
		 * That is, List<B> is compatible with List<? extends A>
		 */
		List<B> bList = new ArrayList<B>();
		bList.add(inst.new B());

		List<? extends A> aAndBelow = bList;
		A var = aAndBelow.get(0);
		System.out.println(var);

		/*
		 * using <? super T> indicates to the compiler that we NEED to write T
		 * into the collection, but since the reading end of the collection
		 * might want to pull out either T or superclasses of T, this form of
		 * wildcard says that the collection is compatible with T or
		 * superclasses of T
		 * 
		 * That is, List<A> is compatible with List<? super B>
		 */
		List<A> aList = new ArrayList<A>();

		List<? super B> bAndAbove = aList;
		bAndAbove.add(inst.new B());

		A var2 = aList.get(0);
		System.out.println(var2);

		// without using the wildcards, the genericized types are invariants
		List<Object> lo = new ArrayList<Object>();
		List<String> ls = new ArrayList<String>();

		// the following line would cause a compilation error
		// lo = ls;

		// this is different from arrays, where typed arrays are covariants
		Object o = new Object();
		String s = new String();
		// covariant
		o = s;

		Object[] oArray = new Object[0];
		String[] sArray = new String[0];

		// covariant
		oArray = sArray;
	}

	public class A {
		Object foo(A var) {
			return null;
		}
	}

	public class B extends A {
		// overriding with covariant return type
		// with invariant parameters
		@Override
		String foo(A var) {
			return null;
		}
	}
}
