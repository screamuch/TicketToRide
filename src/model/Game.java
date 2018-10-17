package model;

import java.util.ArrayList;
import java.util.Queue;

public class Game {
	ArrayList<Player> players;
	ArrayList<Route> routes;
	Queue<DestinationTicket> destinationTicketDeck;
	boolean finalTurn = false;

	public static void main(String[] args) {

	}

	// Adeeb, test this:
	/* TODO:
	 * Create players like this:
	 * player = new Player(...)
	 * and put them in the arraylist
	 */

	// Setting up the game - prepare card decks, set players up
	public void setup(ArrayList<Player> p) {
		destinationTicketDeck = DestinationTicket.initDeck();
		routes = Route.initRoutes();
		players = p;
	}

	// TODO:
	// Adeeb, test this, too
	/*
	 * compare routes point worth from this function with the table from rules
	 */
	public int routePointWorth(Route r) {
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
}
