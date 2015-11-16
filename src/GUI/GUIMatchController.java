/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.CardDeckController;
import Mighty_Cards.Domain.Card;
import Mighty_Cards.Domain.GameState;
import Mighty_Cards.Domain.HeroCard;
import Mighty_Cards.Domain.Match;
import Mighty_Cards.Domain.Player;
import Sound.AudioPlayerMightyDuels;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Matthijs
 */
public class GUIMatchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    GridPane gridPlayedCards;
    @FXML
    GridPane gridChooseCard;
    @FXML
    GridPane gridYourSide;
    @FXML
    GridPane gridOpponentSide;

    private Stage stage;
    private Parent root;

    private ArrayList<HeroCard> cards;
    private ArrayList<HeroCardControl> heroCardControls;
    private boolean yourCardPlayed = false;
    private HeroControl yourHero;
    private HeroControl opponentsHero;

    private Player player_1;
    private Player player_2;

    private Match match;

    //Variables for playing sound.
    private AudioPlayerMightyDuels audioPlayer;

    private String endTurnSoundFilePath;
    private String healSoundFilePath;
    private String magicalAttackSoundFilePath;
    private String magicalBlockSoundFilePath;
    private String minionSoundFilePath;
    private String physicalAttackSoundFilePath;
    private String physicalBlockSoundFilePath;
    private String startTurnSoundFilePath;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        heroCardControls = new ArrayList<>();
        cards = new ArrayList<>();
        InitialiseHeroes();
        match = new Match(player_1);
        match.addPlayer2(player_2);

        CardDeckController cdc = new CardDeckController();
        for (Card card : CardDeckController.getAllCards()) {
            if (card instanceof HeroCard) {
                cards.add((HeroCard) card);
            }
        }

        audioPlayer = new AudioPlayerMightyDuels();

        endTurnSoundFilePath = "src/Sound/endTurn.wav";
        healSoundFilePath = "src/Sound/heal.wav";
        magicalAttackSoundFilePath = "src/Sound/magicalAttack.wav";
        magicalBlockSoundFilePath = "src/Sound/magicalBlock.wav";
        minionSoundFilePath = "src/Sound/minion.wav";
        physicalAttackSoundFilePath = "src/Sound/physicalAttack.wav";
        physicalBlockSoundFilePath = "src/Sound/physicalBlock.wav";
        startTurnSoundFilePath = "src/Sound/startTurn.wav";
        
        drawCards();
    }

    public void InitialiseHeroes() {
        player_1 = mightyduels.MightyDuels.loggedInPlayer;
        player_2 = new Player(2, player_1.getUsername() + "Clone".toUpperCase(), player_1.getIconId(), player_1.getRating(), player_1.getWins(), player_1.getLosses(), player_1.getMatches());// TODO

        Random random = new Random();

        yourHero = new HeroControl(50, player_1);
        gridYourSide.add(yourHero.getHeroControl(), 0, 0);

        opponentsHero = new HeroControl(50, player_2);
        gridOpponentSide.add(opponentsHero.getHeroControl(), 4, 0);

        ImageView imageViewYourDeck = new ImageView("/Images/card stack.png");
        ImageView imageViewOpponentsDeck = new ImageView("/Images/card stack.png");

        gridYourSide.add(imageViewYourDeck, 4, 0);
        gridOpponentSide.add(imageViewOpponentsDeck, 0, 0);
    }

    private void drawCards() {
        Random random = new Random();
        heroCardControls.clear();

        for (int i = 0; i < 3; i++) {
            int count = i;

            boolean added = false;

            while (!added) {
                HeroCardControl control = new HeroCardControl(cards.get(random.nextInt(cards.size())), 180);
                if (!heroCardControls.contains(control)) {
                    heroCardControls.add(control);
                    added = true;
                }
            }

            EventHandler handler = new EventHandler() {
                StackPane pane = heroCardControls.get(count).HeroCardControlPane();

                @Override
                public void handle(Event event) {
                    if (!yourCardPlayed) {
                        yourCardPlayed = true;

                        gridYourSide.add(pane, 2, 0);
                        gridYourSide.setAlignment(Pos.BASELINE_LEFT);
                        gridChooseCard.getChildren().clear();
                        match.getHero1().setCardPlayed((Card) heroCardControls.get(count).getHeroCard());
                        match.getHero1().setFinished(true);
                        drawCards();
                    } else if (yourCardPlayed) {

                        yourCardPlayed = false;

                        gridOpponentSide.add(pane, 2, 0);
                        boolean proceed = false;

                        if (gridOpponentSide.getChildren().contains(pane)) {
                            proceed = true;
                        }
                        gridChooseCard.getChildren().clear();

                        match.getHero2().setCardPlayed((Card) heroCardControls.get(count).getHeroCard());
                        match.getHero2().setFinished(true);

                        Thread t = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    match.startTurn();

                                    Platform.runLater(() -> {

                                        yourHero.setHealth(match.getHero1().getHitPoints());
                                        opponentsHero.setHealth(match.getHero2().getHitPoints());

                                    });
                                    sleep(2000);
                                    Platform.runLater(() -> {
                                        gridYourSide.getChildren().remove(2);
                                        gridOpponentSide.getChildren().remove(2);
                                        drawCards();
                                    });

                                    // Determine Gamestate
                                    if (match.getGameState() == GameState.Defined || match.getGameState() == GameState.Tie) {
                                        if (match.getHero1().getHitPoints() <= 0 && match.getHero2().getHitPoints() <= 0) {
                                            Platform.runLater(() -> {
                                                JOptionPane.showMessageDialog(null, "It's a tie between " + player_1.getUsername() + " and " + player_2.getUsername() + ".", "Tie", JOptionPane.PLAIN_MESSAGE);
                                                backToMainScreen();
                                            });

                                        } else if (match.getHero1().getHitPoints() <= 0) {
                                            Platform.runLater(() -> {
                                                JOptionPane.showMessageDialog(null, player_2.getUsername() + " is victorious!", "Victory", JOptionPane.PLAIN_MESSAGE);
                                                backToMainScreen();
                                            });
                                        } else if (match.getHero2().getHitPoints() <= 0) {
                                            Platform.runLater(() -> {
                                                JOptionPane.showMessageDialog(null, player_1.getUsername() + " is victorious!", "Victory", JOptionPane.PLAIN_MESSAGE);
                                                backToMainScreen();
                                            });

                                        }
                                    }

                                } catch (InterruptedException ex) {
                                    Logger.getLogger(GUIMatchController.class
                                            .getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        };
                        t.start();
                    }
                }
            };
            heroCardControls.get(count).setEventHandler(handler);
            gridChooseCard.add(heroCardControls.get(i).HeroCardControlPane(), i, 0);
        }
    }

    private void backToMainScreen() {
        try {
            String title = "Mighty Duels";
            stage = (Stage) gridChooseCard.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainScreenFXML.fxml"));
            mightyduels.MightyDuels.navigate(stage, root, title);

        } catch (IOException ex) {
            Logger.getLogger(GUIMatchController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
