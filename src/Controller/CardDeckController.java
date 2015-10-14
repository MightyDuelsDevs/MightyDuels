/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Mighty_Cards.Domain.Card;
import Mighty_Cards.Domain.Deck;
import Mighty_Cards.Domain.HeroCard;
import Mighty_Cards.Domain.MinionCard;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martijn van Buul
 */
public class CardDeckController {

    public static ArrayList<Card> allCards;

    public CardDeckController() {
        allCards = getAllCards();
    }

    private ArrayList<Card> getAllCards() {
        String statement = "SELECT * FROM CARD";
        ArrayList<Card> cards = new ArrayList<>();
        
        try {
            if (Database.checkConnection()) {
                ArrayList<ArrayList> resultSet = Database.selectRecordFromTable(statement);
                
                for(ArrayList<String> column : resultSet){
                    if("HEROCARD".equals(column.get(4))){   
                        
                        String cardName = column.get(1);
                        String fileName = column.get(2);
                        String description = column.get(3);
                        int physicalDamage = Integer.parseInt(column.get(5));
                        int magicalDamage = Integer.parseInt(column.get(6));
                        int physicalBlock = Integer.parseInt(column.get(7));
                        int magicalBlock = Integer.parseInt(column.get(8));
                        int healValue = Integer.parseInt(column.get(9));
                        
                        cards.add(new HeroCard(cardName, fileName, description, physicalDamage, magicalDamage, physicalBlock, magicalBlock, healValue) {});
                    } else {
                        
                        String cardName = column.get(1);
                        String fileName = column.get(2);
                        String description = column.get(3);
                        int physicalDamage = Integer.parseInt(column.get(5));
                        int magicalDamage = Integer.parseInt(column.get(6));
                        int physicalBlock = Integer.parseInt(column.get(7));
                        
                        cards.add(new MinionCard(cardName, fileName, description, physicalDamage, magicalDamage, physicalBlock) {});
                    }
                }
            } else {
                System.out.println("Database connection is lost.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cards;
    }
    
    static public Deck getDeck(int deckID){
        String statement = String.format("SELECT * FROM DECK WHERE ID = %1$s", deckID);
        Deck deck = new Deck();

        try {
            if (Database.checkConnection()) {
                ArrayList<ArrayList> resultSet = Database.selectRecordFromTable(statement);
                ArrayList<String> column = resultSet.get(0);
                
                for(int i = 3; i < column.size(); i++){
                    deck.addCard(allCards.get(Integer.parseInt(column.get(i)) - 1));
                }
                
            } else {
                System.out.println("Database connection is lost.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return deck;
    }
    
    static public ArrayList<Deck> getDecksFromPlayer(int playerID) {
        String statement = String.format("SELECT * FROM DECK WHERE PLAYERID = %1$s", playerID);
        ArrayList<Deck> decks = new ArrayList<>();

        try {
            if (Database.checkConnection()) {
                ArrayList<ArrayList> resultSet = Database.selectRecordFromTable(statement);

                for (ArrayList<String> column : resultSet) {
                    Deck deck = new Deck();
                    
                    for (int i = 3; i < column.size(); i++) {
                        deck.addCard(allCards.get(Integer.parseInt(column.get(i)) - 1));
                    }
                    
                    decks.add(deck);
                }
                
            } else {
                System.out.println("Database connection is lost.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return decks;
    }
}
