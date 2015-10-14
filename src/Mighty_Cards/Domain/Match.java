package Mighty_Cards.Domain;

import java.util.ArrayList;

public class Match {

	private int turns;
	private GameState gameState;

        private Player player1;
        private Player player2;
        
        private Hero hero1;
        private Hero hero2;
        
	private void determineGameState() {
            if(player2 == null){
                gameState = GameState.Waiting;
                return;
            }
            if(hero1.getHitPoints()<=0 ^ hero2.getHitPoints() <= 0){//^= XOR true+false = true, false+false = false and true+true=false
                gameState = GameState.Defined;
                return;
            }
            if(hero1.getHitPoints()>0 && hero2.getHitPoints()>0){
                gameState = GameState.Active;
                return;
            }
            gameState = GameState.Tie;
	}

	private void processTurn() {
            Card p1 = hero1.getCardPlayed();
            Card p2 = hero2.getCardPlayed();
            
            //check minion card
            //create new minions
            if(p1 instanceof MinionCard){
                Minion m = new Minion((MinionCard)p1);
                //hero1.addMinion(m);
                //todo set target somhow?
            }
            if(p2 instanceof MinionCard){
                Minion m = new Minion((MinionCard)p2);
                //hero2.addMinion(m);
                //todo set target somhow?
            }
            
            //get all active minions
            ArrayList<Minion> p1min = hero1.getMinions();
            ArrayList<Minion> p2min = hero2.getMinions();
            
            //all not player attacks            
            p1min.stream().filter((m)->m.getITarget()!=hero2).forEach((m)->m.Attack());//attack all not players
            p2min.stream().filter((m)->m.getITarget()!=hero1).forEach((m)->m.Attack());//attack all not players
            
            //remove dead minions
            p1min.removeIf((m)->m.getHitPoints()<=0);
            p2min.removeIf((m)->m.getHitPoints()<=0);
            
            //all minion to player attacks
            p1min.stream().filter((m)->m.getITarget()==hero2).forEach((m)->m.Attack());//attack hero2
            p2min.stream().filter((m)->m.getITarget()==hero1).forEach((m)->m.Attack());//attack hero1
            
            //attack using cards
            //attack player card
            if(p1 instanceof HeroCard){
                HeroCard p1h = (HeroCard)p1;
                int hp = hero2.getHitPoints();
                int pSchield = 0, mSchield=0;
                if(p2 instanceof HeroCard){
                    HeroCard p2h = (HeroCard)p2;
                    pSchield = p2h.getPhysicalBlock();
                    mSchield = p2h.getMagicalBlock();
                }
                hero2.SetHitPoints(hp + (pSchield - p1h.getPhysicalBlock()) + (mSchield - p1h.getMagicalDamage()));
            }
            if(p2 instanceof HeroCard){
                HeroCard p2h = (HeroCard)p2;
                int hp = hero1.getHitPoints();
                int pSchield = 0, mSchield=0;
                if(p1 instanceof HeroCard){
                    HeroCard p1h = (HeroCard)p1;
                    pSchield = p1h.getPhysicalBlock();
                    mSchield = p1h.getMagicalBlock();
                }
                hero2.SetHitPoints(hp + (pSchield - p2h.getPhysicalBlock()) + (mSchield - p2h.getMagicalDamage()));
            }
            
            //todo here or somwere else?
            determineGameState();
	}

	/**
	 * 
	 * @param P1
	 */
	public Match(Player P1) {
            player1 = P1;
            hero1 = new Hero(this,P1,new Deck());//todo deck
            gameState = GameState.Waiting;
	}

	/**
	 * 
	 * @param P2
	 */
	public void addPlayer2(Player P2) {
            player2 = P2;
            hero2 = new Hero(this,P2,new Deck());
            gameState = GameState.Active;
	}

	public int getTurns() {
            return this.turns;
	}

	public Hero getHero1() {
            return hero1;
	}

	public Hero getHero2() {
            return hero2;
	}

	public GameState getGameState() {
            return this.gameState;
	}

	/**
	 * 
	 * @param hero
	 */
	public void concede(Hero hero) {
            gameState = GameState.Defined;
            hero.SetHitPoints(0);
            
            // TODO - implement Match.concede
            //	throw new UnsupportedOperationException();
	}

}