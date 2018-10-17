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
        city1 = c1; 
        city2 = c2; 
        points = pts; 
    }
}
