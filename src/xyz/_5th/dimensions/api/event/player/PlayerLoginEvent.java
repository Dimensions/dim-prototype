/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event.player;

import xyz._5th.dimensions.api.Player;
import xyz._5th.dimensions.api.event.Event;

/**
 * Project: Dimensions
 * 
 * File: PlayerLoginEvent.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PlayerLoginEvent implements Event {

	private Player player;
	private String joinMessage;
	
	public PlayerLoginEvent(Player player){
		this.player = player;
		this.joinMessage = player.getUsername() + " joined the server.";
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setJoinMessage(String joinMessage){
		this.joinMessage = joinMessage;
	}
	
	public String getJoinMessage(){
		return joinMessage;
	}
	
}
