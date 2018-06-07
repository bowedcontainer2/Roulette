import java.util.*;



 abstract class Player {



    public int bet, money, betType, number, record, initalMoney, Housemoney, IDno, playerType;

    public int count = 0;

    public String name = "0";


    public Player(int number, int ID, int initialMon, String playerName) {

        name = playerName;

        money = initialMon;

        initalMoney = initialMon;

        record = money;

        IDno = ID;

        playerType = number;

    }



    public Player(int initialMoney) {
        this.initalMoney = initialMoney;

        money = initialMoney;

        playerType = 0;

    }

    public String getName() {

        return name;

    }

    public int getBet() {

        return bet;

    }

    public int getMoney() {

        if (money == 0) {

            System.out.println("Sorry you don't have any money!");

            // Need to remove this player from the queue

        }

        return money;

    }



    public int playerType() {

        return playerType;

    }



    public void makeBet(Scanner scan) {



        boolean a = true;


        System.out.println("Money Available: "+money);
        System.out.print("How much to bet: ");

        bet = scan.nextInt();

        while (a) {



            if (bet > money) {

                System.out.print("Invalid Input! Please enter bet within your total amount: ");

                bet = scan.nextInt();

                a = true;

            } else if (bet < Game.minBet || bet > Game.maxBet)// Need to instantiate MIN and Max

            //  i.e. wheel no longer contains those

            {	System.out.println("Invalid Bet amount!!");

                System.out.println("Please enter amount between "+Game.minBet+" to "+ Game.maxBet);

                a = true;
                bet = scan.nextInt();

            }
            else {

                a = false;

            }

        }

        money -= bet;

        Game.houseMoney += bet;

        Wheel.betOptions();

        System.out.print("Enter the number to command for bet:");

        betType = scan.nextInt();

        while (betType != 1 && betType != 2 && betType != 3) {

            System.out.print("Invalid Input! Please input (1,2 or 3):");

            betType = scan.nextInt();

        }

        if (betType == Wheel.NUMBER) {

            System.out.print("Enter the number to bet on:");

            number = scan.nextInt();

            while (number < Wheel.MIN_NUM || number > Wheel.MAX_POSITIONS) {

                System.out.print("Invalid Input. Please enter number between 1 to 14:");

                number = scan.nextInt();

            }

        }







    }
    public void payment() {

        money = money + Wheel.payoff(bet, betType, number);

        System.out.println(name + " won: " + Wheel.payoff(bet, betType, number));

        if (Wheel.payoff(bet, betType, number) == 0) {

            System.out.println("New Balance: " + (money));



        } else {

            money += bet;

            System.out.println("New Balance: " + (money));

        }

        Game.houseMoney -= Wheel.payoff(bet, betType, number);

    }





    public void addTransaction(int i) {

        Mainpp.gameList.get(i).transactionLines.add(new Transaction( getName(), getBet(), Wheel.payoutAmount ));



    }



    public void addsubMoney(int net) {

        money += net;

    }
    public void addMoney(int mon) {
    	money+=mon;
    	count++;
    }



    public abstract String printPlayer();
    	

   

}
