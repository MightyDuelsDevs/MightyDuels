package Mighty_Cards.Domain;

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
            // TODO - implement Match.processTurn
            throw new UnsupportedOperationException();
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