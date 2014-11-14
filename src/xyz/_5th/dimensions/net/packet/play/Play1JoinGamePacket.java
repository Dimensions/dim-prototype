/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net.packet.play;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.api.constants.Difficulty;
import xyz._5th.dimensions.api.constants.Dimension;
import xyz._5th.dimensions.api.constants.Gamemode;
import xyz._5th.dimensions.api.constants.LevelType;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

/**
 * Project: Dimensions
 * 
 * File: Play1JoinGamePacket.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class Play1JoinGamePacket extends Packet {

	public int id;
	public byte gamemode;
	public byte dimension;
	public byte difficulty;
	public byte maxplayers;
	public String leveltype;
	public boolean reducedebuginfo;

	public Play1JoinGamePacket(int id, Gamemode gm, Dimension dm,
			Difficulty df, int maxplayers, LevelType lt, boolean debug) {
		this.id = id;
		switch (gm) {
		case SURVIVAL:
			this.gamemode = 0;
			break;
		case CREATIVE:
			this.gamemode = 1;
			break;
		case ADVENTURE:
			this.gamemode = 2;
			break;
		case SPECTATOR:
			this.gamemode = 3;
			break;
		}
		switch(dm){
		case NETHER:
			this.dimension = -1;break;
		case OVERWORLD:
			this.dimension = 0;break;
		case END:
			this.dimension = 1;break;
		}
		switch(df){
		case PEACEFUL:
			this.difficulty = 0;break;
		case EASY:
			this.difficulty = 1;break;
		case NORMAL:
			this.difficulty = 2;break;
		case HARD:
			this.difficulty = 3;break;
		}
		this.maxplayers = (byte)maxplayers;
		this.leveltype = leveltype.toString();
		this.reducedebuginfo = debug;
	}
	
	public void write(ByteBuf b) throws Exception {
		PacketConstants.writeVarInt(b, 1);
		b.writeInt(id);
		b.writeByte(gamemode);
		b.writeByte(dimension);
		b.writeByte(difficulty);
		b.writeByte(maxplayers);
		PacketConstants.writeString(b, leveltype);
		b.writeBoolean(reducedebuginfo);
	}
	
	public void handle(PacketManager handler){}
	
}
