/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;

/**
 * Project: Dimensions
 * 
 * File: Config.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public class Config {
	
	private String generateSettings = "";
	
	private String levelName = "world";
	
	private boolean onlineMode = true;
	
	private boolean enableQuery = false;
	
	private boolean allowFlight = false;
	
	private boolean anouncePlayerAchievments = false;
	
	private int serverPort = 25565;
	
	private boolean forceGamemode = false;
	
	private String serverIp = "0.0.0.0";
	
	private boolean whiteList = false;
	
	private boolean pvp = true;
	
	private boolean enableCommandBlocks = false;
	
	private String serverName = "Dimensions Server";
	
	private int playerIdleTimeout = 0;
	
	private int gamemode = 0;
	
	private int maxPlayers = 60;
	
	private int viewDistance = 10;
	
	private int spawnProtection = 0;
	
	private boolean verifyTokens = true;
	
	private String motd = "My Dimensional Minecraft Server";
	
	private int pluginEventThreads = 16;
	
	public void load(){
		try{
			BufferedReader b = new BufferedReader(new FileReader(new File("server.properties")));
			String in;
			while((in = b.readLine())!= null){
				in = in.trim();
				if(in.startsWith("#")) continue;
				String[] pair = in.split("=");
				if(pair.length != 2){
					System.out.println("UNKNOWN CONFIG OPTION: " + in);
					continue;
				}
				char[] key = pair[0].toCharArray();
				for(int i = 0; i < key.length; i++){
					if(key[i] == '-')
						key[++i] = Character.toUpperCase(key[i]);
				}
				StringBuilder s = new StringBuilder();
				s.append(key);
				String finalKey = s.toString().replaceAll("-", "");
				Field field = getClass().getDeclaredField(finalKey);
				if(field == null){
					System.out.println("UNKNOWN CONFIG OPTION: " + finalKey);
					continue;
				}
				if(field.getType() == int.class){
					field.set(this, Integer.parseInt(pair[1]));
				}else if(field.getType() == boolean.class){
					field.set(this, Boolean.parseBoolean(pair[1]));
				}else if(field.getType() ==  String.class){
					field.set(this, pair[1]);
				}
			}
			b.close();
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Coudln't read configuration file, generating: " + ex.getMessage());
			saveDefaultConfig();
		}
	}
	
	private void saveDefaultConfig(){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("server.properties")));
			Field[] fields = getClass().getDeclaredFields();
			for(Field f : fields)
				bw.write(f.getName() + "=" + f.get(this) + "\r\n");
			bw.flush();
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Getter for generateSettings.
	 * @return Gets generateSettings.
	 */
	public String getGenerateSettings() {
		return generateSettings;
	}

	/**
	 * Getter for levelName.
	 * @return Gets levelName.
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * Getter for onlineMode.
	 * @return Gets onlineMode.
	 */
	public boolean isOnlineMode() {
		return onlineMode;
	}

	/**
	 * Getter for enableQuery.
	 * @return Gets enableQuery.
	 */
	public boolean isEnableQuery() {
		return enableQuery;
	}

	/**
	 * Getter for allowFlight.
	 * @return Gets allowFlight.
	 */
	public boolean isAllowFlight() {
		return allowFlight;
	}

	/**
	 * Getter for anouncePlayerAchievments.
	 * @return Gets anouncePlayerAchievments.
	 */
	public boolean shouldAnouncePlayerAchievments() {
		return anouncePlayerAchievments;
	}

	/**
	 * Getter for serverPort.
	 * @return Gets serverPort.
	 */
	public int getServerPort() {
		return serverPort;
	}

	/**
	 * Getter for forceGamemode.
	 * @return Gets forceGamemode.
	 */
	public boolean isForceGamemode() {
		return forceGamemode;
	}

	/**
	 * Getter for serverIp.
	 * @return Gets serverIp.
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * Getter for whiteList.
	 * @return Gets whiteList.
	 */
	public boolean isWhiteList() {
		return whiteList;
	}

	/**
	 * Getter for pvp.
	 * @return Gets pvp.
	 */
	public boolean isPvp() {
		return pvp;
	}

	/**
	 * Getter for enableCommandBlocks.
	 * @return Gets enableCommandBlocks.
	 */
	public boolean isEnableCommandBlocks() {
		return enableCommandBlocks;
	}

	/**
	 * Getter for serverName.
	 * @return Gets serverName.
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * Getter for playerIdleTimeout.
	 * @return Gets playerIdleTimeout.
	 */
	public int getPlayerIdleTimeout() {
		return playerIdleTimeout;
	}

	/**
	 * Getter for gamemode.
	 * @return Gets gamemode.
	 */
	public int getGamemode() {
		return gamemode;
	}

	/**
	 * Getter for maxPlayers.
	 * @return Gets maxPlayers.
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
	 * Getter for viewDistance.
	 * @return Gets viewDistance.
	 */
	public int getViewDistance() {
		return viewDistance;
	}

	/**
	 * Getter for spawnProtection.
	 * @return Gets spawnProtection.
	 */
	public int getSpawnProtection() {
		return spawnProtection;
	}

	/**
	 * Getter for verifyTokens.
	 * @return Gets verifyTokens.
	 */
	public boolean isVerifyTokens() {
		return verifyTokens;
	}

	/**
	 * Getter for motd.
	 * @return Gets motd.
	 */
	public String getMotd() {
		return motd;
	}

	/**
	 * Getter for pluginEventThreads.
	 * @return Gets pluginEventThreads.
	 */
	public int getPluginEventThreads() {
		return pluginEventThreads;
	}
	
	
	
}