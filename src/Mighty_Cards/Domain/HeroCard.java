package Mighty_Cards.Domain;

import java.lang.IllegalArgumentException;

public class HeroCard extends Card {

	private int physicalDamage;
	private int magicalDamage;
	private int physicalBlock;
	private int magicalBlock;
	private int healValue;

	/**
	 * Constructor
         * Check if any number that is given as a parameter is a negative value. If so throw an illegalArgumentException
	 * @param physicalDamage The physical strength of a card
	 * @param magicalDamage The magical strength of a card
	 * @param physicalBlock The physical armor that a card gives
	 * @param magicalBlock The magical armor that a card gives
	 * @param healValue The amount that a card heals
	 */
	public HeroCard(String name, String filename, String description, int physicalDamage, int magicalDamage, int physicalBlock, int magicalBlock, int healValue){
		super(name, filename, description);
                testForNegativeValue(physicalDamage);
                testForNegativeValue(magicalDamage);
                testForNegativeValue(physicalBlock);
                testForNegativeValue(magicalBlock);
                testForNegativeValue(healValue);
                
                this.physicalDamage = physicalDamage;
                this.magicalDamage = magicalDamage;
                this.physicalBlock = physicalBlock;
                this.magicalBlock = magicalBlock;
                this.healValue = healValue;
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
         * Get the physical armor that a card gives
         * @return The physical armor that a card gives
         */
	public int getPhysicalBlock() {
		return this.physicalBlock;
	}
        
        /**
         * Get the magical armor that a card gives
         * @return The magical armor that a card gives
         */
	public int getMagicalBlock() {
		return this.magicalBlock;
	}
        
        /**
         * Get the amount that a card heals
         * @return The amount that a card heals
         */
	public int getHealValue() {
		return this.healValue;
	}
}