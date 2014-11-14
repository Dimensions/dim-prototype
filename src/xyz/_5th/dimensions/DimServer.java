/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import xyz._5th.dimensions.api.Config;
import xyz._5th.dimensions.api.Dimensions;
import xyz._5th.dimensions.api.cmd.CommandRegistry;
import xyz._5th.dimensions.api.event.EventFactory;
import xyz._5th.dimensions.net.NetManager;
import xyz._5th.dimensions.net.packet.Packet;

/**
 * Project: Dimensions
 * 
 * File: DimServer.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class DimServer extends Dimensions {

	public static DimServer server = new DimServer();

	public static void main(String... strings) {
		Dimensions.setServer(server);
		server.init();
	}

	public Config config = new Config();
	public ConcurrentHashMap<String, DimPlayer> players = new ConcurrentHashMap<String, DimPlayer>();
	public DimWorldManager worldManager;
	public NetManager netManager = new NetManager(players);
	public KeepAliveThread aliveThread = new KeepAliveThread();
	public ChunkThread[] chunkThreads = new ChunkThreads[Runtime.getRuntime()
			.availableProcessors()];
	public EventFactory eventFactory;
	public PluginLoader pluginLoader;
	public ConsoleCommands consoleCommands = new ConsoleCommands();
	public CommandRegistry commandRegistry = new CommandRegistry();
	
	private void init(){
		config.load();
		netManager.start();
		aliveThread.start();
		for(int i = 0; i < chunkThreads.length; i++){
			chunkThreads[i] = new ChunkThread();
			chunkThreads[i].start();
		}
		eventFactory = new EventFactory();
		pluginLoader.init();
		consoleCommands.startHandling();
	}
	
	public void dispatchCommand(String cmd){
		consoleCommands.dispatchConsleCommand(cmd);
	}
	
	public void sendGlobalPacket(Packet p){
		Iterator<DimPlayer> i = players.values().iterator();
		while(i.hasNext()){
			i.next().channel.pipeline().writeAndFlush(p);
		}
	}
	
	public DimPlayer getPlayer(String name){
		return players.get(name);
	}
	
	public void stop(){
		consoleCommands.stopped = true;
		netManager.shutdown();
		aliveThread.interupt();
		try{
			aliveThread.join();
		}catch(Exception e){}
		for(ChunkThread c:chunkThreads){
			c.interupt();
		}
		pluginLoader.unload();
		eventFactory.destroyThreadPool();
		System.exit(0);
	}
	
	public void broadcastMessage(String message){
		PlayChatPacket p = new PlayChatPacket(DimPlayer.JSONChatMessageBase.replace("[#message]", message));
		sendGlobalPacket(p);
	}
	
	public CommandRegistry getCommandRegistry(){
		return commandRegistry;
	}
	
	public EventFactory getEventFactory(){
		return eventFactory;
	}
	
	public DimWorldManager getWorldManager(){
		return worldManager;
	}
}
