package com.yellowaxe.tasker.web;

public class TaskBean {
	
	int taskNumber;
	String taskDescription;
	
	public TaskBean() {
		// TODO Auto-generated constructor stub
	}
	
	public TaskBean(int number, String task) {
		taskNumber = number;
		taskDescription = task;
	}
	
	public int getTaskNumber() {
		return taskNumber;
	}
	public void setTaskNumber(int taskNumber) {
		this.taskNumber = taskNumber;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	
}
