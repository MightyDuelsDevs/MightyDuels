/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Mighty_Cards.Domain.Player;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

/**
 * FXML Controller class
 *
 * @author Stan
 */
public class RegisterFXMLController implements Initializable {

    private Stage stage;
    private Parent root;

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfPassWord;

    @FXML
    private TextField tfPassWordRe;

    @FXML
    private Button btnRegisterAccount;

    Player player;
    private ArrayList<String> usernames;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Load all the Usernames from the accounts from the database into a List.
        usernames = new ArrayList<>();
        //Player stan = new Player("Stanniez", "ss");
        //Test
        usernames.add("Stanniez");
        //usernames = database .. .. .. .. (To get all the Usernames);
    }

    /**
     * Adds the account to the database and goes to the MainScreen if everything is filled in correctly.
     * Fields are correct: 
     *  If both Fields are filled.
     *  If the Username is unique.
     *  If the two password fields are the same.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void btnRegisterAccount_OnClick(ActionEvent event) throws IOException {
        //Check  if  the UserName already exists
        //If not, Check if the 2 inserted passwords match. If they do, Make the Account.
        if (tfUserName.getText().isEmpty() || tfPassWord.getText().isEmpty() || tfPassWordRe.getText().isEmpty()) {
            System.out.println("You have to fill both fields.");
            return;
        } else {

            player = new Player(tfUserName.getText(), tfPassWord.getText());
        }
        
        if (usernames.contains(player.getUsername())) {
            System.out.println("Account already exists in the datbase.");
        } else if (!tfPassWord.getText().equals(tfPassWordRe.getText())) {
            System.out.println("The two inserted passwords do NOT match.");
        } else {
            System.out.println("Account succesfully registered");
            //Add the Player to the database.
            // db.addPlayer(player);
            stage = (Stage) btnRegisterAccount.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainScreenFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
