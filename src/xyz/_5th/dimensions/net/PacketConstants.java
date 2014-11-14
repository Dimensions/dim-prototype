/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;

/**
 * Project: Dimensions
 * 
 * File: PacketConstants.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PacketConstants {

	public static int readVarInt(ByteBuf b) {
		int value = 0;
		int bytes = 0;
		byte in;
		while (true) {
			in = b.readByte();
			value |= (in & 0x7F) << (bytes++ * 7);
			if (bytes > 32)
				throw new IllegalArgumentException("VarInt is too long: "
						+ bytes);
			if ((in & 0x80) == 0x80)
				continue;
			break;
		}
		return value;
	}

	public static void writeVarInt(ByteBuf b, int value){
		byte in;
		while(true){
			in = (byte) (value & 0x7F);
			value >>>= 7;
			if(value != 0)
				in |= 0x80;
			b.writeByte(in);
			if(value != 0) continue;
			break;
		}
	}
	
	public static String readString(ByteBuf b){
		byte[] bytes = new byte[readVarInt(b)];
		b.readBytes(bytes);
		return new String(bytes, CharsetUtil.UTF_8);
	}
	
	public static void writeString(ByteBuf b, String s){
		byte[] bytes = s.getBytes(CharsetUtil.UTF_8);
		writeVarInt(b, bytes.length);
		b.writeBytes(bytes);
	}
}
