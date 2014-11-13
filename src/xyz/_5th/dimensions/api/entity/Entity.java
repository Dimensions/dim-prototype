/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.entity;

import xyz._5th.dimensions.api.Orientation;
import xyz._5th.dimensions.api.Position;

/**
 * Project: Dimensions
 * 
 * File: Entity.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public interface Entity {
	
	public int getId();
	
	public Position getPosition();
	
	public Orientation getOrientation();
	public void setOrientation(Orientation o);
	
	public void moveRelative(double x,double y,double z);
	public void moveRelative(double x, double y, double z, Orientation o);
	
	public void teleport(Position p);
	public void teleport(Position p, World w);
	public void teleport(Position p, Orientation o);
	public void teleport(Position p, World w, Orientation o);
	
	public void mount(Rideable r);
	public void dismount();
	
	
	
}
