package assig3_2;
import java.util.Random;

public class GamePlay {
	private boolean coin_available_;
	private int rounds_counter_;
	
	public int getNumOfRounds() {
		return rounds_counter_;
	}
	
	public synchronized void makeCoinAvail(boolean val) {
		coin_available_ = val;
		
		if(coin_available_)
			notifyAll();
	}
	
	public synchronized int flipCoin() {
		try {
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
	
	public int get_0_or_1() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
}
