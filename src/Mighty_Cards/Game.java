package Mighty_Cards;

import java.util.ArrayList;

public class Game {

    private static Game instance;
    private Render render;
    private ArrayList<Icon> icons;
    private ArrayList<Card> cards;
    private Player player;
    private Match match;

    private Game() {
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
     * @param username
     * @param password
     * @return player
     */
    public Player login(String username, String password) {
        return this.player;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     *
     * @param username
     * @param password
     * @return boolean
     */
    public boolean register(String username, String password) {
        return false;
    }

    /**
     *
     * @param player
     * @return match
     */
    public Match startMatch(Player player) {
        return this.match;
    }

}
