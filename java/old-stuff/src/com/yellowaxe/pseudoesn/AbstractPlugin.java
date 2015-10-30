package com.yellowaxe.pseudoesn;

public abstract class AbstractPlugin implements Plugin {
	
	private PluginManager pluginManager;
	
	private PropertyAdapter propertyAdapter;
	
	abstract String getPropertyFileName();

	public AbstractPlugin() {
		propertyAdapter = new PropertyAdapter(getPropertyFileName());
	}
	
	public PluginManager getPluginManager() {
		return pluginManager;
	}

	public void setPluginManager(PluginManager pluginManager) {
		this.pluginManager = pluginManager; 
	}

}
