/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.PlayerIconController;
import Mighty_Cards.Domain.Icon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
//
import Mighty_Cards.Domain.Player;
import java.util.ArrayList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class AccountFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Parent root;
    private PlayerIconController playerIconController;
    private Player loggedInPlayer;

    @FXML
    private Label lblAccountName;

    @FXML
    private Label lblAmountOfGames;

    @FXML
    private Label lblAmountOfWins;

    @FXML
    private Label lblAmountOfLosses;

    @FXML
    private Label lblTheRating;

    @FXML
    private GridPane gpIcons;

    @FXML
    private Button btnSaveIcon;

    @FXML
    private Button btnBack;

    private ArrayList<Icon> icons;

    @FXML
    private void btnSaveIcon_OnClick(ActionEvent event) throws IOException {
        // Set the selected icon into the database.
        stage = (Stage) btnSaveIcon.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreenFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Mighty Duels");
    }

    @FXML
    private void btnBack_OnClick(ActionEvent event) throws IOException {
        stage = (Stage) btnBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreenFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loggedInPlayer = playerIconController.getLoggedInPlayer();
        lblAccountName.setText(loggedInPlayer.getUsername());
        lblAmountOfGames.setText("" + loggedInPlayer.getMatches());
        lblAmountOfWins.setText("" + loggedInPlayer.getWins());
        lblAmountOfLosses.setText("" + loggedInPlayer.getLosses());
        lblTheRating.setText("" + loggedInPlayer.getRating());

        // Load all the Icons from the Database. Set them into a list.
        icons = playerIconController.getIcons(loggedInPlayer.getRating());

        final ToggleGroup tg = new ToggleGroup();
        int l = 1;
        int i = 0;
        int j = 0;
        for (Icon icon : icons) {
            RadioButton rbIcon = new RadioButton("Icon " + l);
            rbIcon.setToggleGroup(tg);
            //rbIcon.setHAlignment(Pos.BOTTOM_CENTER);
            gpIcons.add(rbIcon, i, j);

            i++;
            l++;
            if (i == 3) {
                j++;
                i = 0;
            }
        }
    }
}
