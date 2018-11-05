package model;

import java.util.ArrayList;
import java.util.Queue;

public class Game {
	ArrayList<Player> players;
	ArrayList<Route> routes;
	Queue<DestinationTicket> destinationTicketDeck;
	public boolean finalTurn = false;

	public static void main(String[] args) {

	}

	// Setting up the game - prepare card decks, set players up
	public void setup(ArrayList<Player> p) {
		destinationTicketDeck = DestinationTicket.initDeck();
		routes = Route.initRoutes();
		players = p;
	}

	/*
	 * compare routes point worth from this function with the table from rules
	 */ 
	public static int routePointWorth(Route r) {
		switch (r.getLength()) {
		case 1: return 1;
		case 2: return 2;
		case 3: return 4;
		case 4: return 7;
		case 5: return 10;
		case 6: return 15;
		}
		return -1;
	}

	// This method tests if the player has 2 or less trains left, which indicates end of game
	public static boolean outOfTrains(Player p) {
		if (p.getTrainCount() < 3)
			return true;
		return false;
	}

	/*
	 * THESE TWO SHOULD BE MOVED TO ROUTE
	 */

	// Checks if two cities are connected
	public boolean citiesConnected(String city1, String city2) {
		for (Route r : routes) {
			if ((r.getCity1().equals(city1) && r.getCity2().equals(city2)) ||
				(r.getCity1().equals(city2) && r.getCity2().equals(city1))) {
				return true;
			}
		}
		return false;
	}

	// Gets an arraylist of cities connected to the argument city
	public ArrayList<Route> getConnectedRoutes(String city) {
		ArrayList<Route> connected = new ArrayList<Route>();
		for (Route r : routes) {
			if (citiesConnected(city, r.getCity1()) || citiesConnected(city, r.getCity2())) {
				connected.add(r);
			}
		}
		return connected;
	}

	// Returns an ArrayList of all unclaimed routes
	public ArrayList<String> availableRoutes() {
		ArrayList<String> unclaimed = new ArrayList<String>();
		for (Route r : routes) {
			if (!r.claimed())
				unclaimed.add(r.toString());
		}
		return unclaimed;
	}
        
        public void setFinalTurn(boolean bool)
        {
            finalTurn = bool; 
        }

}
