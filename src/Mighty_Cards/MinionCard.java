package Mighty_Cards;

public abstract class MinionCard extends Card {

	private int physicalDamage;
	private int magicalDamage;
	private int hitPoints;

	public int getPhysicalDamage() {
		return this.physicalDamage;
	}

	public int getMagicalDamage() {
		return this.magicalDamage;
	}

	public int getHitPoints() {
		return this.hitPoints;
	}

	/**
	 * 
	 * @param physicalDamage
	 * @param magicalDamage
	 * @param hitPoints
	 */
	public MinionCard(int physicalDamage, int magicalDamage, int hitPoints) {
		// TODO - implement MinionCard.MinionCard
		throw new UnsupportedOperationException();
	}

}