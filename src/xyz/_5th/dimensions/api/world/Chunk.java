/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.world;

/**
 * Project: Dimensions
 * 
 * File: Chunk.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public interface Chunk {
	
	public World getWorld();
	
	public ChunkPosition getPosition();
	
	public int getX();
	
	public int getY();
	
	public Block getBlock(int x, int y, int z);
	
}
