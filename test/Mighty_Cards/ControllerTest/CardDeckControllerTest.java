/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards.ControllerTest;

import Controller.CardDeckController;
import Mighty_Cards.Domain.Card;
import Mighty_Cards.Domain.Deck;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class CardDeckControllerTest {
    
    CardDeckController cardDeckController;
    public CardDeckControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        new CardDeckController();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of GetAllCArds method, of class CardDeckController.
     */
    @Test
    public void testGetAllCards() {
        System.out.println("TestgetAllCards");
        String expResult = "Fireblast";
        ArrayList<Card> cards = cardDeckController.allCards;
        assertEquals("Name incorrect expected " + expResult + "recieved: " + cards.get(1).getName(), expResult, cards.get(1).getName());
    }

    /**
     * Test of getDeck method, of class CardDeckController. <-- Expected to work
     */
    @Test
    public void testGetDeck() {
        System.out.println("TestgetDeck");
        int deckID = 1;
        String expResult = "DELADECK";
        Deck result = cardDeckController.getDeck(deckID);
        assertEquals("Results Don't Match, Expected Deck name = " + expResult + "Result: " + result.getName(), expResult, result.getName());

    }

    /**
     * Test of getDeck method, of class CardDeckController. <-- Expectes an
     * Exception
     */
    @Test(expected = SQLException.class)
    public void testGetDeckException() {
        System.out.println("TestgetDeckException");
        int deckID = 6000;
        Deck result = cardDeckController.getDeck(deckID);
        fail("The Deckid was " + deckID + "No such information in database, test failed");
    }

    /**
     * Test of getDecksFromPlayer method, of class CardDeckController.
     */
    @Test
    public void testGetDecksFromPlayer() {
        System.out.println("TestgetDecksFromPlayer");
        int playerID = 1;
        int expResult = 1;
        ArrayList<Deck> result = cardDeckController.getDecksFromPlayer(playerID);
        assertEquals(expResult, result.size());
        fail("The expected result did not match the output expected number of decks : " + expResult + " Actual : " + result.size());
    }

    /**
     * Test of getDecksFromPlayer method, of class CardDeckController. <--
     * Expected SQLException
     */
    @Test(expected = SQLException.class)
    public void testGetDecksFromPlayerException() {
        System.out.println("TestgetDecksFromPlayer");
        int playerID = 6000;
        int expResult = 1;
        ArrayList<Deck> result = cardDeckController.getDecksFromPlayer(playerID);
        fail("The Deckid was " + playerID + "No such information in database, test failed");
    }

}
