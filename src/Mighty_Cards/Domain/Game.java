package Mighty_Cards.Domain;

import java.util.ArrayList;

public class Game {

    private static Game instance;
    private Render render;
    private ArrayList<Icon> icons;
    private ArrayList<Card> cards;
    private Player player;
    private Match match;

    public Game() {
        // Exists only to defeat instantiation.        
    }

    public ArrayList<Icon> getIcon() {
        return this.icons;
    }

    /**
     * return instance??instance=new game();
     *
     * @return this game instance
     */
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    /**
     *
     * @param username the player username
     * @param password the player password
     * @return player returns the player that gets logged in
     */
    public Player login(String username, String password) {
        this.player = new Player(0, username, 0, 0, 0, 0, 0); //TODO!!!
        return this.player;
    }

    /**
     *
     * @return the list of 30 cards
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     *
     * @param username the player username
     * @param password the player password
     * @return boolean returns true when the register has succeded and false
     * when the username already exist
     */
    public boolean register(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        Player newplayer = new Player(0, username, 0, 0, 0, 0, 0); //TODO!!!
        return true;
    }

    /**
     *
     * @param player
     * @return match creates a match with the param player
     */
    public Match startMatch(Player player) {
        this.match = new Match(player);
        return this.match;
    }

}
