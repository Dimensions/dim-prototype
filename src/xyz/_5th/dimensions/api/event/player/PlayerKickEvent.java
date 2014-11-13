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
 * File: PlayerKickEvent.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PlayerKickEvent implements Event {
	
	private Player player;
	/**
	 * Getter for kickMessage.
	 * @return Gets kickMessage.
	 */
	public String getKickMessage() {
		return kickMessage;
	}
	/**
	 * Setter for ${bare_field_name}.
	 * @param Set kickMessage to kickMessage.
	 */
	public void setKickMessage(String kickMessage) {
		this.kickMessage = kickMessage;
	}
	/**
	 * Getter for player.
	 * @return Gets player.
	 */
	public Player getPlayer() {
		return player;
	}
	/**
	 * @param player
	 * @param kickMessage
	 */
	public PlayerKickEvent(Player player, String kickMessage) {
		super();
		this.player = player;
		this.kickMessage = kickMessage;
	}
	private String kickMessage;
	
	
}
