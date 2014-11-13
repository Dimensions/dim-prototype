/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.constants;

/**
 * Project: Dimensions
 * 
 * File: LevelType.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public enum LevelType {
	
	DEFAULT("default"),
	FLAT("flat"),
	LARGE_BIOMES("largeBiomes"),
	AMPLIFIED("amplified"),
	DEFAULT_1_1("default_1_1");
	
	private String name;
	
	private LevelType(String n){
		name = n;
	}
	
	public String toString(){
		return name;
	}
}
