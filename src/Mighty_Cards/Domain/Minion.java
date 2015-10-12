package Mighty_Cards.Domain;

public class Minion implements ITarget {

	private int physicalDamage;
	private int magicalDamage;
	private int maxHitPoints;
	private int hitPoints;
        private ITarget target;
        
	/**
	 * 
	 * @param minionCard
	 */
	public Minion(MinionCard minionCard) {
		this.physicalDamage = minionCard.getPhysicalDamage();
                this.magicalDamage = minionCard.getMagicalDamage();
                this.maxHitPoints = minionCard.getHitPoints();
                this.hitPoints = maxHitPoints;
	}

	public void Attack() {
		ITarget target = this.getITarget();
                target.SetHitPoints(target.getHitPoints() - this.getPhysicalDamage() - this.getMagicalDamage());
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
            return target;
	}

	/**
	 * 
	 * @param iTarget
	 */
	public void setITarget(ITarget iTarget) {
            this.target = iTarget;    
	}

        public int getHitPoints(){
            return hitPoints;
        }
        
        public void SetHitPoints(int hitPoints){
            this.hitPoints = hitPoints;
        }
}