
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCases {

    Scanner scan = new Scanner(System.in);


    @Test
    public void testPlayerClasses() {

        Player p1 = new Player(12, 2324, 500000, "Johnny Rocket");
        Player p2 = new Player(5000);

        assertTrue(p1.getName().equals("Johnny Rocket"));
        assertTrue(p2.getName().equals("0"));
        assertTrue(p1.getMoney() == p1.initalMoney);

    }

    @Test
    public void testPlayerTypes() {

        VIPPlayer p3 = new VIPPlayer("Subham", 5000, "1212");
        SuperVIPPlayer p4 = new SuperVIPPlayer("Todd", 100000, "1343");
        NormalPlayer normie = new NormalPlayer(69000);

        assertTrue(p3.playerType == 1);
        assertTrue(p4.playerType == 3);
        assertTrue(normie.playerType == 0);

        assertFalse(p3.getMoney() == 0);
        assertTrue(p4.getMoney() == 100000);


    }


    @Test
    public void testGameMethods() {

       /// assertFalse(s1.isElement(7));
        Game gameTest = new Game("1", 500, 1000);
        Game gameTest2 = new Game("2", 1000, 10000);

        Player p1 = new Player(12, 2324, 500000, "Johnny Rocket");
        Player p2 = new Player(5000);
        VIPPlayer p3 = new VIPPlayer("Subham", 5000, "1212");
        SuperVIPPlayer p4 = new SuperVIPPlayer("Todd", 100000, "1343");
        NormalPlayer normie = new NormalPlayer(69000);
        Player otherPlayer = new Player(1000000);

        gameTest.playersInGame.add(p1);
        gameTest.playersInGame.add(p2);
        gameTest.playersInGame.add(p3);
        gameTest.playersInGame.add(p4);
        gameTest.playersInGame.add(normie);

        gameTest2.playersInGame.add(otherPlayer);

        assertFalse(gameTest.hasSpace());
        assertTrue(gameTest2.hasSpace());

    }




}
