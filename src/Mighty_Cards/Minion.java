package Mighty_Cards;

public class Minion implements ITarget {

	private int physicalDamage;
	private int magicalDamage;
	private int maxHitPoints;
	private int hitPoints;

	/**
	 * 
	 * @param minionCard
	 */
	public Minion(MinionCard minionCard) {
		// TODO - implement Minion.Minion
		throw new UnsupportedOperationException();
	}

	public void Attack() {
		// TODO - implement Minion.Attack
		throw new UnsupportedOperationException();
	}

	public int getPhysicalDamage() {
		return this.physicalDamage;
	}

	public int getMagicalDamage() {
		return this.magicalDamage;
	}

	public int getMaxHitPoints() {
		return this.maxHitPoints;
	}

	public ITarget getITarget() {
		// TODO - implement Minion.getITarget
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param iTarget
	 */
	public void setITarget(ITarget iTarget) {
		// TODO - implement Minion.setITarget
		throw new UnsupportedOperationException();
	}

}