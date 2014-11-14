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
import xyz._5th.dimensions.net.packet.login.Login0LoginStartPacket;
import xyz._5th.dimensions.net.packet.login.Login1EncryptionPacket;
import xyz._5th.dimensions.net.packet.ping.Ping0StatusPacket;
import xyz._5th.dimensions.net.packet.ping.Ping1PingPacket;
import xyz._5th.dimensions.net.packet.play.Play0KeepAlivePacket;
import xyz._5th.dimensions.net.packet.play.Play10AnimationPacket;
import xyz._5th.dimensions.net.packet.play.Play11EntityActionPacket;

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
	
	public void loginStart(Login0LoginStartPacket packet){
		
	}

	public void startEncryption(Login1EncryptionPacket packet) {
		
	}
	
	public void statusRequest(Ping0StatusPacket packet) {
			
	}

	public void ping(Ping1PingPacket packet) {
		
	}

	public void keepAlive(Play0KeepAlivePacket packet) {
		
	}

	public void playAnimation(Play10AnimationPacket packet) {
		
	}
	
	public void entityAction(Play11EntityActionPacket packet){
		
	}
}
