package com.yellowaxe.pseudoesn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PluginManager {

	Set<Plugin> plugins = new HashSet<Plugin>();
	
	Map<Plugin, Properties> pluginSettings = new HashMap<Plugin, Properties>();
	
	public void setProperties(Plugin plugin, String key, String value) {
		Properties prop = this.pluginSettings.get(plugin);
		
		// do morething with prop here
		prop.setProperty(key, value);
		
		prop.get(key);
	}
	
	public void addPlugin(AbstractPlugin plugin) {
		plugins.add(plugin);
		plugin.setPluginManager(this);
	}

}
