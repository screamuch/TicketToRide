package model;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    public static void main(String[] args) {
       // DestinationTicket obj = new DestinationTicket("San Francisco", "Las Vegas", 0);
        
       
        //String c1[]; 
        //c1 = new String [7];
        Queue<DestinationTicket> destinationTicketDeck = new LinkedList<>(); 
      
        
        /*
        c1 = hardcoiding start destination
        c2 = end destination 
        pts = value of completed destination 
        destinationTickerDeck = hardcoding each destination card into queue
        */
         String[] c1 = new String[]{ "Portland", "Vancouver", "Denver", "Seattle", "Calgary", "Calagary","Helena" }; 
         String[] c2 = new String[]{ "Phoenix", "Santa Fe", "El Paso", "Los Angeles", "Salt Lake City", "Phoenix", "Los Angeles" }; 
         int[] pts = new int[]{ 11, 13, 4, 9, 7, 13, 8}; 
         for ( int i = 0; i < c1.length; i++ ) 
             destinationTicketDeck.add(new DestinationTicket( c1[i], c2[i], pts[i] ));
         
    }

	public static void main(String[] args) {
		
	}
}
