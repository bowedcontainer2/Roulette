public class SuperVIPPlayer  extends VIPPlayer{

    public int betCount = 0;

    public SuperVIPPlayer(String playerName, int initialMoney, String idNumber) {

        super(playerName, initialMoney, idNumber);
        super.playerType=2;
    }

    public int superVipCashBack() {

        int cashBack = this.vipCashBack();

        if(betCount >= 5 && betCount <= 10) {
            cashBack += 10;
        }
        else if( betCount>= 11 && betCount <= 20) {
            cashBack += 25;
        }
        else if(betCount > 20) {
            cashBack += 50;
        }
        return cashBack;

    }

    public void addBet() {
        betCount++;
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
