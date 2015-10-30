package com.yellowaxe.tracestack;

public class PluginImp2 implements Plugin {

	private Callback c;

	public PluginImp2(Callback c) {
		this.c = c;
	}

	public void setString(String op) {
		c.setResult(op.length() * 2);
	}
}
