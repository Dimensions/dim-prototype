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
import xyz._5th.dimensions.net.packet.handshake.Handshake0HandshakePacket;
import xyz._5th.dimensions.net.packet.login.Login0LoginStartPacket;
import xyz._5th.dimensions.net.packet.login.Login1EncryptionPacket;
import xyz._5th.dimensions.net.packet.ping.Ping0StatusPacket;
import xyz._5th.dimensions.net.packet.ping.Ping1PingPacket;
import xyz._5th.dimensions.net.packet.play.Play0KeepAlivePacket;
import xyz._5th.dimensions.net.packet.play.Play10AnimationPacket;
import xyz._5th.dimensions.net.packet.play.Play11EntityActionPacket;
import xyz._5th.dimensions.net.packet.play.Play38ChunkBulkPacket;
import xyz._5th.dimensions.net.packet.play.PlayChatPacket;

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
		if (p instanceof Play38ChunkBulkPacket)
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
				packet = new Handshake0HandshakePacket();break;
			default:
				throw new Exception("Unknown Packet ID durring Handshake: " + ident);
			}
		}else if(state == PacketState.PING){
			switch(ident){
			case 0:
				packet = new Ping0StatusPacket();break;
			case 1:
				packet = new Ping1PingPacket();break;
			default:
				throw new Exception("Unknown Packet ID durring Ping: " + ident);
			}
		}else if(state == PacketState.LOGIN){
			switch(ident){
			case 0:
				packet = new Login0LoginStartPacket();break;
			case 1:
				packet = new Login1EncryptionPacket();break;
			default:
				throw new Exception("Unknown Packet ID durring Login: " + ident);
			}
			
		}else if(state == PacketState.PLAY){
			switch(ident){
			case 0:
				packet = new Play0KeepAlivePacket();break;
			case 1:
				packet = new PlayChatPacket();break;
			case 2:
				/*packet = new Play2UseEntityPacket();*/break;
			case 3:
				/*packet = new Play3GroundStatusPacket();*/break;
			case 4:
				/*packet = new Play4PositionPacket();*/break;
			case 5:
				/*packet = new Play5PlayerLookPacket();*/break;
			case 6:
				/*packet = new Play6PlayerPosLookPacket();*/break;
			case 7:
				/*packet = new Play7DigBlockPacket();*/break;
			case 8:
				/*packet = new Play8PlaceBlockPacket();*/break;
			case 9:
				/*packet = new Play9HeldItemPacket();*/break;
			case 10:
				new Play10AnimationPacket();break;
			case 11:
				new Play11EntityActionPacket();break;
			case 21:
				/*packet = new Play21ClientSettingsPacket();*/break;
			case 23:
				/*packet = new Play23PluginMessagePacket();*/break;
			
			default:
				manager.player.kick("Unknown Packet ID durring Play: " + ident);
				throw new Exception("Unknown Packet ID durring Play: " + ident);
			}
		}
		packet.read(in);
		if(in.readableBytes() > 0){
			manager.player.kick("You sent too many bytes: " + in.readableBytes());
			return;
		}
		packet.handle(manager);
	}

	
	public void channelInactive(ChannelHandlerContext c){
		manager.player.playerDisconnected();
	}
	
	public void exceptionCaught(ChannelHandlerContext c, Throwable cause){
		c.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
