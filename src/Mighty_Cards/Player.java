package Mighty_Cards;

public class Player {

	private String username;
	private int iconId;
	private int rating;
	private int matches;
	private int wins;
	private int loses;

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public Player(String username, String password) throws UnkownUsername, IncorrectPassword {
		// TODO - implement Player.Player
		throw new UnsupportedOperationException();
	}

	public String getUsername() {
		return this.username;
	}

	public int getIconId() {
		return this.iconId;
	}

	/**
	 * 
	 * @param iconId
	 */
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}

	public int getRating() {
		return this.rating;
	}

	/**
	 * 
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getMatches() {
		return this.matches;
	}

	public int getWins() {
		return this.wins;
	}

	public void setWins() {
		// TODO - implement Player.setWins
		throw new UnsupportedOperationException();
	}

	public int getLoses() {
		return this.loses;
	}

	public void setLoses() {
		// TODO - implement Player.setLoses
		throw new UnsupportedOperationException();
	}

	public Icon changeIcon() {
		// TODO - implement Player.changeIcon
		throw new UnsupportedOperationException();
	}

}