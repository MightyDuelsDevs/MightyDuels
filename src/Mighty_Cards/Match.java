package Mighty_Cards;

public class Match {

	private int turns;
	private GameState gameState;

	private void determineGameState() {
		// TODO - implement Match.determineGameState
		throw new UnsupportedOperationException();
	}

	private void processTurn() {
		// TODO - implement Match.processTurn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param P1
	 */
	public Match(Player P1) {
		// TODO - implement Match.Match
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param P2
	 */
	public void addPlayer2(Player P2) {
		// TODO - implement Match.addPlayer2
		throw new UnsupportedOperationException();
	}

	public int getTurns() {
		return this.turns;
	}

	public Hero getHero1() {
		// TODO - implement Match.getHero1
		throw new UnsupportedOperationException();
	}

	public Hero getHero2() {
		// TODO - implement Match.getHero2
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param H1
	 */
        //todo remove?
	public void setHero1(Hero H1) {
		// TODO - implement Match.setHero1
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param H2
	 */
        //todo remove?
	public void setHero2(Hero H2) {
		// TODO - implement Match.setHero2
		throw new UnsupportedOperationException();
	}

	public GameState getGameState() {
		return this.gameState;
	}

	/**
	 * 
	 * @param hero
	 */
	public void concede(Hero hero) {
		// TODO - implement Match.concede
		throw new UnsupportedOperationException();
	}

}