/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Matthijs
 */
public class CardTest {
    CardImpl testCard;
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testCard = new CardImpl("test card","C:/test.png","my first test card");
    }
    
    @After
    public void tearDown() {
    }
    
    public class CardImpl extends Card {

        public CardImpl(String name, String filename, String description) {
            super(name, filename, description);
        }
    }
    
    /**
     * Test of getName method, of class Card.
     */
    @Test
    public void testGetName() {
        assertEquals("Method \"getName\" should return \"test card\"! ","test card",testCard.getName());
    }

    /**
     * Test of getFilename method, of class Card.
     */
    @Test
    public void testGetFilename() {
       assertEquals("Method \"getFileName\" should return \"C:/test.png\"! ","C:/test.png",testCard.getFilename());
    }

    /**
     * Test of getDescription method, of class Card.
     */
    @Test
    public void testGetDescription() {
       assertEquals("Method \"getDesciption\" should return \"my first test card\"! ","my first test card",testCard.getDescription());
    }

    /**
     * Test of testForNegativeValue method, of class Card.
     */
    @Test ( expected = IllegalArgumentException.class)
    public void testTestForNegativeValue() {
        testCard.testForNegativeValue(-1);
    }
}
