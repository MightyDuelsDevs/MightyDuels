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
public class LogOnFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Parent root;

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfPassWord;

    @FXML
    private Button btnLogOn;

    @FXML
    private Button btnRegister;

    private ArrayList<String> usernames;
    private ArrayList<Player> players;

    /**
     * If the Username already exists, give a message.
     * If the Username and Password do not match. give a message.
     * When The username and password match with the ones in de database, Go to the Mainscreen.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void btnLogOn_OnClick(ActionEvent event) throws IOException {
        //if(Username in All the Players in the database && Pass doesn't matches the password from this UserName)
        //if(usernames.contains(tfUserName.getText())
//        {
//        System.out.println("Username already exists");
//        } else if(        {
//              System.out.println("Username & Password do not match");
//        } else {
        if (tfUserName.getText().equals("Stanniez") && tfPassWord.getText().equals("ss")) {
            Player player = new Player (tfUserName.getText(),tfPassWord.getText());
            //Give the player to the next page;
            stage = (Stage) btnLogOn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainScreenFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Welcome:  " + tfUserName.getText());
        } else {
            System.out.println("Wrong Username and/or Password");
        }
    }

    /**
     * Go to the 'Register'-page to register an account.
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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Load all the players from the database into list.

        usernames = new ArrayList<>();
        //usernames = db........;
        players = new ArrayList<>();
        //players = db ........;
    }

}
