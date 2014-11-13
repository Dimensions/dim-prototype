package xyz._5th.dimensions.net.packet.handshake;

import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketHandler;
import xyz._5th.dimensions.net.packet.PacketManager;
import io.netty.buffer.ByteBuf;

public class Handshake0HandshakePacket extends Packet {

    public int protocolVersion;
    public String hostname;
    public int port;
    public int nextState;

    public void read(ByteBuf in) throws Exception {
        protocolVersion = PacketManager.readVarInt(in);
        hostname = PacketManager.readString(in);
        port = in.readUnsignedShort();
        nextState = PacketManager.readVarInt(in);
    }

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.net.packet.Packet#handle(xyz._5th.dimensions.net.packet.PacketHandler)
	 */
	@Override
	public void handle(PacketHandler handler) {
		// TODO Auto-generated method stub
		
	}
}
