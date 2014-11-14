/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net.packet.ping;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

/**
 * Project: Dimensions
 * 
 * File: Ping1PingPacket.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class Ping1PingPacket extends Packet {

	public long time;
	
	public void read(ByteBuf b) throws Exception{
		time = b.readLong();
	}
	
	public void write(ByteBuf b) throws Exception{
		PacketConstants.writeVarInt(b, 1);
		b.writeLong(time);
	}
	
	public void handle(PacketManager m){
		m.ping(this);
	}
}
