/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards;

import Mighty_Cards.Deck;
import Mighty_Cards.Hero;
import Mighty_Cards.ITarget;
import Mighty_Cards.Match;
import Mighty_Cards.Minion;
import Mighty_Cards.MinionCard;
import Mighty_Cards.Player;
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
public class MinionTest {
    
    public MinionTest() {
    }
    
    Player p1;
    Player p2;
    Match match;
    Deck deck1;
    Deck deck2;
    Hero hero1;
    Hero hero2;
    Minion m1;
    Minion m2;
    MinionCard mc1;
    MinionCard mc2;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p1 = new Player("Stan", "wachtwoordStan");
        p2 = new Player("Mark", "wachtwoordMark");
        match = new Match(p1);
        deck1 = new Deck("Deckje");
        hero1 = new Hero(match,p1,deck1); // Waarom heeft hero nog een player als de player al in Match zit ?¿?
        mc1 = new MinionCard("Warlock","C;/Download/Warlock.png","Ancient monster with strong physical damage",4,0,5) {};
        mc2 = new MinionCard("Rogue","C;/Download/Rogue.png","Powerfull female character with daggers",5,0,6) {};
        m1 = new Minion(mc1);
        m2 = new Minion(mc2);
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
	public void testAttack() {
            m1.Attack();
            m1.setITarget(m2);
            int result = m2.getHitPoints();
            Assert.assertEquals("Fout, verwacht 2", 2, result);
	}

        @Test
	public void testGetPhysicalDamage() {
		int result = mc1.getPhysicalDamage();
                Assert.assertEquals("Fout, veracht 4", 4, result);
	}

        @Test
	public void testGetMagicalDamage() {
		int result = m1.getMagicalDamage();
                Assert.assertEquals("Fout, verwacht 0", 0, result);
	}

        @Test
	public void testGetMaxHitPoints() {
		int result = m1.getMaxHitPoints();
                Assert.assertEquals("Fout, verwacht 5", 5, result);
	}

        @Test
	public void testGetITarget() {
            ITarget enemyMinion = m2;
            m1.setITarget(enemyMinion);
            ITarget expected = m1.getITarget();
            Assert.assertEquals("Fout, verwacht 'enemyMinion'", "enemyMinion", expected);
	}

        @Test
	public void testSetITarget() {
            int initHP = hero2.getHitPoints();
            System.out.println("initial HitPoints: " + initHP);
            m1.setITarget(hero2);
            m1.Attack();
            int afterHP = hero2.getHitPoints();
            Assert.assertEquals("Fout, verwacht xx", initHP - 4, afterHP);
	}

        @Test
        public void testGetHitPoints(){
            int result = m1.getHitPoints();
            Assert.assertEquals("Fout, verwacht 5", 5, result);
        }
        
        @Test
        public void testSetHitPoints(){
            m1.SetHitPoints(2);
            Assert.assertEquals("Fout, verwacht 2", 2, m1.getHitPoints());
        }
}
