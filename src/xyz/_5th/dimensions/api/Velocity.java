/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api;

/**
 * Project: Dimensions
 * 
 * File: Velocity.java
 * 
 * @author Phase(Jadon Fowler) on Nov 12, 2014
 */
public class Velocity {

	public static Velocity fromLong(long l) {
		Velocity p = new Velocity();
		p.x = ((int) (l >> 38)) / 32;
		p.y = ((int) (l << 26 >> 52)) / 32;
		p.z = ((int) (l << 38 >> 38)) / 32;
		return p;
	}

	private static long toLong(Velocity p) {
		return (((int) p.x * 32) & 0x3FFFFFF) << 38
				| (((int) p.y * 32) & 0xFFF) << 26
				| (((int) p.z * 32) & 0x3FFFFFF);
	}

	private double x = 0;
	private double y = 0;
	private double z = 0;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Velocity)) {
			return false;
		}
		Velocity p = (Velocity) o;
		return p.x == x && p.z == z && p.y == y;
	}

	public int hashCode() {
		return ("" + x + ":" + y + ":" + z).hashCode();
	}
}
