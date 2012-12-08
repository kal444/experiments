package com.yellowaxe.tracestack;

public class PluginImp1 implements Plugin {

	private Callback c;

	public PluginImp1(Callback c) {
		this.c = c;
	}

	public void setString(String op) {
		c.setResult(op.length());
	}
}
