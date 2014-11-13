import io.netty.buffer.ByteBuf;

public class Login0LoginStartPacket extends Packet {

    public String name;

    public void handle(PacketHandler handler) {
        handler.loginStart(this);
    }

    public void read(ByteBuf in) throws Exception {
        this.name = PacketConstants.readString(in);
    }
}
