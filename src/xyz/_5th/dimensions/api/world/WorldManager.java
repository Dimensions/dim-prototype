/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.world;

/**
 * Project: Dimensions
 * 
 * File: WorldManager.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public interface WorldManager {
	
	public World getDefaultWorld();
	
	public World getExistingWorld(String name);

	public World createWorld(String name);
}
