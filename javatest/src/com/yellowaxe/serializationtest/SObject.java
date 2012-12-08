package com.yellowaxe.serializationtest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SObject implements Serializable {

	static final long serialVersionUID = 1;
	/*
	 * static fields aren't affect by serialization because they are intialized when the class
	 * is loaded
	 */
	static List<Integer> l;
	static {
		System.out.println("static initializer for SObject");
		l = new ArrayList<Integer> ();
		l.add(new Integer(4));
		l.add(new Integer(5));
	}

	Integer ival = new Integer(50);

	/*
	 * trasient values aren't serialized, so you should always initialize transient
	 * values before using them
	 */
	transient Double dval = new Double(6.66);
	transient double pdval = 7.77;

}
