/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.world;

import xyz._5th.dimensions.api.Position;
import xyz._5th.dimensions.api.world.Block;
import xyz._5th.dimensions.api.world.Chunk;
import xyz._5th.dimensions.api.world.World;

/**
 * Project: Dimensions
 * 
 * File: DimBlock.java
 * 
 * @author Phase(Jadon Fowler) on Nov 14, 2014
 */
public class DimBlock implements Block {
	
	public Chunk chunk;
	public Position position;
	
	public DimBlock(Chunk c, int x, int y, int z){
		this.chunk = c;
		this.position = new Position(x,y,z);
	}
	
	public World getWorld(){
		return chunk.getWorld();
	}
	
	public Position getPosition(){
		return position;
	}
	
	//TODO: Replace with a BlockType
	public String getType(){
		return "GRASS_BLOCK";
	}
	
	public byte getID(){
		return 2;
	}
	
}
