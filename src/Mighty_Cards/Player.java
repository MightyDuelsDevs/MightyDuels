package Mighty_Cards;

public class Player {

    private final String username;
    private int iconId;
    private int rating;
    private int matches;
    private int wins;
    private int losses;

    /**
     *
     * @param username
     * @param password
     */
    /*
     Moet er een methode komen die het wachtwoord wegschrijft naar de database? 
     Of willen we het wachtwoord opslaan op de player?
     */
    public Player(String username, String password) /* throws UnkownUsername, IncorrectPassword */ {
        this.username = username;
        this.iconId = 0;
        this.wins = 0;
        this.losses = 0;
        this.rating = 0;
    }

    /**
     * Returns the username of the player
     * @return 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the IconID of the player
     * @return 
     */
    public int getIconId() {
        return this.iconId;
    }

    /**
     ** Sets the IconID of the player
     *
     * @param iconId, Sets the parameter icon id.
     */
    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    /**
     * * Returns the Rating of the player
     * @return 
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * * Sets the rating of the player
     *
     * @param rating Sets the rating of the player
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * * Returns the number of matches the player has played
     * @return 
     */
    public int getMatches() {
        return this.matches;
    }

    public void setMatches(int numberofmatches) {
        this.matches++;

    }

    /**
     * Returns the number of wins te player has made in the past
     * @return 
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Sets the number op wins of the player
     */
    public void setWins() {
        this.wins++;
    }

    /**
     * Gets the number of losses the player has made
     * @return 
     */
    public int getLosses() {
        return this.losses;
    }

    /**
     * adds the number of losses the player has made to total.
     *
     */
    public void setLoses() {
        this.losses++;
    }

    /**
     *
     * @param icon @param rating
     */
    public void changeIcon(Icon icon) {
        this.iconId = icon.getId();
    }
}
