/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event;

import java.lang.reflect.Method;

import xyz._5th.dimensions.api.plugin.Plugin;

/**
 * Project: Dimensions
 * 
 * File: PluginMethodPair.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PluginMethodPair {
	
	private Plugin plugin;
	private Method method;
	
	/**
	 * @param p
	 * @param method
	 */
	public PluginMethodPair(Plugin p, Method m) {
		this.plugin = p;
		this.method = m;
	}

	/**
	 * @return
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * @return
	 */
	public Plugin getPlugin() {
		return plugin;
	}

}
