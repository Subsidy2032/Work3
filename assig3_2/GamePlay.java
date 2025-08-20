package assig3_2;
import java.util.Random;

/**
 * A class to describe a game play
 *
 */
public class GamePlay {
	private boolean coin_available_;
	private int rounds_counter_;
	
	/**
	 * 
	 * @return The number of rounds played
	 */
	public int getNumOfRounds() {
		return rounds_counter_;
	}
	
	/**
	 * Makes the coin available or unavailable, and notifies the threads if needed
	 * @param val True or false to make the coin available or unavailable respectively
	 */
	public synchronized void makeCoinAvail(boolean val) {
		coin_available_ = val;
		
		if(coin_available_)
			notifyAll(); // Notify all waiting threads that the coin is available
	}
	
	/**
	 * Flips the coin and returns heads or tails
	 * @return 1 if heads, 0 if tails
	 */
	public int flipCoin() {
		try {
			// Wait for the coin to be available
			while(!coin_available_) {
				System.out.println(Thread.currentThread().getName() + " is waiting for coin");
				wait();
			}
		}
		catch(InterruptedException e) {}
		
		makeCoinAvail(false);
		
		System.out.println(Thread.currentThread().getName() + " is flipping coin");
		rounds_counter_++;
		
		int random_0_or_1 = get_0_or_1();
		makeCoinAvail(true);
		
		return random_0_or_1;
	}
	
	/**
	 * Generates a random integer between 0-1
	 * @return Random integer, 0 or 1
	 */
	public int get_0_or_1() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
}
