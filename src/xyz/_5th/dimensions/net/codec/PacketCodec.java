/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.PacketState;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

/**
 * Project: Dimensions
 * 
 * File: PacketCodec.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PacketCodec {

	public PacketState state = PacketState.HANDSHAKE;
	public PacketManager manager;

	public PacketCodec(PacketManager man) {
		manager = man;
	}

	protected void encode(ChannelHandlerContext c, Packet p, ByteBuf b)
			throws Exception {
		if (p instanceof /* PACKET38CHUNKBULK */Object)
			System.out.println(p.toString());
		p.write(b);
	}

	protected void decode(ChannelHandlerContext c, ByteBuf in, List<Object> out)
			throws Exception {
		int ident = PacketConstants.readVarInt(in);
		Packet packet = null;
		if(state == PacketState.HANDSHAKE){
			switch(ident){
			case 0:
				/*PACKET 0 HANDSHAKE*/
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
