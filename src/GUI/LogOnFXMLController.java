/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.PlayerIconController;
import Mighty_Cards.Domain.Player;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class LogOnFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Parent root;
    private final PlayerIconController playerIconController = new PlayerIconController();

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfPassWord;

    @FXML
    private Button btnLogOn;

    @FXML
    private Button btnRegister;

    /**
     * If the Username already exists, give a message. If the Username and
     * Password do not match. give a message. When The username and password
     * match with the ones in de database, Go to the Mainscreen.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void btnLogOn_OnClick(ActionEvent event) throws IOException {

        if (tfUserName.getText().isEmpty() || tfPassWord.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill both fields.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Player player = playerIconController.logInPlayer(tfUserName.getText(), tfPassWord.getText());
            if (player == null) {
                JOptionPane.showMessageDialog(null, "Username & Password do not match.", "Error", JOptionPane.INFORMATION_MESSAGE);
                tfPassWord.setText("");
            } else {
                mightyduels.MightyDuels.loggedInPlayer = player;
                //Give the player to the next page;
                stage = (Stage) btnLogOn.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("MainScreenFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Mighty Duels Welcome: " + player.getUsername());
            }
        }
    }

    /**
     * Go to the 'Register'-page to register an account.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void btnRegister_OnClick(ActionEvent event) throws IOException {
        stage = (Stage) btnRegister.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Mighty Duels");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
