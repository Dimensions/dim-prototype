package xyz._5th.dimensions.net.packet.handshake;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

public class Handshake0HandshakePacket extends Packet {

    public int protocolVersion;
    public String hostname;
    public int port;
    public int nextState;

    public void read(ByteBuf in) throws Exception {
        protocolVersion = PacketConstants.readVarInt(in);
        hostname = PacketConstants.readString(in);
        port = in.readUnsignedShort();
        nextState = PacketConstants.readVarInt(in);
    }
    
	public void handle(PacketManager handler){
		handler.handshake(this);
	}
}
