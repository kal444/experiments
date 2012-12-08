package com.yellowaxe.streamtest;

import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends OutputStream {

	@Override
	public void write(int b) throws IOException {
		System.out.println("write called");
	}

	@Override
	public void flush() throws IOException {
		System.out.println("flush called");
	}

	@Override
	public void close() throws IOException {
		System.out.println("close called");
	}
}
