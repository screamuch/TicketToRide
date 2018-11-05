package console;

import java.util.Scanner;
import model.Game;
import model.Player;
import model.Route;
 
public class ConsoleView {
    private static Scanner stdin = new Scanner(System.in);
    Game game;
    
    
    public static void printString()
    {
        System.out.println( " Welcome to Ticket To Ride " );
        System.out.println(" Each player will be given 4 train cards to start the game");
        System.out.println(" Each player will be given 3 destination cards");
        System.out.println(" Which of 3, they must keep at least 2");
        System.out.println(" During a turn players may either draw 2 train cards, draw 3 destination cards");
        System.out.println(" (Which of 3, the player must keep 1 at least)"); 
        System.out.println(" , or claim a route.");
    }
    public static void announceWinner(Player winningPlayer)
    {
        System.out.println(winningPlayer.getName() + " has won! ");
    }
    public static void printAskPlayerName()
    {
        System.out.println(" What is players name? " );
    }
    public static void readPlayerName()
    {
        String name; 
        name = stdin.next(); 
    }
    public static void printAskPlayerColor()
    {
        System.out.println( " What is your color preference? (Red, Green, Blue, Black, Yellow) " );
    }
    public static void readPlayerColor()
    {
        String color;
        color = stdin.next();
    }
    public static void printAskNumPlayers()
    {
        System.out.println( " How many players are playing the game? (1-5) " );
    }
    public static void numberOfPlayers()
    {
        int numPlayers;
        numPlayers = stdin.nextInt();  
    }
    public static void createNewGame()
    {
        Game game = new Game();
    }
    public static void displayRoutes(Route r)
    {
        Route route = r;
        System.out.println(route.toString());
        
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
        Player p; 
        printString(); 
        printAskNumPlayers(); 
        numberOfPlayers();  
      /*  for(int i; i < p.length(); i++)
        {
            printAskPlayerName(); 
            readPlayerName(); 
            printAskPlayerColor(); 
            readPlayerColor(); 
        }
        turn(p); */
        
        
        
       
	}
}