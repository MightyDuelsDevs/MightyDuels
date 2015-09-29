package Mighty_Cards;

import java.util.ArrayList;

public class Game {

	private Game instance;
	private Render render;

	private Game() {
		// TODO - implement Game.Game
		throw new UnsupportedOperationException();
	}

	public ArrayList<Icon> getIcon() {
		// TODO - implement Game.getIcon
		throw new UnsupportedOperationException();
	}

	/**
	 * return instance??instance=new game();
	 */
	public Game getInstance() {
		return this.instance;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public Player login(String username, String password) {
		// TODO - implement Game.login
		throw new UnsupportedOperationException();
	}

	public ArrayList<Card> getCards() {
		// TODO - implement Game.getCards
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean register(String username, String password) {
		// TODO - implement Game.register
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param player
	 */
	public Match startMatch(Player player) {
		// TODO - implement Game.startMatch
		throw new UnsupportedOperationException();
	}

}