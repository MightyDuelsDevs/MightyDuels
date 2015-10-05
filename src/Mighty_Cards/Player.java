package Mighty_Cards;


public class Player {

	private String username;
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
	public Player(String username, String password) /* throws UnkownUsername, IncorrectPassword */{
		this.username = username;
                this.iconId = 0;
                this.wins = 0;
                this.losses = 0;
                this.rating = 0;
	}
        /**
         * Returns the username of the player
         */
	public String getUsername() {
		return this.username;
	}
        /**
         * Returns the IconID of the player
         */
	public int getIconId() {
		return this.iconId;
	}

	/**
	 ** Sets the IconID of the player 
	 * @param iconId, Sets the parameter icon id. 
	 */
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
        /**
         * * Returns the Rating of the player
         */
	public int getRating() {
		return this.rating;
	}

	/**
	 * * Sets the rating of the player
	 * @param rating  Sets the rating of the player
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
        /**
         * * Returns the number of matches the player has played
         */
	public int getMatches() {
		return this.matches;
	}
        public void setMatches(int numberofmatches) {
		 if (numberofmatches >= 0){
                this.matches += numberofmatches;
            }
        }
        /**
         * Returns the number of wins te player has made in the past
         */
	public int getWins() {
		return this.wins;
	}
        /**
         * Sets the number op wins of the player
         */
	public void setWins(int numberofwins) {
		wins += numberofwins;
	}
        /**
         * Gets the number of losses the player has made
         */
	public int getLosses() {
		return this.losses;
	}
        /**
         * adds the number of losses the player has made to total.
         * @param number of losses which should be added tot the total
         */
	public void setLoses(int numberoflosses) {
            if (numberoflosses >= 0){
                this.losses += numberoflosses;
            }
        }

    /**
     *
     * @return
     * @param rating 
     */
            public Icon changeIcon(int rating) {
		
		throw new UnsupportedOperationException();
	}
}
