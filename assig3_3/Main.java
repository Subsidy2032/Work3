package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		// Initiates objects required to operate the machine
		SlicerMachine machine = new SlicerMachine(numOfSaladsToPrepare);
		CucumbersThread cucumber = new CucumbersThread(machine);
		TomatoesThread tomato = new TomatoesThread(machine);
		SlicerThread slicer = new SlicerThread(machine);
		
		// Starts the threads
		cucumber.start();
		tomato.start();
		slicer.start();
		
		// Makes sure the threads are running before the main thread
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
