package test;

import model.*;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {
	ArrayList<Player> players;
	Player P1 = new Player("P1", "Red", 5, 10);
	Player P2 = new Player("P", "Blue", 12, 15);
	Player P3 = new Player("P", "Green", 10, 20);
	Game G = new Game();
	
	@Test
	public void routePointWorth_lengthOfRoute_returnScoreAccordingly() {
		Route R1 = new Route("Vancouver", "Calgary", 3, false);
		assertTrue(G.routePointWorth(R1) == 4);
		Route R2 = new Route("Portland", "Helena", 4, true);
		assertFalse(G.routePointWorth(R2) == 8);
	}
}
