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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    private Button btnAccount;

    @FXML
    private Button btnLogOut;

    @FXML
    private void btnDuel_OnClick(ActionEvent event) throws IOException {
        String title = "Let the Duel begin!!!";
        stage = (Stage) btnDuel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUIMatch.fxml"));
        mightyduels.MightyDuels.navigate(stage, root, title);
    }

    @FXML
    private void btnNewDeck_OnClick(ActionEvent event) throws IOException {
        String title = "Mighty Duels";
        stage = (Stage) btnNewDeck.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("DeckFXML.fxml"));
        mightyduels.MightyDuels.navigate(stage, root, title);
    }

    @FXML
    private void btnLogOut_OnClick(ActionEvent event) throws IOException {
        String title = "Mighty Duels";
        stage = (Stage) btnLogOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LogOnFXML.fxml"));
        mightyduels.MightyDuels.navigate(stage, root, title);
    }

    @FXML
    private void btnAccount_OnClick(ActionEvent event) throws IOException {
        String title = "Mighty Duels";
        stage = (Stage) btnLogOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("AccountFXML.fxml"));
        mightyduels.MightyDuels.navigate(stage, root, title);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
