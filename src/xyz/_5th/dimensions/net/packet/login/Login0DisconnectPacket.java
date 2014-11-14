package xyz._5th.dimensions.net.packet.login;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

public class Login0DisconnectPacket extends Packet {

    public String message;

    public Login0DisconnectPacket(String s) {
        this.message = s;
    }

    public void write(ByteBuf out) throws Exception {
        PacketConstants.writeVarInt(out, 0);
        PacketConstants.writeString(out, "{\"text\":\"" + message + "\"}");
    }

    public void handle(PacketManager handler){}
}
