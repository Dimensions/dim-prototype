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
 * File: PlayChatPacket.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PlayChatPacket extends Packet {
	
	public String message;
	public byte position = 0;
	
	public PlayChatPacket(){}
	
	public PlayChatPacket(String s){
		message = s;
	}
	
	public void read(ByteBuf b) throws Exception{
		message = PacketConstants.readString(b);
	}
	
	public void write(ByteBuf b) throws Exception{
		PacketConstants.writeVarInt(b, 2);
		PacketConstants.writeString(b, message);
		b.writeByte(position);
	}
	
	public void handle(PacketManager m){
		m.chat(this);
	}
	
}
