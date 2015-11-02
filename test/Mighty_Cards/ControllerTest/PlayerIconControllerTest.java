/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mighty_Cards.ControllerTest;

import Controller.PlayerIconController;
import Mighty_Cards.Domain.Icon;
import Mighty_Cards.Domain.Player;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Ramòn Janssen
 */
public class PlayerIconControllerTest {

    public PlayerIconControllerTest() {
    }
    
    @Before
    public void setUp() {
        PlayerIconController.playerIconControllerInit();
    }
    /**
     * Test of testcreateIcons method, of class PlayerIconController.
     */
    @Test
    public void testcreateIcons() {
        System.out.println("createIcons");

        ArrayList<Icon> icons = PlayerIconController.getIcons(1500);
        Icon expResult = new Icon(1, 800, "/Images/I1");
        
        assertEquals(expResult.getId(), icons.get(0).getId());
        assertEquals(expResult.getRatingLock(), icons.get(0).getRatingLock());
        assertEquals(expResult.getFileName(), icons.get(0).getFileName());
    }

    /**
     * Test of testchangePlayerIcon method, of class PlayerIconController.
     */
    @Test
    public void testchangePlayerIcon() {
        System.out.println("changePlayerIcon");

        PlayerIconController.changePlayerIcon(1, 2);
        PlayerIconController.changePlayerIcon(1, 1);
    }
    
    /**
     * Test of testcreatePlayer method, of class PlayerIconController.
     */
    @Test
    public void testcreatePlayer() {
        System.out.println("createPlayer");
        Player testPlayer = PlayerIconController.createPlayer("RONGEN");
        Player expResult = new Player(2, "RONGEN", 1, 150, 140, 20, 10);
        
        assertEquals(expResult.getUsername(), testPlayer.getUsername());
        assertEquals(expResult.getIconId(), testPlayer.getIconId());
        assertEquals(expResult.getRating(), testPlayer.getRating());
        assertEquals(expResult.getWins(), testPlayer.getWins());
        assertEquals(expResult.getLosses(), testPlayer.getLosses());
    }

    /**
     * Test of testcheckIfPlayerExists method, of class PlayerIconController.
     */
    @Test
    public void testcheckIfPlayerExists() {
        System.out.println("playerExists");
        assertEquals(PlayerIconController.signUpPlayer("", "RONGEN", "", ""), 2);
        assertEquals(PlayerIconController.signUpPlayer("", "TEST", "", ""), 3);
    }

    /**
     * Test of signUpPlayer method, of class PlayerIconController.
     */
    @Test
    public void testSignUpPlayer() {
        System.out.println("signupPlayer");
        assertEquals(PlayerIconController.signUpPlayer("", "RONGEN", "", "NOPE"), 1);
        assertEquals(PlayerIconController.signUpPlayer("", "RONGEN", "", ""), 2);
        assertEquals(PlayerIconController.signUpPlayer("", "RONG", "", ""), 3);
    }

    /**
     * Test of logInPlayer method, of class PlayerIconController.
     */
    @Test
    public void testLogInPlayer() {
        System.out.println("logInPlayer");
        Player testPlayer = PlayerIconController.logInPlayer("RONGEN", "LDASY781EDHEE7SJD72");
        Player expResult = new Player(2, "RONGEN", 1, 150, 140, 20, 10);
        
        assertEquals(expResult.getUsername(), testPlayer.getUsername());
        assertEquals(expResult.getIconId(), testPlayer.getIconId());
        assertEquals(expResult.getRating(), testPlayer.getRating());
        assertEquals(expResult.getWins(), testPlayer.getWins());
        assertEquals(expResult.getLosses(), testPlayer.getLosses());
        
        testPlayer = PlayerIconController.logInPlayer("RONG", "LDASY781EDHEE7SJD72");
        assertNull(testPlayer);
        
        testPlayer = PlayerIconController.logInPlayer("RONGEN", "NOPE");
        assertNull(testPlayer);
    }

    /**
     * Test of getIcons method, of class PlayerIconController.
     */
    @Test
    public void testGetIcons() {
        System.out.println("getIcons");
        ArrayList<Icon> icons = PlayerIconController.getIcons(5000);
        Icon expResult = new Icon(1, 800, "/Images/I1");
        
        assertEquals(expResult.getId(), icons.get(0).getId());
        assertEquals(expResult.getRatingLock(), icons.get(0).getRatingLock());
        assertEquals(expResult.getFileName(), icons.get(0).getFileName());
    }

}
