package Mighty_Cards;

public abstract class Card {

	private String name;
	private String filename;
	private String description;

	/**
	 * 
	 * @param name
	 * @param filename
	 * @param description
	 */
	public Card(String name, String filename, String description) {
		// TODO - implement Card.Card
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	public String getFilename() {
		return this.filename;
	}

	public String getDescription() {
		return this.description;
	}

}