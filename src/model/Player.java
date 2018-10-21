package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private static final int STARTING_TRAINS = 20;

	// not used yet
	enum Color {
		RED, BLUE, GREEN, YELLOW, BLACK
	}

	private String name, color;
	private int trainCount, score;
	private List<DestinationTicket> destinationTickets;

	// this constructor is only for tests
	public Player(String name, String color, int trainCount, int score) {
		this.name = name;
		this.color = color;
		this.trainCount = trainCount;
		this.score = score;
	}

	// use this constructor for the actual game
	public Player(String name, String color) {
		this.name = name;
		this.color = color;
		this.trainCount = STARTING_TRAINS;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getTrainCount() {
		return trainCount;
	}

	public void reduceTrainCount(int len) {
		this.trainCount -= len;
	}

	public void addPoints(int pts) {
		this.score += pts;
	}

	public List<DestinationTicket> getDestinationTickets() {
		return destinationTickets;
	}

	@Override
	public String toString() {
		return "Player: " + name + ", " + color + "; " + "Trains remaining: " + trainCount + "; " + "Score: " + score;
	}
}
