/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.entity;

/**
 * Project: Dimensions
 * 
 * File: EntityAnimation.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public enum EntityAnimation {
	
	HURT(2), DEAD(3), IRON_GOLEM_THROW(4), TAMING(6), TAMED(7), WOLF_SHAKING_WATER(8), EATING(9), SHEEP_EATING(10), IRON_GOLEM_HAND_ROSE(11), VILLAGER_MATING(12), ANGRY_VILLAGER(13), HAPPY_VILLAGER(14), WITCH_MAGIC(15), ZOMBIE_TO_VILLAGER(16), FIREWORK_EXPLODE(17), ANIMAL_LOVE(18);
	
	EntityAnimation(int status){
		this.status = (byte) status;
	}
	
	private byte status;
	
	public byte getStatus(){
		return status;
	}
}
