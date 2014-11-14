package xyz._5th.dimensions.net.packet.login;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

public class Login0LoginStartPacket extends Packet {

    public String name;

    public void handle(PacketManager handler) {
        handler.loginStart(this);
    }

    public void read(ByteBuf in) throws Exception {
        this.name = PacketConstants.readString(in);
    }
}
