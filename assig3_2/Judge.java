package assig3_2;

public class Judge extends Thread {
	GamePlay game;
	
	public Judge(GamePlay game) {
		this.game = game;
	}
	
	public void run() {
		while(game.getNumOfRounds() < 10) {
			game.makeCoinAvail(false);
			
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {}
			
			game.makeCoinAvail(true);
			
			try {
				sleep(500);
			}
			catch(InterruptedException e) {}
		}
	}
}
