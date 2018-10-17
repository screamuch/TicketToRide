package model;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    public static void main(String[] args) {
       // DestinationTicket obj = new DestinationTicket("San Francisco", "Las Vegas", 0);
        
       
        //String c1[]; 
        //c1 = new String [7];
        Queue<DestinationTicket> destinationTicketDeck = new LinkedList<>(); 
      
        
        
         String[] c1 = new String[]{ "Portland", "Vancouver", "Denver", "Seattle", "Calgary", "Calagary","Helena" }; // hardcoiding start destination
         String[] c2 = new String[]{ "Phoenix", "Santa Fe", "El Paso", "Los Angeles", "Salt Lake City", "Phoenix", "Los Angeles" }; // end destination 
         int[] pts = new int[]{ 11, 13, 4, 9, 7, 13, 8}; // value of completed destination 
         for (int i = 0; i < c1.length; i++) // 
             destinationTicketDeck.add(new DestinationTicket(c1[i],c2[i],pts[i])); 
    }

}
