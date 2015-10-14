/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Mighty_Cards.Domain.Card;
import Mighty_Cards.Domain.HeroCard;
import Mighty_Cards.Domain.MinionCard;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martijn van Buul
 */
public class CardDeckController {

    ArrayList<Card> allCards;

    public CardDeckController() {
        allCards = getAllCards();
        
        for(Card card : allCards){
            System.out.println(card.getName());
        }
    }

    private ArrayList<Card> getAllCards() {
        String statement = "SELECT * FROM CARD";
        ArrayList<Card> cards = new ArrayList<>();
        int rowCount = 0;

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
}
