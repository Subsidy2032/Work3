package assig3_2;

public class Main {

	public static void main(String[] args) {
		GamePlay game = new GamePlay();
		Gamer player1 = new Gamer(game);
		Gamer player2 = new Gamer(game);
		Judge judge = new Judge(game);
		
		player1.start();
		player2.start();
		judge.start();
		
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
		
		if(player1.getScore() > player2.getScore())
			System.out.println("player 1 wins");
		
		else if(player2.getScore() > player1.getScore())
			System.out.println("player 2 wins");
		
		else
			System.out.println("tie");
	}

}
