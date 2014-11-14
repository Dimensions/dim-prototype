/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event.server;

import xyz._5th.dimensions.api.event.Event;

/**
 * Project: Dimensions
 * 
 * File: ServerPingEvent.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class ServerPingEvent implements Event {
	
	private String versionName;
	private int protocol;
	private int onlinePlayers;
	private int maxPlayers;
	private String motd;
	/**
	 * @param versionName
	 * @param protocol
	 * @param onlinePlayers
	 * @param maxPlayers
	 * @param motd
	 */
	public ServerPingEvent(String versionName, int protocol,
			int onlinePlayers, int maxPlayers, String motd) {
		super();
		this.versionName = versionName;
		this.protocol = protocol;
		this.onlinePlayers = onlinePlayers;
		this.maxPlayers = maxPlayers;
		this.motd = motd;
	}
	/**
	 * Getter for versionName.
	 * @return Gets versionName.
	 */
	public String getVersionName() {
		return versionName;
	}
	/**
	 * Setter for ${bare_field_name}.
	 * @param Set versionName to versionName.
	 */
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	/**
	 * Getter for protocol.
	 * @return Gets protocol.
	 */
	public int getProtocol() {
		return protocol;
	}
	/**
	 * Setter for ${bare_field_name}.
	 * @param Set protocol to protocol.
	 */
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	/**
	 * Getter for onlinePlayers.
	 * @return Gets onlinePlayers.
	 */
	public int getOnlinePlayers() {
		return onlinePlayers;
	}
	/**
	 * Setter for ${bare_field_name}.
	 * @param Set onlinePlayers to onlinePlayers.
	 */
	public void setOnlinePlayers(int onlinePlayers) {
		this.onlinePlayers = onlinePlayers;
	}
	/**
	 * Getter for maxPlayers.
	 * @return Gets maxPlayers.
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}
	/**
	 * Setter for ${bare_field_name}.
	 * @param Set maxPlayers to maxPlayers.
	 */
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	/**
	 * Getter for motd.
	 * @return Gets motd.
	 */
	public String getMotd() {
		return motd;
	}
	/**
	 * Setter for ${bare_field_name}.
	 * @param Set motd to motd.
	 */
	public void setMotd(String motd) {
		this.motd = motd;
	}
	
	
	
}
