package model;

/*
 * This class describes a route between cities, used to generate a map
 * and keep track of which route belongs to what player
 */

public class Route {
	private static String city1;
	private static String city2;
	private static int length;
	private static boolean isDouble;
	//private Player claimedBy;

	public final String getCity1() {
		return city1;
	}
	public final String getCity2() {
		return city2;
	}
	public final int getLength() {
		return length;
	}
	public final boolean isDouble() {
		return isDouble;
	}

}
