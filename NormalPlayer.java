public class NormalPlayer extends Player {

    public NormalPlayer(int initialMoney) {

        super(initialMoney);


    }
    @Override
	public String printPlayer() {
	    String result = "";
	    
            if (count <= 0) {

               int result1 = money - record;
	    
	                System.out.println();
	    
	                if (result1 > 0) {
	    
                   System.out.println("---------Congratulations!---------" );
	    
                    result = "Total money won" + " $" + (result1 - count * initalMoney);
	   
	                } else if (result1 == 0) {
	    
                    result = " did not win nor did lose..";
	    
	                } else {
	    
                   result1 *= -1;
	   	                    System.out.println("---------Better Luck next time!!--------- ");
	    
                    result = "Total money lost " + "$" + (result1 + count * initalMoney);
	    
               }
	    
            }
	    
            System.out.println(" Housemoney" +  ": $" + Game.houseMoney);
	    
           System.out.println();
	    
	            return result;
	}



}
