/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.world;

import xyz._5th.dimensions.api.Position;
import xyz._5th.dimensions.api.constants.Difficulty;
import xyz._5th.dimensions.api.constants.Dimension;
import xyz._5th.dimensions.api.constants.LevelType;

/**
 * Project: Dimensions
 * 
 * File: World.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public interface World {
	
	public LevelType getType();
	
	public Dimension getDimension();
	
	public Difficulty getDifficulty();
	
	public void setDifficulty(Difficulty d);
	
	public String getName();
	
	public Chunk getChunkAt(ChunkPosition p);
	
	public Chunk getChunkAt(int x, int z);
	
	public Block getBlock(int x, int z, int y);
	
	public Block getBlock(double x, double y, double z);
	
	public Block getBlock(Position p);
	
}
