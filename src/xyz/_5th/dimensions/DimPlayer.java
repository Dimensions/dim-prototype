/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions;

import io.netty.channel.socket.SocketChannel;
import xyz._5th.dimensions.api.Orientation;
import xyz._5th.dimensions.api.Player;
import xyz._5th.dimensions.api.Position;
import xyz._5th.dimensions.api.entity.EntityAnimation;
import xyz._5th.dimensions.api.entity.EntityTickManager;
import xyz._5th.dimensions.api.entity.Rideable;
import xyz._5th.dimensions.api.world.World;
import xyz._5th.dimensions.net.codec.PacketCodec;
import xyz._5th.dimensions.net.packet.PacketManager;

/**
 * Project: Dimensions
 * 
 * File: DimPlayer.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class DimPlayer implements Player {
	
	public static final String JSONChatMessageBase = "{\"text\":\"[#message]\"";
	
	public SocketChannel channel;
	public PacketManager packetManager;
	public PacketCodec packetCodec;
	public String uuid;
	public String username;
	public String hostname;
	public int port;
	public String base64Skin;
	public Position compassSpawnPosition = new Position(0, 0, 0);
	public String locale = "en_US";
	public int viewDistance = 10;
	public byte chatFlags = 0;
	public boolean showingColors = true;
	public byte displaySkinParts;
	public long ping = 0;
	public boolean onGround = false;
	public boolean crouching = false;
	public boolean sprinting= false;
	
	public DimPlayer(SocketChannel channel){
		this.channel = channel;
		this.packetManager = new PacketManager(this);
		this.packetCodec = new PacketCodec(this.packetManager);
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#getPosition()
	 */
	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#getOrientation()
	 */
	@Override
	public Orientation getOrientation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#setOrientation(xyz._5th.dimensions.api.Orientation)
	 */
	@Override
	public void setOrientation(Orientation o) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#moveRelative(double, double, double)
	 */
	@Override
	public void moveRelative(double x, double y, double z) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#moveRelative(double, double, double, xyz._5th.dimensions.api.Orientation)
	 */
	@Override
	public void moveRelative(double x, double y, double z, Orientation o) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#teleport(xyz._5th.dimensions.api.Position)
	 */
	@Override
	public void teleport(Position p) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#teleport(xyz._5th.dimensions.api.Position, xyz._5th.dimensions.api.world.World)
	 */
	@Override
	public void teleport(Position p, World w) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#teleport(xyz._5th.dimensions.api.Position, xyz._5th.dimensions.api.Orientation)
	 */
	@Override
	public void teleport(Position p, Orientation o) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#teleport(xyz._5th.dimensions.api.Position, xyz._5th.dimensions.api.world.World, xyz._5th.dimensions.api.Orientation)
	 */
	@Override
	public void teleport(Position p, World w, Orientation o) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#mount(xyz._5th.dimensions.api.entity.Rideable)
	 */
	@Override
	public void mount(Rideable r) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#dismount()
	 */
	@Override
	public void dismount() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#sendStatus(xyz._5th.dimensions.api.entity.EntityAnimation)
	 */
	@Override
	public void sendStatus(EntityAnimation animation) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#isAlive()
	 */
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#getTickManager()
	 */
	@Override
	public EntityTickManager getTickManager() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.entity.Entity#setTickManager(xyz._5th.dimensions.api.entity.EntityTickManager)
	 */
	@Override
	public void setTickManager(EntityTickManager man) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#sendMessage(java.lang.String)
	 */
	@Override
	public void sendMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#sendJSONMessage(java.lang.String)
	 */
	@Override
	public void sendJSONMessage(String json) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#setCompassSpawn(xyz._5th.dimensions.api.Position)
	 */
	@Override
	public void setCompassSpawn(Position compassSpawn) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#kick()
	 */
	@Override
	public void kick() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#kick(java.lang.String)
	 */
	@Override
	public void kick(String reason) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getUsername()
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getUUID()
	 */
	@Override
	public String getUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getBase64EncodedSkin()
	 */
	@Override
	public String getBase64EncodedSkin() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#isOnGround()
	 */
	@Override
	public boolean isOnGround() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#isSprinting()
	 */
	@Override
	public boolean isSprinting() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#isCrouching()
	 */
	@Override
	public boolean isCrouching() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getPing()
	 */
	@Override
	public long getPing() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getLocale()
	 */
	@Override
	public String getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getHostname()
	 */
	@Override
	public String getHostname() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getPort()
	 */
	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see xyz._5th.dimensions.api.Player#getCompassSpawnPosition()
	 */
	@Override
	public Position getCompassSpawnPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
