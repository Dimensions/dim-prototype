/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net.packet.play;

import xyz._5th.dimensions.net.packet.Packet;
import xyz._5th.dimensions.net.packet.PacketManager;

/**
 * Project: Dimensions
 * 
 * File: Play10AnimationPacket.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class Play10AnimationPacket extends Packet {

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.net.packet.Packet#handle(xyz._5th.dimensions.net.packet.PacketManager)
	 */
	@Override
	public void handle(PacketManager handler) {
		handler.playAnimation(this);

	}

}
