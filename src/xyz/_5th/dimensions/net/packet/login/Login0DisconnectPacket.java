import io.netty.buffer.ByteBuf;

public class Login0DisconnectPacket extends Packet {

    public String message;

    public Login0DisconnectPacket(String s) {
        this.message = s;
    }

    public void write(ByteBuf out) throws Exception {
        PacketConstants.writeVarInt(out, 0);
        PacketConstants.writeString(out, "{\"text\":\"" + message + "\"}");
    }

    public void handle(PacketHandler handler) {}
}
