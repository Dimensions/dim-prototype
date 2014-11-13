/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event.player;

import xyz._5th.dimensions.api.Player;
import xyz._5th.dimensions.api.event.Cancellable;
import xyz._5th.dimensions.api.event.Event;

/**
 * Project: Dimensions
 * 
 * File: PlayerChatEvent.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PlayerChatEvent extends Cancellable implements Event {
	
	private Player player;
	private String message;
	private String format = "[#player]: [#message]";
	
	public PlayerChatEvent(Player p, String m){
		this.player = p;
		this.message = m;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String m){
		this.message = m;
	}
	
	public void setFormat(String f){
		this.format = f;
	}
	
	public String getFormat(){
		return format;
	}
	
}
