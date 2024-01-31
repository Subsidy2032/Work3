package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		SlicerMachine machine = new SlicerMachine(numOfSaladsToPrepare);
		CucumbersThread cucumber = new CucumbersThread(machine);
		TomatoesThread tomato = new TomatoesThread(machine);
		SlicerThread slicer = new SlicerThread(machine);
		
		cucumber.start();
		tomato.start();
		slicer.start();
		
		try {
			cucumber.join();
		}
		catch(InterruptedException e) {}
		
		try {
			tomato.join();
		}
		catch(InterruptedException e) {}
		
		try {
			slicer.join();
		}
		catch(InterruptedException e) {}
		
		System.out.println("Done");
		scan.close();
	}

}
