package assig3_2;

/**
 * A class to describe a Gamer
 *
 */
public class Gamer extends Thread {
	private int goodFlipsCounter;
	private GamePlay game;
	
	/**
	 * Constructor
	 * @param game The game in which the Gamer participates
	 */
	public Gamer(GamePlay game) {
		this.game = game;
	}
	
	/**
	 * 
	 * @return The number of wins (the number of times the Gamer got heads)
	 */
	public int getScore() {
		return goodFlipsCounter;
	}
	
	/**
	 * Plays until the coined has been flipped 10 times
	 */
	public void play() {
		while(game.getNumOfRounds() < 10) {
			synchronized(game) {
				if(game.getNumOfRounds() < 10) {
					int headsOrTails = game.flipCoin();
					
					// Checks if the Gamer got heads and increments the number of wins if they did
					if(headsOrTails == 1)
						goodFlipsCounter++;
				}
			}
			
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {}
		}
	}
	
	public void run() {
		play();
	}
}
