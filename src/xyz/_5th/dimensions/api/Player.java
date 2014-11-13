/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api;

/**
 * Project: Dimensions
 * 
 * File: Player.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public interface Player extends Entity {
	
	public void sendMessage(String msg);
	
	public void sendJSONMessage(String json);
	
	public void setCompassSpawn(Position compassSpawn);
	
	public void kick();
	public void kick(String reason);
	
	public String getUsername();
	
	public String getUUID();
	
	public String getBase64EncodedSkin();
	
	public boolean isOnGround();
	
	public boolean isSprinting();
	
	public boolean isCrouching();
	
	public long getPing();
	
	public String getLocale();
	
	public String getHostname();
	
	public int getPort();
	
	public Position getCompassSpawnPosition();
}