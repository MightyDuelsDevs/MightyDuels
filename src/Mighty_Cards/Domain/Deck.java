package Mighty_Cards.Domain;

import java.util.ArrayList;

public class Deck {

	private String name;
        private ArrayList<Card> cards;
        
        private int first;
        private int last;
        
        public Deck()
        {
            cards = new ArrayList<>();
        }
        
        public Deck(String name)
        {
            this.name = name;
            cards = new ArrayList<>();
        }

	/**
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
            first = cards.indexOf(card);
            last = cards.lastIndexOf(card);
            if(first == last)
            {
                cards.add(card);
            }
	}

	/**
	 * 
	 * @param card
	 */
	public void removeCard(Card card) {
            cards.remove(card);
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
            return this.cards;
	}

}