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
 * @author Rick Rongen, www.R-Ware.tk
 */
public class MatchTest {
    
    public MatchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Player p1, p2;
    Match m;
    
    @Before
    public void setUp() {
        p1 = new Player("Player1","pass");
        p2 = new Player("Player2","pass");
        m = new Match(p1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addPlayer2 method, of class Match.
     */
    @Test
    public void testAddPlayer2() {
        System.out.println("addPlayer2");
        assertEquals(m.getGameState(),GameState.Waiting);
        m.addPlayer2(p2);
        assertEquals(m.getGameState(),GameState.Active);
    }

    /**
     * Test of getTurns method, of class Match.
     */
    @Test
    public void testGetTurns() {
        System.out.println("getTurns");
        int expResult = 0;
        int result = m.getTurns();
        assertEquals(expResult, result);
        //no turns played
    }

    /**
     * Test of getHero1 method, of class Match.
     */
    @Test
    public void testGetHero1() {
        System.out.println("getHero1");
        Hero result = m.getHero1();
        //assertEquals(result.getPlayer(), p1);
        fail("Missing method.");
    }

    /**
     * Test of getHero2 method, of class Match.
     */
    @Test
    public void testGetHero2() {
        System.out.println("getHero2");
                Hero result = m.getHero2();
        //assertEquals(result.getPlayer(), p2);
        fail("Missing method.");
    }

    /**
     * Test of concede method, of class Match.
     */
    @Test
    public void testConcede() {
        System.out.println("concede");
        m.concede(m.getHero1());
        assertEquals(GameState.Defined,m.getGameState());//check if game is finished
        assertEquals(0,m.getHero1().getHitPoints());//check if helth is 0
    }
    
}
