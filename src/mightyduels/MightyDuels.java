/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mightyduels;

import Server.Controller.CardDeckController;
import Server.Controller.PlayerIconController;
import Client.GUI.LogOn;
import Server.Domain.Game;
import Server.Domain.Player;
import java.awt.SplashScreen;
import java.sql.SQLException;
import java.util.logging.Logger;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author rick-
 */
public class MightyDuels {

    private static final Logger log = Logger.getLogger(MightyDuels.class.getName());

    public static Player loggedInPlayer = null; //TODO <- not this
    public static Game game;//TODO <- not this

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        log.info("Starting MightyDuels client application");
        log.info("Initialising database");
        Server.Database.Database.openConnection();
        try {
            if (!Server.Database.Database.checkConnection()) {
                log.severe("Connection was not opened!");
                log.severe("Exiting...");
                System.exit(1000);
            }
        } catch (SQLException ex) {
            log.severe("Database threw an exception!");
            log.severe(ex.toString());
            log.severe("Exiting....");
            System.exit(1001);
        }
        log.info("Creating Game instance");
        game = new Game();
        log.info("Creating CardDeckController");
        CardDeckController.cardDeckControllerInit();
        log.info("Creating PlayerIconController");
        PlayerIconController.playerIconControllerInit();
        log.info("Starting main application");
        SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash != null) {
            splash.close();
        }
        LogOn.main(args);
    }

    /**
     * Navigate to another scene
     * @param stage the source stage
     * @param root the root scene
     * @param title the window title
     */
    public static void navigate(Stage stage, Parent root, String title) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        title = title == null ? "Mighty Duels" : title;
        stage.setTitle(title);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

}
