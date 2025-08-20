package assig3_2;

/**
 * A class to describe a Judge
 *
 */
public class Judge extends Thread {
	GamePlay game;
	
	/**
	 * Constructor
	 * @param game The game in which the Judge participates
	 */
	public Judge(GamePlay game) {
		this.game = game;
	}
	
	/**
	 * Decides (to some extent) whether the coin is available or not
	 */
	public void run() {
		while(game.getNumOfRounds() < 10) {
			// Makes the coin unavailable for a second
			game.makeCoinAvail(false);
			
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {}
			
			// Makes the coin available for half a second
			game.makeCoinAvail(true);
			
			try {
				sleep(500);
			}
			catch(InterruptedException e) {}
		}
	}
}
