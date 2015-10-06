/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramòn Janssen
 */
public class GameTest {

    private final Game game;
    private Player player = null;

    public GameTest() {
        this.game = Game.getInstance();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIcon method, of class Game.
     */
    @Test
    public void testGetIcon() {
        System.out.println("getIcon");
        Game instance = this.game;
        ArrayList<Icon> expResult = null;
        ArrayList<Icon> result = instance.getIcon();
        assertEquals("didn't receive the correct list", expResult, result);
    }

    /**
     * Test of getInstance method, of class Game.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Game instance = this.game;
        Game expResult = this.game;
        Game result = instance.getInstance();
        assertEquals("didn't receive the correct instance", expResult, result);
    }

    /**
     * Test of login method, of class Game.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "Pyrion";
        String password = "test1234";
        Game instance = this.game;
        player = new Player(username, password);
        Player expResult = player;
        Player result = instance.login(username, password);
        assertEquals("didn't create the correct player", expResult.getUsername(), result.getUsername());
    }

    /**
     * Test of getCards method, of class Game.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        Game instance = this.game;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCards();
        assertEquals("didnt't receive the correct list of cards", expResult, result);
    }

    /**
     * Test of register method, of class Game.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String username = "Pyrion";
        String password = "Test1234";
        Game instance = this.game;
        boolean expResult = true;
        boolean result = instance.register(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterFalse1() {
        System.out.println("register");
        String username = "";
        String password = "Test1234";
        Game instance = this.game;
        boolean expResult = false;
        boolean result = instance.register(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterFalse2() {
        System.out.println("register");
        String username = "";
        String password = "";
        Game instance = this.game;
        boolean expResult = false;
        boolean result = instance.register(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterFalse3() {
        System.out.println("register");
        String username = "Pyrion";
        String password = "";
        Game instance = this.game;
        boolean expResult = false;
        boolean result = instance.register(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of startMatch method, of class Game.
     */
    @Test
    public void testStartMatch() {
        System.out.println("startMatch");
        Player player = this.player;
        Game instance = this.game;
        Match expResult = new Match(player);
        Match result = instance.startMatch(player);
        try {
            Field field = Match.class.getDeclaredField("player1");
            field.setAccessible(true);
            System.out.println(field.get(expResult));
            System.out.println(field.get(result));
            assertEquals(player, field.get(expResult));
            assertEquals(player, field.get(result));
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(MatchTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Somthing went wrong!");
        }
    }
}
