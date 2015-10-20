package Mighty_Cards.Domain;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * Controller for an match between two players
 */
public class Match {

        private static final Logger log = Logger.getLogger(Match.class.getName());;
    
	private int turns;
	private GameState gameState;

        private Player player1;
        private Player player2;
        
        private Hero hero1;
        private Hero hero2;
        
        Timer timer;
        
        /**
         * check's the players health and updates the gamestate according to their health
         */
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

        /**
         * Processes one turn. (card's played, minion attacks and gamestate update)
         */
	private void processTurn() {
            log.info(String.format("Processing turn %d of player '%s' and '%s'.",turns,player1.getUsername(),player2.getUsername()));
            Card p1 = hero1.getCardPlayed();
            Card p2 = hero2.getCardPlayed();
            
            //check minion card
            //create new minions
            if(p1 instanceof MinionCard){
                log.info(String.format("Adding minion %s to %s",p1.getName(),player1.getUsername()));
                Minion m = new Minion((MinionCard)p1);
                hero1.getMinions().add(m);
                //hero1.addMinion(m);
                //todo set target somhow?
            }
            if(p2 instanceof MinionCard){
                log.info(String.format("Adding minion %s to %s",p2.getName(),player2.getUsername()));
                Minion m = new Minion((MinionCard)p2);
                hero2.getMinions().add(m);
                //hero2.addMinion(m);
                //todo set target somhow?
            }
            
            log.info("Processing minion attacks. Obtaining minions");
            //get all active minions
            ArrayList<Minion> p1min = hero1.getMinions();
            ArrayList<Minion> p2min = hero2.getMinions();
            
            log.info("Filter non hero attack, attack minions");
            //all not player attacks            
            p1min.stream().filter((m)->m.getITarget()!=hero2).forEach((m)->m.Attack());//attack all not players
            p2min.stream().filter((m)->m.getITarget()!=hero1).forEach((m)->m.Attack());//attack all not players
            
            log.info("Remove dead minions");
            //remove dead minions
            p1min.removeIf((m)->m.getHitPoints()<=0);
            p2min.removeIf((m)->m.getHitPoints()<=0);
            
            log.info("Filter hero attacks, attack hero");
            //all minion to player attacks
            p1min.stream().filter((m)->m.getITarget()==hero2).forEach((m)->m.Attack());//attack hero2
            p2min.stream().filter((m)->m.getITarget()==hero1).forEach((m)->m.Attack());//attack hero1
            
            log.info("Process HeroCard attacks");
            //attack using cards
            //attack player card
            if(p1 instanceof HeroCard){
                log.info(String.format("%s attacks %s with %s",player1.getUsername(),player2.getUsername(),p1.getName()));
                HeroCard p1h = (HeroCard)p1;
                int hp = hero2.getHitPoints();
                int pSchield = 0, mSchield=0;
                if(p2 instanceof HeroCard){
                    log.info(String.format("%s blocks %s with %s",player2.getUsername(),player1.getUsername(),p2.getName()));
                    HeroCard p2h = (HeroCard)p2;
                    pSchield = p2h.getPhysicalBlock();
                    mSchield = p2h.getMagicalBlock();
                }
                log.info(String.format("hero2hp: %d, hero2PysicalSchield: %d, hero1PhysicalDamage: %d, hero2MagicalSchield: %d, hero1MagicalDamage: %d",hp,pSchield,p1h.getPhysicalDamage(),mSchield,p1h.getMagicalDamage()));
                hero2.SetHitPoints(hp + (pSchield - p1h.getPhysicalDamage()) + (mSchield - p1h.getMagicalDamage()));
            }
            if(p2 instanceof HeroCard){
                log.info(String.format("%s attacks %s with %s",player2.getUsername(),player1.getUsername(),p2.getName()));
                HeroCard p2h = (HeroCard)p2;
                int hp = hero1.getHitPoints();
                int pSchield = 0, mSchield=0;
                if(p1 instanceof HeroCard){
                    log.info(String.format("%s blocks %s with %s",player1.getUsername(),player2.getUsername(),p1.getName()));
                    HeroCard p1h = (HeroCard)p1;
                    pSchield = p1h.getPhysicalBlock();
                    mSchield = p1h.getMagicalBlock();
                }
                log.info(String.format("hero2hp: %d, hero2PysicalSchield: %d, hero1PhysicalDamage: %d, hero2MagicalSchield: %d, hero1MagicalDamage: %d",hp,pSchield,p2h.getPhysicalDamage(),mSchield,p2h.getMagicalDamage()));
                hero2.SetHitPoints(hp + (pSchield - p2h.getPhysicalBlock()) + (mSchield - p2h.getMagicalDamage()));
            }
            log.info("Turn finished");
            //todo here or somwere else?
            determineGameState();
            turns++;
	}

	/**
	 * Create a new instance of match with P1 as the first player/hero
	 * @param P1 The first player
	 */
	public Match(Player P1) {
            player1 = P1;
            hero1 = new Hero(this,player1,new Deck());//todo deck
            determineGameState();
            //gameState = GameState.Waiting;
            timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run() {
                    if(gameState != GameState.Active){
                        if(gameState == GameState.Defined || gameState == GameState.Tie){
                            timer.cancel();//quit if the game has finished
                            return;
                        }
                    }
                    if(hero1.getFinished() && hero2.getFinished()){
                        processTurn();
                    }
                }
            }, 0, 100);
	}

	/**
	 * Adds a second player as hero 2
	 * @param P2 the second player
	 */
	public void addPlayer2(Player P2) {
            player2 = P2;
            hero2 = new Hero(this,P2,new Deck());
            determineGameState();
            //gameState = GameState.Active;
	}

        /**
         * Get the amount of turns passed
         * @return The amount of turns
         */
	public int getTurns() {
            return this.turns;
	}

        /**
         * Get the first hero
         * @return the first hero object
         */
        public Hero getHero1() {
            return hero1;
	}

        /**
         * Get the second hero
         * @return the second hero object
         */
	public Hero getHero2() {
            return hero2;
	}

        /**
         * Get the current gamestate
         * @return the current game state
         */
	public GameState getGameState() {
            return this.gameState;
	}

	/**
	 * Concede a match, this will make a player force lose
	 * @param hero The hero that concedes
	 */
	public void concede(Hero hero) {
            //gameState = GameState.Defined;
            hero.SetHitPoints(0);
            determineGameState();
	}

}