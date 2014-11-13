/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api;

import xyz._5th.dimensions.api.cmd.CommandRegistry;

/**
 * Project: Dimensions
 * 
 * File: Dimensions.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public abstract class Dimensions {
	
	public static final String VERSION_NAME = "1.8";
	public static final int[] PROTOCOL_VERSIONS = {4, 5, 47};
	
	public static Dimensions dimensions;
	
	public static void setServer(Dimensions instance){
		if(dimensions != null){
			throw new RuntimeException("Server already exists");
		}
		dimensions = instance;
	}
	
	public static Dimensions getServer(){
		return dimensions;
	}
	
	public abstract void dispatchCommand(String cmd);
	
	public abstract Player getPlayer(String name);
	
	public abstract void stop();
	
	public abstract Config getConfig();
	
	public abstract EventFactory getEventFactory();
	
	public abstract CommandRegistry getCommandRegistry();
	
	public abstract void broadcastMessage(String msg);
	
	public abstract WorldManager getWorldManager();
	
}
