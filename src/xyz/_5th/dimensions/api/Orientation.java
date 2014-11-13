/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api;

/**
 * Project: Dimensions
 * 
 * File: Orientation.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public class Orientation {
	
	private float yaw;
	private float pitch;
	
	public Orientation(float y, float p){
		this.pitch = p%360;
		this.yaw = y%360;
	}
	
	public float Yaw(){
		return yaw;
	}
	
	public float Pitch(){
		return pitch;
	}
	
}
