import java.util.Scanner;
import java.io.*;
import java.util.NoSuchElementException;

public class FileReader 
{
	
//	100A 2
//	1  10  5000
//	5  50 10000

	public static void loadGameFile()
	{
		int numGames;
		int gameType;
		int minBet, maxBet;
		
		String fileName = "games-1.txt";

		try
		{
			Scanner scan = new Scanner(new File(fileName));
			String dummy = scan.next(); //eat up the game type.
			numGames = scan.nextInt(); //eat up the number of games
			
			while(scan.hasNext())
			{
				gameType = scan.nextInt();
				minBet = scan.nextInt();
				maxBet = scan.nextInt();
				
				Mainpp.gameList.add(new Game(Integer.toString(gameType),minBet, maxBet));
				
			}
		}	
		catch(FileNotFoundException e)
		{
			System.out.println("File was not found!");
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("There is no such element exception!");
		}
		catch(IOException e)
		{
			System.out.println("Input/Output exception!");
		}
		
		
}



}
