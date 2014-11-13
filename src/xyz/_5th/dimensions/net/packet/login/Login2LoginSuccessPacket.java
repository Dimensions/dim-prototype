import io.netty.buffer.ByteBuf;

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

    public void handle(PacketHandler handler){}
}
