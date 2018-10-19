package test;

import model.*;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class PlayerTest {
	ArrayList<Player> players;
	Queue<DestinationTicket> destinationTickets;
	Player P1 = new Player("P1", "Red", 5, 10);
	Player P2 = new Player("P2", "Blue", 12, 15);
	Player P3 = new Player("P3", "Green", 10, 20);
	Game G = new Game();
	
	@Test
	public void routePointWorth_lengthOfRoute_returnScoreAccordingly() {
		Route R1 = new Route("Vancouver", "Calgary", 4, false);
		assertTrue(Game.routePointWorth(R1) == 7);
		Route R2 = new Route("Portland", "Helena", 5, true);
		assertFalse(Game.routePointWorth(R2) == 11);
	}
	@Test
	public void initialSetup_checkForDestDeckRoutesAndPlayers_returnAccordingly() {
		players = new ArrayList<Player>();
		players.add(P1);
		players.add(P2);
		players.add(P3);
		assertTrue(players.get(2) == P3);
		destinationTickets = DestinationTicket.initDeck();
		assertFalse(destinationTickets.isEmpty());
	}
}
