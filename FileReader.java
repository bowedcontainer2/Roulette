import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FileReader

{
	// 100A 2

	// 1 10 5000

	// 5 50 10000

	public static void loadGameFile() {

		int numGames;

		int gameType;

		int minBet, maxBet;

		String fileName = "games-1.txt";

		try
		{
			Scanner scan = new Scanner(new File(fileName));

			String dummy = scan.next(); // eat up the game type.

			numGames = scan.nextInt(); // eat up the number of games

			while (scan.hasNext())

			{

				gameType = scan.nextInt();

				minBet = scan.nextInt();

				maxBet = scan.nextInt();
				Game g1=new Game(Integer.toString(gameType), minBet, maxBet);

				Mainpp.gameList.add(g1);
			}

		}

		catch (FileNotFoundException e)

		{

			System.out.println("File was not found!");

		}

		catch (NoSuchElementException e)

		{

			System.out.println("There is no such element exception!");

		}

		catch (IOException e)

		{

			System.out.println("Input/Output exception!");

		}

	}
	public void getAllPlayersFromFile() {
		int PlayerType;

		int id=-1;

		int cash;
		String First="no",Last="no", Name="";

		String fileName = "players-1.txt";

		try	{

			Scanner scan = new Scanner(new File(fileName));
	while(scan.hasNext()) {
	PlayerType=scan.nextInt();
	cash=scan.nextInt();
	if(PlayerType==0) {
		Player c1=new NormalPlayer(cash);
		Implementation.waitingPlayers.add(c1);
		//.out.println(c1.printPlayer());
	}
	else
	{
		id=scan.nextInt();
		First=scan.next();
		Last=scan.next();
		 Name=First+" "+Last;
		if(PlayerType==1) {
			Player a1=new VIPPlayer(Name,cash,Integer.toString(id));
			Implementation.waitingPlayers.add(a1);
			//System.out.println(a1.printPlayer());
		}
		else  {
			Player b1=new SuperVIPPlayer(Name,cash,Integer.toString(id));
			Implementation.waitingPlayers.add(b1);
			//System.out.println(b1.printPlayer());
		}
		
	}
	}

		
	}
		
		catch (FileNotFoundException e)

		{

			System.out.println("File was not found!");

		}

		catch (NoSuchElementException e)

		{

			System.out.println("There is no such element exception!");

		}

		catch (IOException e)

		{

			System.out.println("Input/Output exception!");

		}
		
	}

	
		

}
