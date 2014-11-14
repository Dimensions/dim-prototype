/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.util.concurrent.ConcurrentHashMap;

import xyz._5th.dimensions.DimPlayer;
import xyz._5th.dimensions.net.codec.VarIntCodec;

/**
 * Project: Dimensions
 * 
 * File: NetManager.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class NetManager {
	
	public ConcurrentHashMap<String, DimPlayer> players;
	public EventLoopGroup bossGroup = new NioEventLoopGroup();
	public EventLoopGroup workGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());
	public ChannelFuture future;
	
	public NetManager(ConcurrentHashMap<String, DimPlayer> players){
		this.players = players;
	}
	
	public void start(){
		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new ChannelInitializer<SocketChannel>(){
				protected void initChannel(SocketChannel ch) throws Exception {
					DimPlayer p = new DimPlayer(ch);
					ch.pipeline().addLast(new ReadTimeoutHandler(ch));
					ch.pipeline().addLast(new VarIntCodec());
					ch.pipeline().addLast(p.packetCodec);
				}
			});
			b.option(ChannelOption.SO_BACKLOG, 16);
			b.childOption(ChannelOption.SO_KEEPALIVE, true);
			future = b.bind(25565);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void shutdown(){
		System.out.println(future.channel().close().syncUninterruptibly().isSuccess() ? "Network Manager shutdown" : "ERROR: Network Manager couldn't shutdown");
	}
}
