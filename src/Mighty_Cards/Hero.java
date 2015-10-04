package Mighty_Cards;

import java.util.ArrayList;

public class Hero implements ITarget {

	Match match;
	private int hitPoints = 50;
	private boolean finished;

	/**
	 * 
	 * @param match
	 * @param player
	 * @param deck
	 */
	public Hero(Match match, Player player, Deck deck) {
		// TODO - implement Hero.Hero
		throw new UnsupportedOperationException();
	}

	public Deck getDeck() {
		// TODO - implement Hero.getDeck
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param deck
	 */
	public void setDeck(Deck deck) {
		// TODO - implement Hero.setDeck
		throw new UnsupportedOperationException();
	}

	public boolean getFinished() {
		return this.finished;
	}

	/**
	 * 
	 * @param finished
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public ArrayList<Minion> getMinions() {
		// TODO - implement Hero.getMinions
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param minions
	 */
	public void setMinions(ArrayList<Minion> minions) {
		// TODO - implement Hero.setMinions
		throw new UnsupportedOperationException();
	}

	public ArrayList<Card> getInHand() {
		// TODO - implement Hero.getInHand
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param inHand
	 */
	public void setNewHand(ArrayList<Card> inHand) {
		// TODO - implement Hero.setNewHand
		throw new UnsupportedOperationException();
	}

	public Card getCardPlayed() {
		// TODO - implement Hero.getCardPlayed
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cardPlayed
	 */
	public void setCardPlayed(Card cardPlayed) {
		// TODO - implement Hero.setCardPlayed
		throw new UnsupportedOperationException();
	}

	public void pullCards() {
		// TODO - implement Hero.pullCards
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public boolean playCard(Card card) {
		// TODO - implement Hero.playCard
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param minion
	 */
	public void removeMinion(Minion minion) {
		// TODO - implement Hero.removeMinion
		throw new UnsupportedOperationException();
	}
        
        public int getHitPoints(){
            return hitPoints;
        }
        
        public void SetHitPoints(int hitPoints){
            this.hitPoints = hitPoints;
        }
}