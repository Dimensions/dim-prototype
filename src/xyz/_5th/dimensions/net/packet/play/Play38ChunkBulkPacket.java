/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net.packet.play;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

/**
 * Project: Dimensions
 * 
 * File: Play38ChunkBulkPacket.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class Play38ChunkBulkPacket extends Packet {

	public boolean skylightInfo;
	public int chunkColumCount;
	public int chunkXCord;
	public int chunkZCord;
	public short bitmask;
	public byte[] map;
	/**
	 * @param skylightInfo
	 * @param chunkColumCount
	 * @param chunkXCord
	 * @param chunkZCord
	 * @param bitmask
	 * @param map
	 */
	public Play38ChunkBulkPacket(boolean skylightInfo, int chunkColumCount,
			int chunkXCord, int chunkZCord, short bitmask, byte[] map) {
		super();
		this.skylightInfo = skylightInfo;
		this.chunkColumCount = chunkColumCount;
		this.chunkXCord = chunkXCord;
		this.chunkZCord = chunkZCord;
		this.bitmask = bitmask;
		this.map = map;
	}
	
	public void write(ByteBuf out) throws Exception{
		PacketConstants.writeVarInt(out, 38);
		out.writeBoolean(skylightInfo);
		PacketConstants.writeVarInt(out, chunkColumCount);
		out.writeInt(chunkXCord);
		out.writeInt(chunkZCord);
		out.writeShort(bitmask);
		PacketConstants.writeVarInt(out, map.length);
		out.writeBytes(map);
	}
	
	public void handle(PacketManager m){}

}
