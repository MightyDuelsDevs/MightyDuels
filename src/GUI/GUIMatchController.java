/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.CardDeckController;
import Mighty_Cards.Domain.Card;
import Mighty_Cards.Domain.HeroCard;
import Mighty_Cards.Domain.Match;
import Mighty_Cards.Domain.Player;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Matthijs
 */
public class GUIMatchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML GridPane gridPlayedCards;
    @FXML GridPane gridChooseCard;
    @FXML GridPane gridYourSide;
    @FXML GridPane gridOpponentSide;
    
    private ArrayList<HeroCard> cards;
    private ArrayList<HeroCardControl> heroCardControls;
    private boolean yourCardPlayed = false;
    private HeroControl yourHero;
    private HeroControl opponentsHero;
    
    private Player player_1;
    private Player player_2;
    
    private Match match;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        heroCardControls = new ArrayList<>();
        cards = new ArrayList<>();
        InitialiseHeroes();
        match = new Match(player_1);
        match.addPlayer2(player_2);
        
        for(Card card : CardDeckController.getAllCards()){
            if(card instanceof HeroCard){
                cards.add((HeroCard)card);
            }
        }
        
        drawCards();
    }    
    
    public void InitialiseHeroes(){
        player_1 = new Player(1, "Stan", 1, 1, 0, 0, 0);
        player_2 = new Player(2, "Ramòn", 2, 2, 0, 0, 0);
        
        Random random = new Random();
        
        yourHero = new HeroControl(50,player_1);
        gridYourSide.add(yourHero.getHeroControl(), 0, 0);
        
        opponentsHero = new HeroControl(50,player_2);
        gridOpponentSide.add(opponentsHero.getHeroControl(), 4, 0);
        
        ImageView imageViewYourDeck = new ImageView("/Images/card stack.png");
        ImageView imageViewOpponentsDeck = new ImageView("/Images/card stack.png");
        
        gridYourSide.add(imageViewYourDeck, 4, 0);
        gridOpponentSide.add(imageViewOpponentsDeck, 0, 0);
    }
    
    private void drawCards(){
        Random random = new Random();
        heroCardControls.clear();
        
        for(int i = 0; i <3;i++){
            int count = i;
                        
            
            boolean added = false;
            
            while(!added){
                HeroCardControl control = new HeroCardControl(cards.get(random.nextInt(cards.size())), 180); 
                if(!heroCardControls.contains(control)){
                    heroCardControls.add(control);
                    added = true;
                }
            }

            EventHandler handler = new EventHandler() {
                StackPane pane = heroCardControls.get(count).HeroCardControlPane();

                @Override
                    public void handle(Event event) {
                        if(!yourCardPlayed){
                            yourCardPlayed = true;

                            gridYourSide.add(pane, 1, 0);
                            gridChooseCard.getChildren().clear();
                            match.getHero1().setCardPlayed((Card)heroCardControls.get(count).getHeroCard());
                            match.getHero1().setFinished(true);
                            drawCards();
                        }
                        else if(yourCardPlayed){
                            
                            yourCardPlayed = false;

                            gridOpponentSide.add(pane, 1, 0);
                            boolean proceed = false;
                            while(!proceed){
                                if(gridOpponentSide.getChildren().contains(pane)){
                                    proceed = true;
                                }
                            }
                            gridChooseCard.getChildren().clear();

                            match.getHero2().setCardPlayed((Card)heroCardControls.get(count).getHeroCard());
                            match.getHero2().setFinished(true);
                            
                            match.startTurn();

                            
                            gridYourSide.getChildren().remove(2);
                            gridOpponentSide.getChildren().remove(2);
                            
                            yourHero.setHealth(match.getHero1().getHitPoints());
                            opponentsHero.setHealth(match.getHero1().getHitPoints());
                            drawCards();
                        }
                    }
                };
            heroCardControls.get(count).setEventHandler(handler);
            gridChooseCard.add(heroCardControls.get(i).HeroCardControlPane(), i, 0);
        }
    }
}
