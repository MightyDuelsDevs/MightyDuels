/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
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
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class DeckFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Parent root;

    @FXML
    private RadioButton rbDeck1;

    @FXML
    private RadioButton rbDeck2;

    @FXML
    private RadioButton rbDeck3;

    @FXML
    private RadioButton rbDeck4;

    @FXML
    private ImageView ivDeck1;

    @FXML
    private ImageView ivDeck2;

    @FXML
    private ImageView ivDeck3;

    @FXML
    private ImageView ivDeck4;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPlay;

    @FXML
    private ImageView ivSelectedDeck;

    //Set the right deck as 'selected' into the database when pressed on 'Play'.
    @FXML
    private void btnPlay_OnClick(ActionEvent event) throws IOException {
        stage = (Stage) btnPlay.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreenFXML.fxml")); // Change to DuelScreen
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
        stage.setTitle("Mighty Duels");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Load the ImageView with the available Decks.
        //Get the selected deck from the database. // Show the 'Selected' Deck (with radioButton)
        //TODO Check the one who is selected through the Database;
        rbDeck3.setSelected(true);
        File file = new File("src/GUI/Stannis_S05E09.png"); // Get the image from the Database.
        Image image = new Image(file.toURI().toString());
        ivDeck1.setImage(image);
        //Look which one is selected
        if (rbDeck1.isSelected()) {
            ivSelectedDeck.setImage(ivDeck1.getImage());
        } else if (rbDeck2.isSelected()) {
            ivSelectedDeck.setImage(ivDeck2.getImage());
        } else if (rbDeck3.isSelected()) {
            ivSelectedDeck.setImage(ivDeck3.getImage());
        } else if (rbDeck4.isSelected()) {
            ivSelectedDeck.setImage(ivDeck4.getImage());
        }
//        ivSelectedDeck.setImage(image);
    }

}
