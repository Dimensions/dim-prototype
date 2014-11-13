/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event.player;

import xyz._5th.dimensions.api.event.Event;

/**
 * Project: Dimensions
 * 
 * File: PlayerLoginAttemptEvent.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PlayerLoginAttemptEvent implements Event {
	
	private String username;
	private String hostname;
	private short port;
	private String disconnectMessage = "Oh noesssss";
	/**
	 * @param username
	 * @param hostname
	 * @param port
	 * @param disconnectMessage
	 */
	public PlayerLoginAttemptEvent(String username, String hostname,
			short port) {
		super();
		this.username = username;
		this.hostname = hostname;
		this.port = port;
	}
	
	public String getDisconnectMessage(){
		return disconnectMessage;
	}
	
	public void setDisconnectMessage(String m){
		this.disconnectMessage = m;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getHostname(){
		return hostname;
	}
	
	public short getPort(){
		return port;
	}
	
}
