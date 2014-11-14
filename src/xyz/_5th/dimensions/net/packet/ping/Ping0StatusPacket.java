package xyz._5th.dimensions.net.packet.ping;

import io.netty.buffer.ByteBuf;
import xyz._5th.dimensions.net.PacketConstants;
import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

public class Ping0StatusPacket extends Packet {

    public static final String BASE_DATA = "{\"version\":{\"name\":\"${version.name}\",\"protocol\":${version.protocol}},\"players\":{\"max\":${players.max},\"online\":${players.online},\"sample\":[{\"name\":\"Phasesaber\",\"id\":\"e63a1d61-adf1-4d47-b5f8-43efc5c84908\"}]},\"description\":{\"text\": \"${description.text}\"},\"favicon\":\"\"}";

    public String version;
    public int protocol;
    public int maxPlayers;
    public int onlineCount;
    public String description;

    public void read(ByteBuf in) throws Exception { }

    public void write(ByteBuf out) throws Exception {
        String preparedResponse = BASE_DATA.replace("${version.name}", version);
        preparedResponse = preparedResponse.replace("${version.protocol}", "" + protocol);
        preparedResponse = preparedResponse.replace("${players.max}", "" + maxPlayers);
        preparedResponse = preparedResponse.replace("${players.online}", "" + onlineCount);
        preparedResponse = preparedResponse.replace("${description.text}", description);
        PacketConstants.writeVarInt(out, 0);
        PacketConstants.writeString(out, preparedResponse);
    }

    public void handle(PacketManager handler) {
        handler.statusRequest(this);
    }
}
