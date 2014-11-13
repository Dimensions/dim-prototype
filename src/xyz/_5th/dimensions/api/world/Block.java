/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.world;

import xyz._5th.dimensions.api.Position;

/**
 * Project: Dimensions
 * 
 * File: Block.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public interface Block {
	
	public World getWorld();
	
	public Position getPosition();
	
	public String getType();
	
	public byte getID();
	
}
