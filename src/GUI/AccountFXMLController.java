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
import javafx.geometry.HPos;
//
import Mighty_Cards.Domain.Player;
import java.io.File;
import java.util.ArrayList;
import javafx.geometry.VPos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class AccountFXMLController implements Initializable {

    private Stage stage;
    private Parent root;
    private final PlayerIconController playerIconController = new PlayerIconController();
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

    private ArrayList<Icon> icons = new ArrayList<>();

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
        lblAccountName.setText(" " + loggedInPlayer.getUsername());
        lblTheRating.setText(" " + loggedInPlayer.getRating());
        lblAmountOfGames.setText(" " + loggedInPlayer.getMatches());
        lblAmountOfWins.setText(" " + loggedInPlayer.getWins());
        lblAmountOfLosses.setText(" " + loggedInPlayer.getLosses());

        // Load all the Icons from the Database. Set them into a list.
        icons = playerIconController.getIcons(loggedInPlayer.getRating());

        final ToggleGroup tg = new ToggleGroup();
        int l = 1;
        int i = 0;
        int j = 0;
        for (Icon icon : icons) {
            // Icon Image
            File file = new File(icon.getFileName());
            Image image = new Image(file.toURI().toString());
            ImageView ivIcon = new ImageView(image);
            gpIcons.setHalignment(ivIcon, HPos.CENTER);
            gpIcons.add(ivIcon, i, j);
            // Icon RadioButton
            String iconID = "" + (l < 10 ? " " + l : l);
            RadioButton rbIcon = new RadioButton("Icon " + iconID);
            rbIcon.setToggleGroup(tg);
            gpIcons.setHalignment(rbIcon, HPos.CENTER);
            gpIcons.setValignment(rbIcon, VPos.BOTTOM);
            gpIcons.add(rbIcon, i, j);

            i++;
            l++;
            if (i == 4) {
                j++;
                i = 0;
            }
        }
    }
}
