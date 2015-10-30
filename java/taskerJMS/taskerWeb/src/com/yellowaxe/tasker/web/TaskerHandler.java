package com.yellowaxe.tasker.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.yellowaxe.tasker.ejb.TaskerBeanDelegate;

public class TaskerHandler {
	
	private List<TaskBean> master;
	
	public TaskerHandler() {
		// TODO Auto-generated constructor stub
		master = new ArrayList<TaskBean>();
		
		for (int i = 0; i < 6; i++) {
			master.add(new TaskBean(i, "test " + (i)));
		}
	}
	
	public List<TaskBean> getMaster() {
		return master;
	}
	
	public String detail() {
		FacesContext faceContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)faceContext.getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		System.err.println("got id: " + id);

		return "edit";
	}
	
	public String test() {
		
		TaskerBeanDelegate tbd = new TaskerBeanDelegate();
		
		tbd.testIt();
		
		return "again";
	}

}
