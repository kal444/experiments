package com.yellowaxe.tasker.ejb;

import javax.naming.InitialContext;


public class TaskerBeanDelegate {
	
	private TaskerBeanRemote taskerManual;
	
	public void testIt() {
		System.out.println("BD Tested");
		
		try {
			InitialContext ic = new InitialContext();
			taskerManual = (TaskerBeanRemote) ic.lookup(TaskerBeanRemote.class.getName());
		} catch (Exception ex) {
			System.out.println("can't resolve tasker");
		}
		
		try {
			taskerManual.testMethod();
		} catch (TaskerException te) {
			System.out.println("ok, I got exception");
		}
	}

}
