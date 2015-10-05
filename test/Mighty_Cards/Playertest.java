/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Loek
 */
public class Playertest {

    public Playertest() {

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testgetUsername() {
        Player x = new Player("Username", "Password");
        assertEquals(x.getUsername(), "Username");
    }

    @Test
    public void testgetIconId() {
        Player x = new Player("Username", "Password");
        x.setIconId(1);
        assertEquals(x.getIconId(), 1);
    }

    /**
     *
     * @param iconId
     */
    @Test
    public void testsetIconId() {
        Player x = new Player("Username", "Password");
        x.setIconId(1);
        assertEquals(x.getIconId(), 1);
    }

    @Test
    public void testgetRating() {
        Player x = new Player("Username", "Password");
        x.setRating(1);
        assertEquals(x.getRating(), 1);
    }

    /**
     *
     * @param rating
     */
    @Test
    public void testsetRating() {
        Player x = new Player("Username", "Password");
        x.setRating(1);
        assertEquals(x.getRating(), 1);
    }

    @Test
    public void testMatches() {
        Player x = new Player("Username", "Password");
        x.setMatches(1);
        assertEquals(x.getMatches(), 1);
    }
 
    @Test
    public void testgetWins() {
        Player x = new Player("Username", "Password");
        x.setWins(1);
        assertEquals(x.getWins(), 1);
    }

    @Test
    public void testsetWins() {
        Player x = new Player("Username", "Password");
        x.setWins(1);
        assertEquals(x.getWins(), 1);

    }

    @Test
    public void testgetLoses() {
        Player x = new Player("Username", "Password");
        x.setLoses(1);
        assertEquals(x.getLosses(), 1);
    }

    @Test
    public void testsetLoses() {
        Player x = new Player("Username", "Password");
        x.setLoses(1);
        assertEquals(x.getLosses(), 1);
    }

    @Test
    public void testchangeIcon() {
        

    }
}
