/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * jLabel1.setIcon(new javax.swing.ImageIcon("javaScreenShot2018-11-04at9.57.18PM.jpg")); // NOI18N
 * WE GON USE DIS SHIET
 */
package consoleGUI;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Game;
import model.Player;
import model.Route;

/**
 *
 * @author damir
 * @author peter
 * @author yor mama
 */
public class TicketToRideGUI extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
		
	static GraphicsConfiguration gc;
	private static Game game;
	private static String[] colors = { "RED", "BLUE", "GREEN", "YELLOW", "BLACK" };

	public static void initGame() {
		String playerNumStr;
		int playerNum;
		playerNumStr = JOptionPane.showInputDialog("Enter number of players: (2-5)");
		playerNum = Integer.parseInt(playerNumStr);
		
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 0; i < playerNum; i++) {
			String pName = JOptionPane.showInputDialog("Player " + (i+1) + " name: ");
			Player temp = new Player(pName, colors[i]);
			players.add(temp);
		}
		game = new Game(players);
		for (Player p : players) {
			game.drawDestinationTx(p);
			game.drawDestinationTx(p);
		}
		int turn = 0;
		while (true) {
			gameOn(players.get(turn));
			turn++;
			if (turn == players.size())
				turn = 0;
		}
	}
	
	public static void gameOn(Player p) {
		if (game.outOfTrains(p)) {
			Player winner = game.determineWinner();
			JOptionPane.showMessageDialog(null, "WINNER: " + winner.getName() + " with " + winner.getScore() + " points!", "Ticket To Ride", JOptionPane.WARNING_MESSAGE);
		}
		String playerRoutes = String.join("\n", game.getPlayerRoutes(p));
		String playerTx = String.join("\n", game.getPlayerDestinationTx(p));
		JOptionPane.showMessageDialog(null, "Your routes: " + playerRoutes, p.getName(), JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Your destination tickets: " + playerTx, p.getName(), JOptionPane.INFORMATION_MESSAGE);
		Object[] selectionValues = { "Claim Route", "Draw Destination Tickets" };
		String initialSelection = "Claim Route";
		Object selection = JOptionPane.showInputDialog(null, "Choose an action (available trains:" + p.getTrainCount() + ")",
		        p.getName(), JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		if (selection == selectionValues[0]) {
			ArrayList<Route> availableRoutes = game.availableRoutes();
			ArrayList<String> routeStrings = new ArrayList<String>();
			for (Route r : availableRoutes) {
				routeStrings.add(r.toString());
			}
			selectionValues = routeStrings.toArray();
			initialSelection = (String) selectionValues[0];
			selection = JOptionPane.showInputDialog(null, "Choose a route (available trains:" + p.getTrainCount() + ")",
			        p.getName(), JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
			for (int i = 0; i < availableRoutes.size(); i++) {
				if (selection.equals(availableRoutes.get(i).toString()))
					availableRoutes.get(i).claim(p);
			}
		} else
		if (selection == selectionValues[1]) {
			// over here we need to add a possibility for player to choose 1-2 cards to keep from the deck
			// however in this reduced version we're going to stick to 1 card per turn
			game.drawDestinationTx(p);
		}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(gc);
		frame.setTitle("Ticket To Ride");
		frame.setSize(800, 611);
		frame.add(new JLabel(new ImageIcon("javaScreenShot2018-11-04at9.57.18PM.jpg")));
		
		frame.setVisible(true);
		initGame();
	}
}
