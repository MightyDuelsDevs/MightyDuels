/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mightyduels;

import Controller.*;
import Mighty_Cards.Domain.Player;

/**
 *
 * @author rick-
 */
public class MightyDuels {

    public static Player loggedInPlayer = null; //TODO <- not this

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CardDeckController();
        new PlayerIconController();
    }
    

}
