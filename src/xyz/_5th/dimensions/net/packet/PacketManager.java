/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net.packet;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Random;

import xyz._5th.dimensions.DimPlayer;
import xyz._5th.dimensions.net.packet.handshake.Handshake0HandshakePacket;

/**
 * Project: Dimensions
 * 
 * File: PacketManager.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PacketManager {

	public static final String SessionUrl = "https://sessionserver.mojang.com/session/minecraft/hasJoined?username=${user}&server=${serv}";
	
	private static PublicKey publicKey;
	private static PrivateKey privateKey;
	private static Random rand = new Random();
	
	static{
		try{
			KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
			gen.initialize(1024);
			KeyPair k = gen.genKeyPair();
			publicKey = k.getPublic();
			privateKey = k.getPrivate();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public DimPlayer player;
	public int waitingPingId = -1;
	public long pingSentTimestamp = System.currentTimeMillis() + 10000;
	
	public PacketManager(DimPlayer p){
		this.player = p;
	}
	
	public void handshake(Handshake0HandshakePacket packet){
		
	}
}
