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
 * File: Play11EntityActionPacket.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class Play11EntityActionPacket extends Packet {

	public int entityId;
	public byte actionId;
	public int jumpBoost;
	
	public void read(ByteBuf b) throws Exception{
		entityId = PacketConstants.readVarInt(b);
		actionId = b.readByte();
		jumpBoost = PacketConstants.readVarInt(b);
	}
	
	@Override
	public void handle(PacketManager handler) {
		handler.entityAction(this);

	}

}
