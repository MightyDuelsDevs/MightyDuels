/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Mighty_Cards.Domain.Icon;
import Mighty_Cards.Domain.Player;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramòn Janssen
 */
public class PlayerIconController {

    private final ArrayList<Icon> icons;
    private final ArrayList<Player> players;

    public PlayerIconController() {
        this.icons = new ArrayList<>();
        this.players = new ArrayList<>();
        createIcons();

        //Tests
        createPlayer("Janssen");
        for (Icon foo : icons) {
            System.out.println("" + foo.getFileName());
        }
        for (Icon foo : this.getIcons(1500)) {
            System.out.println(foo.getFileName() + " " + foo.getRatingLock());
        }
        for (Player foo : players) {
            System.out.println(foo.toString());
        }
    }

    /**
     * Function that gets all excisting icons from the database This function
     * fills the ArrayList of Icon 'icons'
     */
    private void createIcons() {
        String statement = "SELECT * FROM ICON";
        int rowCount = 0;
        try {
            if (Database.checkConnection()) {
                ArrayList<ArrayList> resultSet = Database.selectRecordFromTable(statement);

                for (ArrayList<String> column : resultSet) {
                    int id = Integer.parseInt(column.get(0));
                    int ratingLock = Integer.parseInt(column.get(1));
                    String fileName = column.get(2);

                    icons.add(new Icon(id, ratingLock, fileName));
                }
            } else {
                System.out.println("Database connection is lost.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Function to check if a displayname already exists
     *
     * @param displayname input username for the player
     * @return boolean true if there is nu existing player with the same
     * displayname. False if there is an existing player.
     */
    private boolean checkIfPlayerExists(String displayname) {
        String statement = "SELECT * FROM PLAYER WHERE DISPLAYNAME = '" + displayname.toUpperCase() + "'";
        try {
            if (Database.checkConnection()) {
                ArrayList<ArrayList> resultSet = Database.selectRecordFromTable(statement);
                if (resultSet.isEmpty()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Function to sign up
     *
     * @param email
     * @param displayname
     * @param password
     * @param passcheck
     * @return Returns an int that has the following values: 0 = unexpected
     * error. 1 = passcheck is not the same as password. 2 = username already in
     * use. 3 = succesfully created a new player!
     */
    public int signUpPlayer(String email, String displayname, String password, String passcheck) {
        String statement = "INSERT INTO PLAYER(ID, ICONID, EMAIL, DISPLAYNAME, PASSWORD, RATING, MATCHES, WINS, LOSSES) VALUES (null, 1, '"
                + email + "','" + displayname.toUpperCase() + "','" + password + "',1200,0,0,0)";
        try {
            if (!password.equals(passcheck)) {
                return 1;
            }
            if (Database.checkConnection()) {
                if (checkIfPlayerExists(displayname.toUpperCase())) {
                    Database.insertRecordIntoTable(statement);
                    return 3;
                } else {
                    System.out.println("Displayname is already in use!");
                    return 2;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }

    /**
     * Function to Login
     *
     * @param displayname
     * @param password
     * @return Player the player information from the person that just logged
     * in.
     */
    public Player logInPlayer(String displayname, String password) {
        Player player = null;
        String statement = "SELECT * FROM PLAYER WHERE DISPLAYNAME = '" + displayname.toUpperCase() + "' AND PASSWORD = '" + password + "'";
        try {
            if (Database.checkConnection()) {
                ArrayList<ArrayList> resultSet = Database.selectRecordFromTable(statement);
                if (!resultSet.isEmpty()) {
                    createPlayer(displayname);
                    for (Player foo : players) {
                        if ((foo.getUsername().toUpperCase()).equals(displayname.toUpperCase())) {
                            player = foo;
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return player;
    }

    /**
     * Creates a new player object from the database and puts it in a list for
     * future refference
     *
     * @param displayname
     */
    private void createPlayer(String displayname) {
        String statement = "SELECT * FROM PLAYER WHERE DISPLAYNAME = '" + displayname.toUpperCase() + "'";
        try {
            if (Database.checkConnection()) {
                ArrayList<ArrayList> resultSet = Database.selectRecordFromTable(statement);

                for (ArrayList<String> column : resultSet) {
                    String username = column.get(3);
                    int iconId = Integer.parseInt(column.get(1));
                    int rating = Integer.parseInt(column.get(5));
                    int wins = Integer.parseInt(column.get(7));
                    int losses = Integer.parseInt(column.get(8));
                    int matches = Integer.parseInt(column.get(6));

                    players.add(new Player(username, iconId, rating, wins, losses, matches));
                }
            } else {
                System.out.println("Database connection is lost.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerIconController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Function to get all the current unlocked icons
     *
     * @param rating Current rating of the player
     * @return Returnes all unlocked icons according to rating
     */
    public ArrayList<Icon> getIcons(int rating) {
        ArrayList<Icon> unlockedIcons = new ArrayList<>();
        for (Icon icon : icons) {
            if (icon.getRatingLock() <= rating) {
                unlockedIcons.add(icon);
            }
        }
        return unlockedIcons;
    }

    /**
     * Function to get the logged in player
     *
     * @return Returnes the logged in player
     */
    public Player getLoggedInPlayer() {
        return players.get(0);
    }

}
