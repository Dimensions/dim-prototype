package xyz._5th.dimensions.net.packet.login;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

public class Login1EncryptionPacket extends Packet {

    public byte[] publicKey;
    public byte[] verifyToken;

    public void write(ByteBuf out) throws Exception{
        PacketConstants.writeVarInt(out, 1);
        PacketConstants.writeString(out, "");
        PacketConstants.writeVarInt(out, publicKey.length);
        out.writeBytes(publicKey);
        PacketConstants.writeVarInt(out, verifyToken.length);
        out.writeBytes(verifyToken);
    }

    public void read(ByteBuf in) throws Exception{
        publicKey = new byte[PacketConstants.readVarInt(in)];
        in.readBytes(publicKey);
        verifyToken = new byte[PacketConstants.readVarInt(in)];
        in.readBytes(verifyToken);
    }

    public void handle(PacketManager handler){
        handler.startEncryption(this);
    }
}
