package assig3_2;

public class Gamer extends Thread {
	private int goodFlipsCounter;
	private GamePlay game;
	
	public Gamer(GamePlay game) {
		this.game = game;
	}
	
	public int getScore() {
		return goodFlipsCounter;
	}
	
	public void play() {
		while(game.getNumOfRounds() < 10) {
			int headsOrTails = game.flipCoin();
			
			if(headsOrTails == 1)
				goodFlipsCounter++;
			
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
