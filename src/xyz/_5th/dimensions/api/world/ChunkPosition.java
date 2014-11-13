/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.world;

/**
 * Project: Dimensions
 * 
 * File: ChunkPosition.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class ChunkPosition {
	
	private int x;
	private int z;
	
	public ChunkPosition(int x, int z){
		this.x = x;
		this.z = x;
	}
	
	public int hashCode(){
		return (x + ":" + z).hashCode();
	}
	
	public boolean equals(Object o){
		if(o instanceof ChunkPosition){
			ChunkPosition p = (ChunkPosition) o;
			return p.x == this.x && p.z == this.z;
		}
		return false;
	}
	
	public int getX(){
		return x;
	}
	
	public int getZ(){
		return z;
	}
	
}
