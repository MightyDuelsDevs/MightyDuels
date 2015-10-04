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
 * @author Ramòn Janssen
 */
public class IconTest {

    private Icon icon = null;

    public IconTest() {
        icon = new Icon(13, 1400, "C:\\");
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
     * Test of getId method, of class Icon.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Icon instance = this.icon;
        int expResult = 13;
        int result = instance.getId();
        assertEquals("wrong ID was returned", expResult, result);
    }

    /**
     * Test of getRatingLock method, of class Icon.
     */
    @Test
    public void testGetRatingLock() {
        System.out.println("getRatingLock");
        Icon instance = this.icon;
        int expResult = 1400;
        int result = instance.getRatingLock();
        assertEquals("wrong rating was returned", expResult, result);
    }

    /**
     * Test of getFileName method, of class Icon.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        Icon instance = this.icon;
        String expResult = "C:\\";
        String result = instance.getFileName();
        assertEquals("wrong filepath was returned", expResult, result);
    }

}
