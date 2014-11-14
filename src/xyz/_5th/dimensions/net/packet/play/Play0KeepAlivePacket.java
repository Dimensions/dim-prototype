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
 * File: Play0KeepAlivePacket.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class Play0KeepAlivePacket extends Packet {
	
	public int id;
	
	public Play0KeepAlivePacket(){}
	
	public Play0KeepAlivePacket(int id){
		this.id = id;
	}
	
	public void read(ByteBuf b) throws Exception{
		id = PacketConstants.readVarInt(b);
	}
	
	public void write(ByteBuf b) throws Exception{
		PacketConstants.writeVarInt(b, 0);
		PacketConstants.writeVarInt(b, id);
	}
	
	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.net.packet.Packet#handle(xyz._5th.dimensions.net.packet.PacketManager)
	 */
	@Override
	public void handle(PacketManager handler) {
		handler.keepAlive(this);
	}

}
