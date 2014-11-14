/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.world;

import java.util.concurrent.ConcurrentHashMap;

import xyz._5th.dimensions.api.Position;
import xyz._5th.dimensions.api.constants.Difficulty;
import xyz._5th.dimensions.api.constants.Dimension;
import xyz._5th.dimensions.api.constants.LevelType;
import xyz._5th.dimensions.api.world.Block;
import xyz._5th.dimensions.api.world.Chunk;
import xyz._5th.dimensions.api.world.ChunkPosition;
import xyz._5th.dimensions.api.world.World;

/**
 * Project: Dimensions
 * 
 * File: DimWorld.java
 * 
 * @author Phase(Jadon Fowler) on Nov 14, 2014
 */
public class DimWorld implements World{
	
	String name;
	public ConcurrentHashMap<ChunkPosition, DimChunk> chunks = new ConcurrentHashMap<ChunkPosition, DimChunk>();
	public WorldThread thread = new WorldThread(this);
	public LevelType levelType;
	public Difficulty difficulty;
	public Dimension dimension;
	
	public DimWorld(String name){
		this.name = name;
		this.thread.start();
	}
	
	public LevelType getType(){
		return levelType;
	}
	
	public Dimension getDimension(){
		return dimension;
	}
	
	public Difficulty getDifficulty(){
		return difficulty;
	}
	
	public void setDifficulty(Difficulty d){
		this.difficulty = d;
	}
	
	public String getName(){
		return name;
	}
	
	public Chunk getChunkAt(int x, int z){
		return getChunkAt(new ChunkPosition(x,z));
	}
	
	public Chunk getChunkAt(ChunkPosition c){
		return chunks.get(c);
	}
	
	public Block getBlock(int x, int y, int z){
		int cx = x>>4;
		int cz = z>>4;
		return getChunkAt(cx,cz).getBlock(x-(cx<<4), y, z-(cz<<4));
	}
	
	public Block getBlock(double x, double y, double z){
		return getBlock(x<0?((int)x)-1:(int)x, y<0?((int)y)-1:(int)y, z<0?((int)z)-1:(int)z);
	}
	
	public Block getBlock(Position p){
		return getBlock(p.getX(), p.getY(), p.getZ());
	}
	
}
