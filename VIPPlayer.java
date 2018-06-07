public class VIPPlayer extends Player{

    public int initialMoney;
    public String playerName;
    public String idNumber;
    public int totalBetAmount;

    public VIPPlayer(String playerName, int initialMoney, String idNumber) {

        super(1, Integer.parseInt(idNumber),initialMoney, playerName); // parent constructor

        this.playerName = playerName;
        this.idNumber = idNumber;
        this.initialMoney = initialMoney;
    }

    public int vipCashBack() {

        double cashBackDouble = .05 * totalBetAmount; // calculate cashback double
        return (int) Math.round(cashBackDouble); // convert to int and return

    }
    @Override
	public String printPlayer() {
	       String result = "";
	       
              if (count <= 0) {
	       
                   int result1 = money - record;
	                   System.out.println();
	                          if (result1 > 0) {
	       
                  System.out.println("---------Congratulations!---------:" +name+"\tPlayer ID:"+idNumber);;
	                              result = "Total money won" + " $" + (result1 - count * initalMoney);//need to work on it after no 3 of gameMenu
	 	                   } else if (result1 == 0) {
	                              result = " did not win nor did lose..";           } 
	 	                   else {
	       
                   result1 *= -1;
	       
                       System.out.println("---------Better Luck next time!!--------- :"+name+"\tPlayer ID:"+idNumber);
	       
                       result = "Total money lost by " + name + " is $" + (result1 + count * initalMoney);
	       	                   }
	       
               }
	       	               System.out.println(" Housemoney because of " + name + ":$" + Game.houseMoney);
	       
             System.out.println();
	       
              return result;

	           // method toString
	}



}
