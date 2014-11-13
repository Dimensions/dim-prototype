import io.netty.buffer.ByteBuf;

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

    public void handle(PacketHandler handler) {
        handler.handshake(this);
    }
}
