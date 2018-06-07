import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

public class Implementation {

	public static Queue<Player> waitingPlayers = new LinkedList<Player>(); // Queue of Players not currently in game.
																			// Add initial queue elements from text
			public static int opt2=0;																// inputs

	public Implementation() {
		

	}

	public static void implement(Scanner scan) {

		boolean k = false;
		try {

		while (k == false) { // beginning of main menu
			

			Dis.display1();

			Mainpp.opt1 = scan.nextInt();

			switch (Mainpp.opt1) {

			case 1:

				int gameIndex = -1;

				Dis.displayGames();

				boolean a = false;

				while (a == false) { // checking for inputted game validity

					System.out.println("Select a Game:");

					String choice = scan.next();

					int tracker = 0;

					for (int i = 0; i < Mainpp.gameList.size(); i++) { // look for inputed game choice in the arrayList
																		// of Games

						if (choice.equals(Mainpp.gameList.get(i).name)) { // inputted game is a valid game in arraylist
																			// of games in program

							a = true;

							gameIndex = i;

							boolean z = false;

							tracker++;

							while (z == false) { // setting up game menu functionality

								Dis.display2();

								opt2 = scan.nextInt();

								if (opt2 == 1) { // "Add Player to the Game"

									try {

										Mainpp.gameList.get(gameIndex).addPlayerFromQueue();

										System.out.println("Adding Player to Game");

									}

									catch (IndexOutOfBoundsException e) {

										System.out.println(
												"Variable gameIndex was not altered after initialization: " + e);

									}

								}

								else if (opt2 == 2) { // "Play one round" CREATE PLAYER MENU
									
					
								Dis.playerOption();
								

									int opt3 = scan.nextInt();
									boolean not=false;
									while(not) {

									if (opt3 == 1)

									{
										opt121(scan,gameIndex);									

									}
									else if (opt3==2) {//Multiple Bets
										
									opt122(scan,gameIndex);
									
									}
									else if (opt3==3) {//Add more money to Existing Players
										System.out.println(Mainpp.gameList.get(gameIndex).playersInGame.size());
										for(int ko=0;ko<Mainpp.gameList.get(gameIndex).playersInGame.size();ko++) {
											System.out.print("Would you like to add money?(y/n)-->");
											String know=scan.next();
											if (know.equalsIgnoreCase("y")) {
													System.out.print("Money to add-->");
													int addmoney=scan.nextInt();
													Mainpp.gameList.get(gameIndex).playersInGame.get(ko).addMoney(addmoney);
													System.out.println("Money is added");
											}
											else {
												System.out.println("No money added");
											}
											}
												
									}
										
									else if(opt3==4) {// Skip the bet
										System.out.println(Mainpp.gameList.get(gameIndex).playersInGame.size());
										for(int ko=0;ko<Mainpp.gameList.get(gameIndex).playersInGame.size();ko++) {
											System.out.print("Would you like to skip a bet?(y/n)-->");
											String know=scan.next();
											if (know.equalsIgnoreCase("y")) {
													System.out.print("skipped");
											}
											else {
												System.out.println("Wanna make a single or multiple bet(s/m)");
												String kk=scan.next();
												if(kk.equalsIgnoreCase("s")) {
													opt121(scan,gameIndex);}
												else
													opt122(scan,gameIndex);
												
												
											}
										}
										
									}
									else if(opt3==5) {// return to game menu
										not=false;
									}
									}

								}

								else if (opt2 == 3) { // "Game Status"

									Mainpp.gameList.get(gameIndex).printPlayers();

									System.out.println("House Money: $" + Mainpp.gameList.get(gameIndex).houseMoney);

									for (int j = Mainpp.gameList.get(gameIndex).transactionLines.size()- 1; j > Mainpp.gameList.get(gameIndex).transactionLines.size() - 4; j--) {

										System.out.println(	Mainpp.gameList.get(gameIndex).transactionLines.get(i).toString());

									}

								}

								else if (opt2 == 4) { // "Return to the main menu

									z = true;

								}

							}

						}

					}
					if (tracker == 0) { // execute if we cant find the

						System.out.println("Game Choice not found, please select from the given list.");

					}

				}

				break;

			// invoke game selection

			case 2:

				System.out.println("Adding Player to the Queue.");

				addPlayerToQueue();

				// invoke add a new player to the list with the queue

				break;

			case 3:

				k = true;

				// terminate the program while displaying the complete information for each game
				// to a new txt file

				break;

			default:

				System.out.println("Invalid Input! Please Try again");

				break;

			}

		}
		}
		
		catch(InputMismatchException e) {
			System.out.println("Invalid Input. Please,Restart the game to Try Again-->");
		}
		

	}

	public static void addPlayerToQueue() {

		Scanner scan = new Scanner(System.in);

		System.out.print(
				"What kind of player would you like to add? (Input Number: Normal == 0, VIP == 1, SuperVIP == 2 )-->");

		int type = scan.nextInt();

		System.out.println("How much money does this player start with?");

		int initialMoney = scan.nextInt();

		if (type > 0) {

			System.out.println("Enter a 4 digit ID number for you player:");

			String idNumber = scan.nextLine();

			System.out.println("Please Enter a First and Last Name:");

			String fullName = scan.nextLine();

			if (type == 1) {

				Player p1 = new VIPPlayer(fullName, initialMoney, idNumber);

				System.out.println("VIP Player Created and added to Queue");

			}

			if (type == 2) {

				Player p2 = new SuperVIPPlayer(fullName, initialMoney, idNumber);

				System.out.println("Super VIP Player Created and added to Queue");

			}

		}

		else {

			Player p3 = new NormalPlayer(initialMoney);

			System.out.println("Normal Player Created and added to Queue");

		}

	}
	public static void opt121(Scanner scan, int gameIndex) {
		Dis.playerOption();

		int opt3 = scan.nextInt();

		if (opt3 == 1)

		{
													
				Dis.display3();

				Wheel.betOptions();
				
                    if(Mainpp.gameList.get(gameIndex).playersInGame.size()==0) {
                    	System.out.println("Error! No Players Added to the game");
                    }
                    for (int play = 0; play < Mainpp.gameList.get(gameIndex).playersInGame.size(); play++) {
                    	System.out.println("Play");

                        Mainpp.gameList.get(gameIndex).playersInGame.get(play).makeBet(scan);
                        
                    }

                    System.out.println("Finished ");

                    System.out.println("Spinning Wheel");

                    Wheel.spin();}
	}
		public static void opt122(Scanner scan,int gameIndex) {
			Dis.display3();

			Wheel.betOptions();

            if(Mainpp.gameList.get(gameIndex).playersInGame.size()==0) {
            	System.out.println("Error! No Players Added to the game");
            }
                for (int play = 0; play < Mainpp.gameList.get(gameIndex).playersInGame.size(); play++) {
                	System.out.println("Play");
                	while(Dis.playAgain(scan)) {
                    Mainpp.gameList.get(gameIndex).playersInGame.get(play).makeBet(scan);
                    
                	}
                }

                System.out.println("Finished ");

                System.out.println("Spinning Wheel");

                Wheel.spin();
			
		}
	
}
