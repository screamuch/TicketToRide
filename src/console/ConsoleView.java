package console;

import java.util.Scanner;
import model.Game;
import model.Player;

public class ConsoleView {
    private static Scanner stdin = new Scanner(System.in);
    Game game;
    
    
    public static void printString()
    {
        System.out.println( " Welcome to Ticket To Ride " );
    }
    public static void announceWinner(Player winningPlayer)
    {
        System.out.println(winningPlayer.getName() + " has won! ");
    }
    public static void printAskPlayerColor()
    {
        System.out.println( " What is your color preference? (Red, Green, Blue, Black, Yellow) " );
    }
    public static String readPlayerColor(String color)
    {
        color = stdin.next();
        return color;
    }
    public static void printAskNumPlayers()
    {
        System.out.println( " How many players are playing the game? (1-5) " );
    }
    public static int numberOfPlayers(int numPlayers)
    {
        numPlayers = stdin.nextInt(); 
        return numPlayers; 
    }
    public static void createNewGame()
    {
        Game game = new Game();
    }
    public static void displayRoutes()
    {
        
    }

    public void turn(Player curr) {
        game.setFinalTurn( Game.outOfTrains(curr) );
        String choice; 
        do {
            System.out.println( " What would you like to do " );
            System.out.println( " 1) Claim Route " );
            System.out.println( " 2) Draw destination ticket " ); 
            choice = stdin.next(); 
        } while(choice != "1" || choice != "2");
        
            
            
        
            
    }
    public static void main(String[] args) {
        printString();
        printAskNumPlayers(); 
       // numberOfPlayers();
        printAskPlayerColor(); 
        
	}
}
