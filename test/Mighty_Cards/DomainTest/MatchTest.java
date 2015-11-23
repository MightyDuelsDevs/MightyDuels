/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards.DomainTest;

import Server.Domain.GameState;
import Server.Domain.Player;
import Server.Domain.Hero;
import Server.Domain.Match;
import java.lang.reflect.Field;
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
 * @author Rick Rongen, www.R-Ware.tk
 */
public class MatchTest {
    
    public MatchTest() {
    }
    
        private Player p1, p2;
        private Match m;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p1 = new Player(0, "Player1", 0, 0, 0, 0, 0);
        p2 = new Player(0, "Player2", 0, 0, 0, 0, 0);
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
     * Test of getHero method, of class Match.
     */
    @Test
    public void testGetHero() {
        
        m.addPlayer2(p2);
        
        System.out.println("getHero1");
        Hero h1 = m.getHero1();
        Hero h2 = m.getHero2();
        assertNotSame(h1,h2);
        try {
            Field field = Hero.class.getDeclaredField("player");
            field.setAccessible(true);
            assertEquals(p1,field.get(h1));
            assertEquals(p2,field.get(h2));
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(MatchTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Somthing went wrong!");
        }
        
    }

    /**
     * Test of concede method, of class Match.
     */
    @Test
    public void testConcede() {
        
        m.addPlayer2(p2);
        
        System.out.println("concede");
        m.concede(m.getHero1());
        assertEquals(GameState.Defined,m.getGameState());//check if game is finished
        assertEquals(0,m.getHero1().getHitPoints());//check if helth is 0
    }
    
    /**
     * Test of processTurn method, of class Match.
     */
    @Test
    public void testprocessTurn() {
        
        Match testMatch = new Match(p1);
        testMatch.addPlayer2(p2);
        
        testMatch.startTurn();
        
        testMatch.getHero1().setFinished(true);
        testMatch.getHero2().setFinished(true);
        
        testMatch.startTurn();
    }
    
    
     /**
     * Test of startTurn method, of class Match.
     */
    @Test
    public void teststartTurn() {
        
        Match testMatch = new Match(p1);
        testMatch.addPlayer2(p2);
        
        testMatch.startTurn();
        
        Hero testHero1 = testMatch.getHero1();
        Hero testHero2 = testMatch.getHero2();
        
        testHero1.setHitPoints(0);
        testHero2.setHitPoints(0);
        
        testHero1.setFinished(true);
        testHero2.setFinished(true);
        
        testMatch.startTurn();
    }
}
