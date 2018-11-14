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
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(gc);
		frame.setTitle("Ticket To Ride");
		frame.setSize(800, 611);
		frame.add(new JLabel(new ImageIcon("javaScreenShot2018-11-04at9.57.18PM.jpg")));
		JList claimedRoutes = new JList();
		JScrollPane listScroller = new JScrollPane(claimedRoutes);
		frame.add(listScroller);
		listScroller.setBounds(650, 0, 150, 300);
		
		frame.setVisible(true);
		initGame();
	}
}
