package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	

	private String name, color;
	private int trainCount, score;
	List<DestinationTicket> destinationTickets;

	public Player(String name, String color, int trainCount, int score) {
		this.name = name;
		this.color = color;
		this.trainCount = trainCount;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public void reduceTrainCount() {
		trainCount--;
	}
	
	@Override
	public String toString() {
		return "Player: " + name + ", " + color + "; " + "Trains remaining: " + trainCount + "; " + "Score: " + score;
	}
}
