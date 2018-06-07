import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {

	public String name;

	public static int minBet, maxBet;

	public static int transactionNumber;

	public static int houseMoney;

	public ArrayList<Player> playersInGame = new ArrayList<Player>();

	public  ArrayList<Transaction> transactionLines = new ArrayList<Transaction>();

	public Game(String name, int minBet, int maxBet) {

		this.name = "100A" + name;

		this.minBet = minBet;

		this.maxBet = maxBet;

		transactionNumber = 0;

	}

	public void addPlayerFromQueue() {
		

		// take player out of queue and put into playersInGame

		if (Implementation.waitingPlayers.peek() == null) {

			System.out.println("No waiting players to pull from Queue");

		}
		

		else {

			playersInGame.add(Implementation.waitingPlayers.poll()); // adding to arrayList playersInGame from Queue
																// waitingPlayers

		}

	}

	public  boolean hasSpace() {

		if (playersInGame.size() < 5) {

			return true;

		}

		else {

			return false;

		}

	}
	

	public  void printPlayers() {

		for (int i = 0; i < playersInGame.size(); i++) {

			System.out.println("Player " + playersInGame.get(i).name + " \t Money: $" + playersInGame.get(i).money);

		}

	}


	
	


}
