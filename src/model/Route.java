package model;

import java.util.ArrayList;

/*
 * This class describes a route between cities, used to generate a map
 * and keep track of which route belongs to what player
 */

public class Route {
	private static String city1;
	private static String city2;
	private static int length;
	private static boolean isDouble;
	// private Player claimedBy;

	/*
	 * List of game routes
	 */
	private static String c1[] = new String[]  {"Vancouver", "Seattle", "Vancouver", "Calgary", "Seattle", "Seattle",	"Portland",       "Salt Lake City", "Salt Lake City", "Portland",	   "Helena", "Salt Lake City", "Salt Lake City", "Denver",	 "San Francisco", "Los Angeles", "Los Angeles",	"Santa Fe", "Santa Fe", "Phoenix",	"Los Angeles"};
	private static String c2[] = new String[]  {"Calgary",	 "Calgary", "Seattle",	 "Helena",  "Helena",  "Portland",	"Salt Lake City", "Helena",         "Denver",		  "San Francisco", "Denver", "San Francisco",  "Las Vegas",		 "Santa Fe", "Los Angeles",	  "Las Vegas",	 "Phoenix",		"Phoenix",	"El Paso",	"El Paso",	"El Paso"};
	private static int len[] 	= new int[]	   {3, 4, 1, 4, 6, 1, 6, 3, 3, 5, 4, 5, 3, 2, 3, 2, 3, 3, 2, 3, 6};
	private static boolean dbl[] = new boolean[]{false, false, true, false, false, true, false, false, true, true, false, true, false, false, true, false, false, false, false, false, false};

	public Route(String c1, String c2, int l, boolean d) {
		this.city1 = c1;
		this.city2 = c2;
		this.length = l;
		this.isDouble = d;
	}

	// this method initializes all routes for the game and returns a list of them
	public static ArrayList<Route> initRoutes() {
		ArrayList<Route> list = new ArrayList<Route>();
		for (int i = 0; i < c1.length; i++) {
			list.add(new Route(c1[i], c2[i], len[i], dbl[i]));
		}
		return list;
	}

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
	public String toString() {
		String output = city1 + " <-> " + city2 + ", " + length;
		if (this.isDouble())
			output += ", Double-Route";
		return output;
	}

}
