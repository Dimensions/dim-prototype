/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.world;

import java.util.Set;

import xyz._5th.dimensions.api.Position;
import xyz._5th.dimensions.api.world.Block;
import xyz._5th.dimensions.api.world.Chunk;
import xyz._5th.dimensions.api.world.ChunkPosition;
import xyz._5th.dimensions.api.world.World;

/**
 * Project: Dimensions
 * 
 * File: DimChunk.java
 * 
 * @author Phase(Jadon Fowler) on Nov 14, 2014
 */
public class DimChunk implements Chunk{
	
	public static final int WIDTH = 16, DEPTH = 16, HEIGHT = 256;
	public static final int SIZE = WIDTH * DEPTH * HEIGHT;
	
	public World world;
	public byte[] blockIDs, blockData, skyLight, blockLight;
	public ChunkPosition position;
	public Set<DimEntity> entities;
	
	public DimChunk(ChunkPosition position, byte[] content){
		for(int i = 0; i < content.length; i++) content[i] = 2;
		this.position = position;
		this.blockIDs = content;
		this.blockData = new byte[SIZE];
		this.skyLight = new byte[SIZE];
		this.blockLight = new byte[SIZE];
	}
	
	public int getDataPosition(int x, int y, int z){
		return y * (WIDTH * HEIGHT) + (z * WIDTH) + x;
	}
	
	private Position getPositionData(int data){
		int rm = data % (WIDTH*HEIGHT);
		int y = (data - rm) / (WIDTH*HEIGHT);
		int x = rm % WIDTH;
		int z = (rm - x) / WIDTH;
		return new Position(x, y, z);
	}
	
	public World getWorld(){
		return world;
	}
	
	public ChunkPosition getPosition(){
		return position;
	}
	
	public int getX(){
		return position.getX();
	}
	
	public int getZ(){
		return position.getZ();
	}
	
	public Block getBlock(int x, int y, int z){
		//TODO: Fin
		return null;
	}
	
	public byte[] getChunkData(){
		byte[] data = new byte[(((4096 * 5 / 2) + 2048) * 16) + 256];
		int pos = 0;
		
		for(int i = 0; i < blockIDs.length; i++){
			byte type = 2 << 4; //blockIDs[i];
			type = (byte)((type&0xFFF0) | blockData[i]);
			data[pos++] = (byte)(type&0xFF);
			data[pos++] = (byte)(type >> 8);
		}
		
		System.arraycopy(blockIDs, 0, data, 0, blockIDs.length);
		
		for(int i = 0; i < blockData.length; i+=2){
			byte meta1 = blockData[i];
			byte meta2 = blockData[i+1];
			data[pos++] = (byte) ((meta2 << 4) | meta1);
		}
		
		for(int i = 0; i < skyLight.length; i+=2){
			byte sl1 = 15; //skyLight[i];
			byte sl2 = 15;// skyLight[i+1];
			data[pos++] = (byte)((sl2 << 4) | sl1);
		}
		
		for(int i = 0; i < blockLight.length; i+=2){
			byte l1 = 15; //blockLight[i];
			byte l2 = 15;// blockLight[i+1];
			data[pos++] = (byte)((l2 << 4) | l1);
		}
		
		//Biome
		for(int i = 0; i < 256; i++)
			data[pos++] = 4; //TODO: Biome Data 4=Forest
		
		if(pos != data.length)
			throw new IllegalStateException("Illegal Position: " + pos + " / " + data.length);
		
		return data;
	}
}
