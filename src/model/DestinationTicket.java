/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author damir
 */
public class DestinationTicket {
    public String city1; 
    public String city2; 
    public int points; 
    
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
    public String toString()
    {
        String output = city1 + " " + city2 + " " + " " + points; 
        return output; 
    }
}




