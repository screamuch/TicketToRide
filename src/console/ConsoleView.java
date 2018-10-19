package console;

import java.util.Scanner;
import model.Game;
import model.Player;

public class ConsoleView {
    private static Scanner stdin = new Scanner(System.in);
    Game game;
    
    public void setFinalTurn(boolean bool )
    {
        game.finalTurn = bool; 
    }
    public void printString()
    {
        System.out.println( "Welcome to Ticket To Ride\nPlease enter the amount of players(1-4)" );
    }
    public void announceWinner(Player winningPlayer)
    {
        System.out.println(winningPlayer.getName());
    }
    public void printAskPlayerColor()
    {
        System.out.println("What is your color preference?");
    }
    public String readPlayerColor(String color)
    {
        color = stdin.next();
        return color;
    }
    public void printAskNumPlayers()
    {
        System.out.println("How many players are playing the game? (1-4) ");
    }
    public int numberOfPlayers(int numPlayers)
    {
        numPlayers = stdin.nextInt(); 
        return numPlayers; 
    }
    public Game createNewGame()
    {
        Game game = new Game();
    }

    public void turn(Player curr) {
        game.finalTurn = Game.outOfTrains(curr); 
        if()
    }
}
