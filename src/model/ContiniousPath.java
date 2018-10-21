package model;

import java.util.ArrayList;

public class ContiniousPath {
	private ArrayList<String> cities;
	
	public ContiniousPath() {
		System.out.println("LOL");
	}
	
	public void add(String city) {
		cities.add(city);
	}
	
	public int getLength() {
		return cities.size();
	}
	
	public boolean liesWithin(String city1, String city2) {
		if (cities.contains(city1) && cities.contains(city2))
			return true;
		return false;
	}
}
