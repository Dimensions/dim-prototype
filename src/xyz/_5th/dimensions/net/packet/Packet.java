package xyz._5th.dimensions.net.packet;

import io.netty.buffer.ByteBuf;

import java.lang.reflect.Field;

public abstract class Packet {

    public void read(ByteBuf buf) throws Exception {}

    public void write(ByteBuf out) throws Exception {}

    public abstract void handle(PacketManager handler);

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getClass().getCanonicalName() + "[ ");
        try {
            Field[] fields = this.getClass().getFields();
            for (Field f : fields) 
                s.append(f.getName() + "=" + f.get(this) + ", ");
            s.setLength(s.length() - 2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        s.append(" ]");
        return s.toString();
    }
}
