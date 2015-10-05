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
                this.name = name;
                this.filename = filename;
                this.description = description;
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
        
        protected void testForNegativeValue(int test){
            if(test < 0){
                throw new IllegalArgumentException();
            }
        }
}