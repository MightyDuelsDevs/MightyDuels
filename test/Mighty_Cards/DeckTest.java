/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards;

import Mighty_Cards.Card;
import Mighty_Cards.Deck;
import Mighty_Cards.MinionCard;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Stan
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    ArrayList<Card> lijstje;
    MinionCard c1;
    Deck deck;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lijstje = new ArrayList<>();
        c1 = new MinionCard("Grim","C:/Downloads/Grim.jpg","Grim is a really strong physical dmg card",3,0,4) {};
        deck = new Deck("Deck1");
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
        public void testAddCard() {
            lijstje.add(c1);
            int resultSize = lijstje.size();
            Assert.assertEquals("Fout, verwacht 1", 1, resultSize);
            lijstje.add(c1);
            // Er mogen maar 2 dezelfde kaarten in één deck zitten.
            lijstje.add(c1);
            int result = lijstje.size();
            Assert.assertEquals("Fout, verwacht 2", 2, result);
	}
        

        @Test
        public void testRemoveCard() {
            lijstje.add(c1);
            lijstje.remove(c1);
            int resultSize = lijstje.size();
            Assert.assertEquals("Fout, verwacht 0", 0, resultSize);
	}
        
        @Test
	public void testSetName() {
            System.out.println("setName");
            deck.setName("Deckje");
            String result = deck.getName();
            Assert.assertEquals("Fouf, verwacht Deckje", "Deckje", result);
	}

        @Test
	public void testGetName() {
        System.out.println("getName");
        String result = deck.getName();
        Assert.assertEquals("Fout, verwacht 'Deck1'", "Deck1", result);
	}

        @Test
	public void testGetCards() {
            System.out.println("getCards");
            int i = 0;
            ArrayList<Card> cards = new ArrayList<>();
            cards.add(c1);
            cards = deck.getCards();
            for(Card c : cards)
            {
                i++;
            }
            Assert.assertEquals("Fout, verwacht 1", 1, i);
	}

}
