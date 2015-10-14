package Mighty_Cards.Domain;

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
     * @param iconId
     * @param rating
     * @param wins
     * @param losses
     */
    /*
     Moet er een methode komen die het wachtwoord wegschrijft naar de database? 
     Of willen we het wachtwoord opslaan op de player?
     */
    public Player(String username, int iconId, int rating, int wins, int losses) /* throws UnkownUsername, IncorrectPassword */ {
        this.username = username;
        this.iconId = iconId;
        this.wins = wins;
        this.losses = losses;
        this.rating = rating;
    }

    /**
     * Returns the username of the player
     *
     * @return
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the IconID of the player
     *
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
     *
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
     *
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
     *
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
     *
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
     */
    public void changeIcon(Icon icon) {
        this.iconId = icon.getId();
    }

    @Override
    public String toString() {
        return "Username: " + this.getUsername() + " IconID: " + this.getIconId() + " Rating: " + this.getRating() + " Wins: " + this.getWins() + " Losses: " + this.getLosses();
    }

}
