/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class MainScreenFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Parent root;

    @FXML
    private Button btnDuel;

    @FXML
    private Button btnNewDeck;

    @FXML
    private Button btnSpectate;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnLogOut;

    @FXML
    private void btnDuel_OnClick(ActionEvent event) throws IOException {
        // Search for a Match. If that's found, go to the Duel Page (it's logon because there ain't a duel page yet).
        stage = (Stage) btnDuel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LogOnFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnNewDeck_OnClick(ActionEvent event) throws IOException {
        stage = (Stage) btnNewDeck.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("DeckFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnLogOut_OnClick(ActionEvent event) throws IOException {
        stage = (Stage) btnLogOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LogOnFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnAccount_OnClick(ActionEvent event) throws IOException {
        stage = (Stage) btnLogOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("AccountFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Stanniez");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Get the Player which is logged on.
        //Player player = ...
    }

}
