/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author damir
 */
public class DestinationTicket {
    public String city1; 
    public String city2; 
    public int points; 
    
    public DestinationTicket()
    {
        city1 = "" ;
        city2 = "" ;
        points = 0; 
    }
    public DestinationTicket(String c1, String c2, int pts)
    {
        city1 = c1; 
        city2 = c2; 
        points = pts; 
    }

    
    void setDestCard(String c1, String c2, int pts)
    {
        this.city1 = c1; 
        this.city2 = c2; 
        this.points = pts; 
    }
    String getCity1()
    {
        return this.city1; 
    }
    String getCity2()
    {
        return this.city2; 
    }
    int getPoints()
    {
        return this.points; 
    }
    @Override
    public String toString()
    {
        // returns destination card
        String output = city1 + " -> " + city2 + ", Points: " + points; 
        return output; 
    }
    public static Queue<DestinationTicket> initADeck()
    {
        /*
        c1 = hardcoiding start destination
        c2 = end destination 
        pts = value of completed destination 
        destinationTickerDeck = hardcoding each destination card into queue
        */
        Queue<DestinationTicket> destinationTicketDeck = new LinkedList<>();
        String[] c1 = new String[]{ "Portland", "Vancouver", "Denver", "Seattle", "Calgary", "Calgary", "Helena" }; 
        String[] c2 = new String[]{ "Phoenix", "Santa Fe", "El Paso", "Los Angeles", "Salt Lake City", "Phoenix", "Los Angeles" }; 
        int[] pts = new int[]{ 11, 13, 4, 9, 7, 13, 8}; 
         for ( int i = 0; i < c1.length; i++ ) 
             destinationTicketDeck.add(new DestinationTicket( c1[i], c2[i], pts[i] ));
         return destinationTicketDeck; 
    }
    
}




