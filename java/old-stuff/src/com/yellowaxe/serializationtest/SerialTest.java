package com.yellowaxe.serializationtest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		SObject s = new SObject();

		outputSObject(s);

		// serialization
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(s);
		oos.close();
		byte [] b = bos.toByteArray();

		System.out.println("serialized");

		// deserialzation
		ByteArrayInputStream bis = new ByteArrayInputStream(b);
		ObjectInputStream ois = new ObjectInputStream(bis);
		SObject so = (SObject) ois.readObject();
		ois.close();

		outputSObject(so);
	}

	public static void outputSObject(SObject s) {

		for (Integer i : SObject.l) {
			System.out.println("list: " + i);
		}
		System.out.println("ival: " + s.ival);
		System.out.println("dval: " + s.dval);
		System.out.println("pdval: " + s.pdval);

	}
}
