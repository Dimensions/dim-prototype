/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event;

/**
 * Project: Dimensions
 * 
 * File: Cancellable.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class Cancellable {
	
	private boolean cancelled;
	
	public boolean isCancelled(){
		return cancelled;
	}
	
	public void setCancelled(boolean b){
		this.cancelled = b;
	}
	
}
