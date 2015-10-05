package Mighty_Cards;

public class MinionCard extends Card {

	private int physicalDamage;
	private int magicalDamage;
	private int hitPoints;

	/**
	 * Constructor
         * Check if any number that is given as a parameter is a negative value. If so throw an illegalArgumentException
	 * @param physicalDamage The physical strength of a card
	 * @param magicalDamage The magical strength of a card
	 * @param hitPoints The amount of health a minion has 
	 */
	public MinionCard(String name, String filename, String description, int physicalDamage, int magicalDamage, int hitPoints) {
            super(name, filename, description);
                testForNegativeValue(physicalDamage);
                testForNegativeValue(magicalDamage);
                testForNegativeValue(hitPoints);
                
                this.physicalDamage = physicalDamage;    
                this.magicalDamage = magicalDamage;
		this.hitPoints = hitPoints;
	}
        
        /**
         * Get the physical strength of a card
         * @return The physical strength of a card
         */
	public int getPhysicalDamage() {
		return this.physicalDamage;
	}
        
        /**
         * Get the magical strength of a card
         * @return The magical strength of a card
         */
	public int getMagicalDamage() {
		return this.magicalDamage;
	}
        
        /**
         * Get the amount of health a minion has 
         * @return The amount of health a minion has 
         */
	public int getHitPoints() {
		return this.hitPoints;
	}

}