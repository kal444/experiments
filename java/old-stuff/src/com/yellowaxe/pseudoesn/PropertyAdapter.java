package com.yellowaxe.pseudoesn;

import java.util.Properties;

public class PropertyAdapter {
	
	private String propertyFilename;
	
	private Properties properties;
	
	public PropertyAdapter(String fileName) {
		this.propertyFilename = fileName;
	}
	
	public Properties loadProperties() {
		this.properties = null;
		return null; // TODO
	}
	
	public void persistProperties() {
	}
	
	public String getProperty(String key) {
		return null; // TODO
	}

	public void setProperty(String key, String value) {
		
	}
}
