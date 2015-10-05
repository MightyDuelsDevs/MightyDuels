package Mighty_Cards;

import java.util.ArrayList;

public class Deck {

	private String name;
        
        public Deck()
        {
            
        }
        
        public Deck(String name)
        {
            this.name = name;
        }

	/**
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		// TODO - implement Deck.addCard
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public void removeCard(Card card) {
		// TODO - implement Deck.removeCard
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Card> getCards() {
		// TODO - implement Deck.getCards
		throw new UnsupportedOperationException();
	}

}