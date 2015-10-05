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
 * @author Matthijs
 */
public class HeroCardTest {
    HeroCard testHeroCard;
    
    public HeroCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testHeroCard = new HeroCard("Jaraxxus","C:\testHero.png","Eredar lord of the burning legion",3,5,15,10,15);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of constructor with negative inputs
     */
    @Test ( expected = IllegalArgumentException.class)
    public void testNegativeConstructor(){
        testHeroCard = new HeroCard("Jaraxxus","C:\testHero.png","Eredar lord of the burning legion",-3,5,15,10,15);
        testHeroCard = new HeroCard("Jaraxxus","C:\testHero.png","Eredar lord of the burning legion",3,-5,15,10,15);
        testHeroCard = new HeroCard("Jaraxxus","C:\testHero.png","Eredar lord of the burning legion",3,5,-15,10,15);
        testHeroCard = new HeroCard("Jaraxxus","C:\testHero.png","Eredar lord of the burning legion",3,5,15,-10,15);
        testHeroCard = new HeroCard("Jaraxxus","C:\testHero.png","Eredar lord of the burning legion",3,5,15,10,-15);
    }
    /**
     * Test of getPhysicalDamage method, of class HeroCard.
     */
    @Test
    public void testGetPhysicalDamage() {
        assertEquals("Method \"getPhysicalDamage\" should return \"3\"",3,testHeroCard.getPhysicalDamage());
    }

    /**
     * Test of getMagicalDamage method, of class HeroCard.
     */
    @Test
    public void testGetMagicalDamage() {
        assertEquals("Method \"getMagicalDamage\" should return \"5\"",5,testHeroCard.getMagicalDamage());
    }

    /**
     * Test of getPhysicalBlock method, of class HeroCard.
     */
    @Test
    public void testGetPhysicalBlock() {
        assertEquals("Method \"getPhysicalBlock\" should return \"15\"",15,testHeroCard.getPhysicalBlock());
    }

    /**
     * Test of getMagicalBlock method, of class HeroCard.
     */
    @Test
    public void testGetMagicalBlock() {
        assertEquals("Method \"getMagicalBlock\" should return \"10\"",10,testHeroCard.getMagicalBlock());
    }

    /**
     * Test of getHealValue method, of class HeroCard.
     */
    @Test
    public void testGetHealValue() {
        assertEquals("Method \"getHealValue\" should return \"15\"",15,testHeroCard.getHealValue());
    }    
}
