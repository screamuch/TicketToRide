package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

public class Game {
	ArrayList<Player> players;
	ArrayList<Route> routes;
	Queue<DestinationTicket> destinationTicketDeck;
	public boolean finalTurn = false;
	
	public Game(ArrayList<Player> players) {
		this.setup(players);
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
	
	public ArrayList<String> getPlayerRoutes(Player p) {
		ArrayList<String> routeStrings = new ArrayList<String>();
		for (Route r : routes) {
			if (r.getClaimedBy() == null)
				continue;
			if (r.getClaimedBy().getName().equals(p.getName()))
				routeStrings.add(r.toString());
		}
		return routeStrings;
	}
	
	public ArrayList<String> getPlayerDestinationTx(Player p) {
		ArrayList<String> destTxStrings = new ArrayList<String>();
		for (DestinationTicket tx : p.destinationTickets) {
			destTxStrings.add(tx.toString());
		}
		return destTxStrings;
	}
	
	public Player determineWinner() {
		int playerScore[] = new int[players.size()];
		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			for (DestinationTicket tx : p.destinationTickets) {
				playerCompletedDestinationTicket(tx, p);
			}
			playerScore[i] = p.getScore();
		}
		int winnerIndex = getMax(playerScore);
		Player winner = players.get(winnerIndex);
		return winner;
	}
	
	// taken from http://java.candidjava.com/tutorial/find-the-index-of-the-largest-number-in-an-array.htm
	private int getMax(int a[]) {
		int max = a[0];
		int index = 0;
	
		for (int i = 0; i < a.length; i++) 
		{
			if (max < a[i]) 
			{
				max = a[i];
				index = i;
			}
		}
		return index;
	}
	
	public boolean playerCompletedDestinationTicket(DestinationTicket ticket, Player p) {
		ArrayList<Route> playerRoutes = new ArrayList<Route>();
		for (Route r : routes) {
			// scroll thru all routes and see what are they connected with -> arraylist of arraylists of routes
			if (r.getClaimedBy() == null)
				continue;
			if (r.getClaimedBy().getName().equals(p.getName()))
				playerRoutes.add(r);
		}
		for (Route r : playerRoutes) {
			// if city1 and city2 has another connection to a player route, continue
			ArrayList<Route> city1Connections = getConnectedRoutes(r.getCity1());
			city1Connections.remove(r);
			ArrayList<Route> city2Connections = getConnectedRoutes(r.getCity2());
			city1Connections.remove(r);
			Collection<Route> c = playerRoutes;
			ArrayList<Route> chain = new ArrayList<Route>();
			if (city1Connections.contains(c) && city2Connections.contains(c))
				continue;
			else {
				getRouteChain(p, r, chain);
			}
			ArrayList<String> cityArr = new ArrayList<String>();
			for (Route rr : chain) {
				cityArr.add(rr.getCity1());
				cityArr.add(rr.getCity2());
			}
			if (cityArr.contains(ticket.getCity1()) && cityArr.contains(ticket.getCity2())) {
				p.addPoints(ticket.getPoints());
				return true;
			}
		}
		p.addPoints(ticket.getPoints()*-1);
		return false;
	}
	
	public void getRouteChain(Player p, Route r, ArrayList<Route> chain) {
		for (Route rr : getConnectedRoutes(r.getCity1())) {
			if (rr.getClaimedBy().getName().equals(p.getName()))
				continue;
			chain.add(rr);
			getRouteChain(p, rr, chain);
		}
		for (Route rr : getConnectedRoutes(r.getCity2())) {
			if (rr.getClaimedBy().getName().equals(p.getName()))
				continue;
			chain.add(rr);
			getRouteChain(p, rr, chain);
		}
	}

	// Returns an ArrayList of all unclaimed routes
	public ArrayList<Route> availableRoutes() {
		ArrayList<Route> unclaimed = new ArrayList<Route>();
		for (Route r : routes) {
			if (!r.claimed())
				unclaimed.add(r);
		}
		return unclaimed;
	}
	
	public void drawDestinationTx(Player p) {
		DestinationTicket retrievedTicket = destinationTicketDeck.poll();
		p.addDestinationTicket(retrievedTicket);
	}
        
    public void setFinalTurn(boolean bool)
    {
        finalTurn = bool; 
    }

}
