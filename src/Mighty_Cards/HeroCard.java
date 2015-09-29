package Mighty_Cards;

public abstract class HeroCard extends Card {

	private int physicalDamage;
	private int magicalDamage;
	private int physicalBlock;
	private int magicalBlock;
	private int healValue;

	/**
	 * 
	 * @param physicalDamage
	 * @param magicalDamage
	 * @param physicalBlock
	 * @param magicalBlock
	 * @param healValue
	 */
	public HeroCard(String name, String filename, String description, int physicalDamage, int magicalDamage, int physicalBlock, int magicalBlock, int healValue){
		super(name, filename, description);
                // TODO - implement HeroCard.HeroCard
		throw new UnsupportedOperationException();
	}

	public int getPhysicalDamage() {
		return this.physicalDamage;
	}

	public int getMagicalDamage() {
		return this.magicalDamage;
	}

	public int getPhysicalBlock() {
		return this.physicalBlock;
	}

	public int getMagicalBlock() {
		return this.magicalBlock;
	}

	public int getHealValue() {
		return this.healValue;
	}

}