/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards.DomainTest;

import Mighty_Cards.Domain.MinionCard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthijs
 */
public class MinionCardTest {
    
    MinionCard testMinionCard; 
    
    public MinionCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testMinionCard = new MinionCard("Annoyotron","C:/Annoyotron.png","My god, this minion is annoying!",1,1,2);
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of constructor with negative inputs
     */
    @Test ( expected = IllegalArgumentException.class)
    public void testNegativeConstructor(){
        testMinionCard = new MinionCard("Annoyotron","C:/Annoyotron.png","My god, this minion is annoying!",-1,1,2);
        testMinionCard = new MinionCard("Annoyotron","C:/Annoyotron.png","My god, this minion is annoying!",1,-1,2);
        testMinionCard = new MinionCard("Annoyotron","C:/Annoyotron.png","My god, this minion is annoying!",1,1,-2);
    }
    
    /**
     * Test of getPhysicalDamage method, of class MinionCard.
     */
    @Test
    public void testGetPhysicalDamage() {
        assertEquals("Method \"getPhysicalDamage\" should return \"1\"",1,testMinionCard.getPhysicalDamage());       
    }

    /**
     * Test of getMagicalDamage method, of class MinionCard.
     */
    @Test
    public void testGetMagicalDamage() {
        assertEquals("Method \"getMagicalDamage\" should return \"1\"",1,testMinionCard.getMagicalDamage());
    }

    /**
     * Test of getHitPoints method, of class MinionCard.
     */
    @Test
    public void testGetHitPoints() {
        assertEquals("Method \"getHitPoints\" should return \"2\"",2,testMinionCard.getHitPoints());       
    }
    
}
//assertEquals