/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.cmd;

import java.util.concurrent.ConcurrentHashMap;

import xyz._5th.dimensions.api.Dimensions;
import xyz._5th.dimensions.api.Player;

/**
 * Project: Dimensions
 * 
 * File: CommandRegistry.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public class CommandRegistry {
	
	private ConcurrentHashMap<String, CommandHandler<Player>> playerCommands = new ConcurrentHashMap<String, CommandHandler<Player>>();
	private ConcurrentHashMap<String, CommandHandler<Dimensions>> serverCommands = new ConcurrentHashMap<String, CommandHandler<Dimensions>>();
	
	public void registerPlayerCommand(CommandHandler<Player> c){
		if(c==null) throw new NullPointerException("Command is null");
		synchronized (playerCommands) {
			playerCommands.put(c.getCommandName().toLowerCase(), c);
		}
	}
	
	public void registerServerCommand(CommandHandler<Dimensions> c){
		if(c==null) throw new NullPointerException("Command is null");
		synchronized (serverCommands) {
			serverCommands.put(c.getCommandName().toLowerCase(), c);
		}
	}
	
	public boolean runPlayerCommand(Player p, String c, String[] args){
		CommandHandler<Player> cmd = playerCommands.get(c);
		if(cmd == null) return false;
		
		try{
			cmd.execute(p, args);
		}catch(Exception e){
			e.printStackTrace();
			try{
				cmd.getPlugin().handleException(e);
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean runServerCommand(Dimensions p, String c, String[] args){
		CommandHandler<Dimensions> cmd = serverCommands.get(c);
		if(cmd == null) return false;
		
		try{
			cmd.execute(p, args);
		}catch(Exception e){
			e.printStackTrace();
			try{
				cmd.getPlugin().handleException(e);
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return true;
	}
}
