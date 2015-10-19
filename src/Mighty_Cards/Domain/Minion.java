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
                if(target instanceof Minion)
                {
                    //It's strange that he gets the damage from the minion he attacks. He can get twice the damage because the 'turns' are on the same moment.
                    this.SetHitPoints(this.getHitPoints()); // Can't get the target's Damage;
                }

                //self.SetHitPoint(hp-target.etc) //zie I.23 van Analyzedocument.docx
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
            if(iTarget instanceof Minion)
            {
                
            }
            this.target = iTarget;    
	}

        public int getHitPoints(){
            return hitPoints;
        }
        
        public void SetHitPoints(int hitPoints){
            this.hitPoints = hitPoints;
        }
}