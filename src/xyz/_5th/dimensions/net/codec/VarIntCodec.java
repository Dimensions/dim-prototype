/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.CorruptedFrameException;

import java.util.List;

import xyz._5th.dimensions.net.PacketConstants;

/**
 * Project: Dimensions
 * 
 * File: VarIntCodec.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class VarIntCodec extends ByteToMessageCodec<ByteBuf> {
	
	private int length = -1;
	
	protected void encode(ChannelHandlerContext c, ByteBuf m, ByteBuf out) throws Exception{
		int bl = m.readableBytes();
		int hl = varIntSize(bl);
		out.ensureWritable(hl+bl);
		PacketConstants.writeVarInt(out, bl);
		out.writeBytes(m);
	}
	
	protected void decode(ChannelHandlerContext c, ByteBuf in, List<Object> out) throws Exception{
		in.markReaderIndex();
		if(length == -1){
			final byte[] b = new byte[3];
			for(int i = 0; i < b.length; i++){
				if(!in.isReadable()){
					in.resetReaderIndex();
					return;
				}
				b[i] = in.readByte();
				if(b[i] >0){
					length = PacketConstants.readVarInt(Unpooled.wrappedBuffer(b));
					in.markReaderIndex();
					if(in.readableBytes() < length){
						in.resetReaderIndex();
						return;
					}else{
						out.add(in.readBytes(length));
						length = -1;
						return;
					}
				}
			}
			throw new CorruptedFrameException("Length is wider than 21 bits");
		}else{
			if(in.readableBytes() < length){
				return;
			}else{
				out.add(in.readBytes(length));
				length = -1;
			}
		}
	}
	
	private static int varIntSize(int i){
		if((i&0xFFFFFF80) == 0) return 1;
		if((i&0xFFFFC000) == 0) return 2;
		if((i&0xFFE00000) == 0) return 3;
		if((i&0xF0000000) == 0) return 4;
		return 5;
	}
	
}
