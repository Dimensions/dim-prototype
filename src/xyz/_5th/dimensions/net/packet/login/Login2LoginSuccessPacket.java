package xyz._5th.dimensions.net.packet.login;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

public class Login2LoginSuccessPacket extends Packet {

    public String username;
    public String uuid;

    public void write(ByteBuf out) throws Exception{
        if (username == null || uuid == null){
            System.out.println("Login2LoginSuccessPacket: Player is null!");
            return;
        }
        PacketConstants.writeVarInt(out, 2);
        PacketConstants.writeString(out, uuid);
        PacketConstants.writeString(out, username);
    }

    public void handle(PacketManager handler){}
}
