/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.cmd;

import xyz._5th.dimensions.api.plugin.Plugin;

/**
 * Project: Dimensions
 * 
 * File: CommandHandler.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public abstract class CommandHandler<I> {
	
	private String cmdName;
	
	private Plugin plugin;
	
	protected CommandHandler(String cn, Plugin p){
		if(cn == null){
			throw new NullPointerException("Command name is null");
		}
		if(p == null){
			throw new NullPointerException("Plugin is null");
		}
		cmdName = cn;
		plugin = p;
	}
	
	public abstract void execute(I sender, String[] args);
	
	public String getCommandName(){
		return cmdName;
	}
	
	public Plugin getPlugin(){
		return plugin;
	}
	
}
