package assig3_2;

public class Main {

	public static void main(String[] args) {
		// Creates the Game, Gamers and Judge
		GamePlay game = new GamePlay();
		Gamer player1 = new Gamer(game);
		Gamer player2 = new Gamer(game);
		Judge judge = new Judge(game);
		
		// Starts the threads
		player1.start();
		player2.start();
		judge.start();
		
		// Makes sure the threads are running before the main thread
		try {
			player1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			player2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			judge.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Prints the results of the game
		if(player1.getScore() > player2.getScore())
			System.out.println("player 1 wins");
		
		else if(player2.getScore() > player1.getScore())
			System.out.println("player 2 wins");
		
		else
			System.out.println("tie");
	}

}
