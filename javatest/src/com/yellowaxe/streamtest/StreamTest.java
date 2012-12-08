package com.yellowaxe.streamtest;

import java.io.PrintWriter;


public class StreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		MyOutputStream o = new MyOutputStream();
		PrintWriter p = new PrintWriter(o);
		p.print("test");
		// the flush and close calls are propagated downstream
		p.flush();
		p.close();
	}

}
