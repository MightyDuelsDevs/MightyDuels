/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards.DomainTest;

import Mighty_Cards.Domain.MinionCard;
import Mighty_Cards.Domain.Card;
import Mighty_Cards.Domain.Player;
import Mighty_Cards.Domain.Hero;
import Mighty_Cards.Domain.Minion;
import Mighty_Cards.Domain.HeroCard;
import Mighty_Cards.Domain.Deck;
import Mighty_Cards.Domain.Match;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martijn
 */
public class HeroTest {

    public HeroTest() {
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
     * Test of getDeck method, of class Hero.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);
        Deck expResult = testDeck;

        Deck result = testHero.getDeck();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeck method, of class Hero.
     */
    @Test
    public void testSetDeck() {
        System.out.println("setDeck");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        Deck deck = new Deck();

        testHero.setDeck(deck);
        assertEquals(testHero.getDeck(), deck);

        deck.addCard(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });

        testHero.setDeck(deck);
        assertEquals(testHero.getDeck(), deck);
    }

    /**
     * Test of getFinished method, of class Hero.
     */
    @Test
    public void testFinished() {
        System.out.println("getFinished");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);
        testHero.setFinished(false);

        boolean expResult = false;
        boolean result = testHero.getFinished();
        assertEquals(expResult, result);

        testHero.setFinished(true);

        expResult = true;
        result = testHero.getFinished();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFinished method, of class Hero.
     */
    @Test
    public void testSetFinished() {
        System.out.println("setFinished");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);
        testHero.setFinished(false);

        testHero.setFinished(true);

        boolean expResult = true;
        boolean result = testHero.getFinished();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinions method, of class Hero.
     */
    @Test
    public void testGetMinions() {
        System.out.println("getMinions");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        ArrayList<Minion> expResult = new ArrayList<>();
        ArrayList<Minion> result = testHero.getMinions();
        assertEquals(expResult, result);

        ArrayList<Minion> minions = new ArrayList();
        minions.add(new Minion(new MinionCard("testname", "testFilename", "testDescription", 1, 1, 1) {
        }));
        testHero.setMinions(minions);

        expResult = minions;
        result = testHero.getMinions();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinions method, of class Hero.
     */
    @Test
    public void testSetMinions() {
        System.out.println("setMinions");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        ArrayList<Minion> minions = new ArrayList();
        minions.add(new Minion(new MinionCard("testname", "testFilename", "testDescription", 1, 1, 1) {
        }));
        testHero.setMinions(minions);

        ArrayList<Minion> expResult = minions;
        ArrayList<Minion> result = testHero.getMinions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInHand method, of class Hero.
     */
    @Test
    public void testGetInHand() {
        System.out.println("getInHand");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        ArrayList<Card> expResult = new ArrayList<>();
        ArrayList<Card> result = testHero.getInHand();
        assertEquals(expResult, result);

        ArrayList<Card> cards = new ArrayList();
        cards.add(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });
        cards.add(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });
        cards.add(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });
        testHero.setNewHand(cards);

        expResult = cards;
        result = testHero.getInHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNewHand method, of class Hero.
     */
    @Test
    public void testSetNewHand() {
        System.out.println("setNewHand");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        ArrayList<Card> cards = new ArrayList();
        cards.add(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });
        cards.add(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });
        cards.add(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });
        testHero.setNewHand(cards);

        ArrayList<Card> expResult = cards;
        ArrayList<Card> result = testHero.getInHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardPlayed method, of class Hero.
     */
    @Test
    public void testGetCardPlayed() {
        System.out.println("getCardPlayed");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        Card expResult = null;
        Card result = testHero.getCardPlayed();
        assertEquals(expResult, result);

        expResult = new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        };
        testHero.setCardPlayed(expResult);
        result = testHero.getCardPlayed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCardPlayed method, of class Hero.
     */
    @Test
    public void testSetCardPlayed() {
        System.out.println("setCardPlayed");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        testHero.setCardPlayed(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        });
        Card result = testHero.getCardPlayed();
        assertEquals(testHero.getCardPlayed(), result);
    }

    /**
     * Test of pullCards method, of class Hero.
     */
    @Test
    public void testPullCards() {
        System.out.println("pullCards");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        for (int i = 0; i < 30; i++) {
            testDeck.addCard(new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
            });
        }

        testHero.pullCards();

        ArrayList<Card> result = testHero.getInHand();
        assertNotNull(result);
    }

    /**
     * Test of playCard method, of class Hero.
     */
    @Test
    public void testPlayCard() {
        System.out.println("playCard");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);
        Card testCard = new HeroCard("testname", "testFilename", "testDescription", 1, 1, 1, 1, 1) {
        };

        boolean result = testHero.playCard(testCard);
        assertTrue(result);
        assertNotNull(testHero.getCardPlayed());

        MinionCard testMinionCard = new MinionCard("testname", "testFilename", "testDescription", 1, 1, 1) {
        };
        Minion testMinion = new Minion(testMinionCard);
        ArrayList minions = new ArrayList();
        minions.add(testMinion);
        minions.add(testMinion);
        testHero.setMinions(minions);

        result = testHero.playCard(testCard);
        assertTrue(result);
        assertNotNull(testHero.getCardPlayed());
    }

    /**
     * Test of playCard method, of class Hero.
     */
    @Test
    public void testPlayCardMinions() {
        System.out.println("playCard");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        MinionCard testMinionCard = new MinionCard("testname", "testFilename", "testDescription", 1, 1, 1) {
        };
        Minion testMinion = new Minion(testMinionCard);
        ArrayList minions = new ArrayList();
        minions.add(testMinion);
        minions.add(testMinion);
        testHero.setMinions(minions);

        boolean result = testHero.playCard(testMinionCard);
        assertTrue(!result);
        assertNull(testHero.getCardPlayed());
    }

    /**
     * Test of removeMinion method, of class Hero.
     */
    @Test
    public void testRemoveMinion() {
        System.out.println("removeMinion");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        Minion testMinion = new Minion(new MinionCard("testname", "testFilename", "testDescription", 1, 1, 1) {
        });
        ArrayList minions = new ArrayList();
        minions.add(testMinion);

        testHero.setMinions(minions);

        assertEquals(minions, testHero.getMinions());
        testHero.removeMinion(testMinion);

        ArrayList heroMinions = testHero.getMinions();

        assertTrue(heroMinions.isEmpty());
    }

    /**
     * Test of getHitPoints method, of class Hero.
     */
    @Test
    public void testGetHitPoints() {
        System.out.println("getHitPoints");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);

        int expResult = 50;
        int result = testHero.getHitPoints();
        assertEquals(expResult, result);

        testHero.SetHitPoints(40);

        expResult = 40;
        result = testHero.getHitPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetHitPoints method, of class Hero.
     */
    @Test
    public void testSetHitPoints() {
        System.out.println("SetHitPoints");
        Player testPlayer = new Player("testName", 0, 0, 0, 0, 0);
        Match testMatch = new Match(testPlayer);
        Deck testDeck = new Deck();
        Hero testHero = new Hero(testMatch, testPlayer, testDeck);
        testHero.SetHitPoints(40);

        int expResult = 40;
        int result = testHero.getHitPoints();
        assertEquals(expResult, result);
    }

}
