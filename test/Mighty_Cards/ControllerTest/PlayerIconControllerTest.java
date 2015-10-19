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

/**
 *
 * @author Ramòn Janssen
 */
public class PlayerIconControllerTest {

    public PlayerIconControllerTest() {
    }

    /**
     * Test of testcreateIcons method, of class PlayerIconController.
     */
    @Test
    public void testcreateIcons() {
        System.out.println("createIcons");
        String email = "";
        String displayname = "";
        String password = "";
        String passcheck = "";
        PlayerIconController instance = new PlayerIconController();
        int expResult = 0;
        int result = instance.signUpPlayer(email, displayname, password, passcheck);
        assertEquals(expResult, result);
    }

    /**
     * Test of testcreatePlayer method, of class PlayerIconController.
     */
    @Test
    public void testcreatePlayer() {
        System.out.println("createPlayer");
        String email = "";
        String displayname = "";
        String password = "";
        String passcheck = "";
        PlayerIconController instance = new PlayerIconController();
        int expResult = 0;
        int result = instance.signUpPlayer(email, displayname, password, passcheck);
        assertEquals(expResult, result);
    }

    /**
     * Test of testcheckIfPlayerExists method, of class PlayerIconController.
     */
    @Test
    public void testcheckIfPlayerExists() {
        System.out.println("checkIfPlayerExists");
        String email = "";
        String displayname = "";
        String password = "";
        String passcheck = "";
        PlayerIconController instance = new PlayerIconController();
        int expResult = 0;
        int result = instance.signUpPlayer(email, displayname, password, passcheck);
        assertEquals(expResult, result);
    }

    /**
     * Test of signUpPlayer method, of class PlayerIconController.
     */
    @Test
    public void testSignUpPlayer() {
        System.out.println("signUpPlayer");
        String email = "";
        String displayname = "";
        String password = "";
        String passcheck = "";
        PlayerIconController instance = new PlayerIconController();
        int expResult = 0;
        int result = instance.signUpPlayer(email, displayname, password, passcheck);
        assertEquals(expResult, result);
    }

    /**
     * Test of logInPlayer method, of class PlayerIconController.
     */
    @Test
    public void testLogInPlayer() {
        System.out.println("logInPlayer");
        String displayname = "";
        String password = "";
        PlayerIconController instance = new PlayerIconController();
        Player expResult = null;
        Player result = instance.logInPlayer(displayname, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIcons method, of class PlayerIconController.
     */
    @Test
    public void testGetIcons() {
        System.out.println("getIcons");
        int rating = 0;
        PlayerIconController instance = new PlayerIconController();
        ArrayList<Icon> expResult = null;
        ArrayList<Icon> result = instance.getIcons(rating);
        assertEquals(expResult, result);
    }

}
