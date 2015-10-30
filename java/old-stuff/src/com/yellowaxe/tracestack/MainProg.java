package com.yellowaxe.tracestack;

public class MainProg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Plugin [] pque = {
				new PluginImp1(new Callback(){
					public void setResult(int result) {
						System.out.println("result: " + result);
					}
				}),
				new PluginImp1(new Callback(){
					public void setResult(int result) {
						System.out.println("result: " + result);
					}
				}),
				new PluginImp2(new Callback(){
					public void setResult(int result) {
						System.out.println("result: " + result);
					}
				}),
				new PluginImp2(new Callback(){
					public void setResult(int result) {
						System.out.println("result: " + result);
						try {
							throw new RuntimeException("test");
						} catch (Exception e) {
							StackTraceElement [] stes = e.getStackTrace();
							for (StackTraceElement ste : stes) {
								System.out.println(ste.getClassName());
							}
						}
					}
				})
		};

		for (Plugin p : pque) {
			p.setString("hello world!");
		}
	}
}
