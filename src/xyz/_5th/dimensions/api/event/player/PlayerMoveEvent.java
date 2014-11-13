/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event.player;

import xyz._5th.dimensions.api.Orientation;
import xyz._5th.dimensions.api.Player;
import xyz._5th.dimensions.api.Position;
import xyz._5th.dimensions.api.event.Event;

/**
 * Project: Dimensions
 * 
 * File: PlayerMoveEvent.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class PlayerMoveEvent implements Event {
	
	private Player p;
	private Position oldP;
	private Orientation oldO;
	private Position newP;
	private Orientation newO;
	/**
	 * @param p
	 * @param oldP
	 * @param oldO
	 * @param newP
	 * @param newO
	 */
	public PlayerMoveEvent(Player p, Position oldP, Orientation oldO,
			Position newP, Orientation newO) {
		super();
		this.p = p;
		this.oldP = oldP;
		this.oldO = oldO;
		this.newP = newP;
		this.newO = newO;
	}
	/**
	 * Getter for p.
	 * @return Gets p.
	 */
	public Player getP() {
		return p;
	}
	/**
	 * Getter for oldP.
	 * @return Gets oldP.
	 */
	public Position getOldP() {
		return oldP;
	}
	/**
	 * Getter for oldO.
	 * @return Gets oldO.
	 */
	public Orientation getOldO() {
		return oldO;
	}
	/**
	 * Getter for newP.
	 * @return Gets newP.
	 */
	public Position getNewP() {
		return newP;
	}
	/**
	 * Getter for newO.
	 * @return Gets newO.
	 */
	public Orientation getNewO() {
		return newO;
	}
	
	
	
}
