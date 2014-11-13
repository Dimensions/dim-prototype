/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.plugin;

import java.io.File;

/**
 * Project: Dimensions
 * 
 * File: Plugin.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public abstract class Plugin {
	
	private String name;
	private String author;
	private String description;
	private String jarFilePath;
	private File pluginDirectory;
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public final String getName(){
		return name;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public final String getDescription(){
		return description;
	}
	
	public final String getJARFilePath(){
		return jarFilePath;
	}
	
	public File getPluginDirectory(){
		return pluginDirectory;
	}
	
	public void handleException(Exception e){}
	
}
