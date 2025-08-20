package assig3_3;

/**
 * A class to describe a slicer machine
 *
 */
public class SlicerMachine {
	
	int numOfCucumbers = 0;
	int numOfTomatoes = 0;
	int numOfPreparedSalads = 0;
	int saladsToPrepare;
	
	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;
	
	/**
	 * Constructor
	 * @param saladsToPrepare The number of salads to prepare
	 */
	public SlicerMachine(int saladsToPrepare) {
		this.saladsToPrepare = saladsToPrepare;
	}
	
	/**
	 * add one cucumber into the slicer chamber
	 */
	synchronized void addOneCucumber() {
		try {
			while(numOfCucumbers >= cucumbersNeededForOneSalad)
				wait();
		}
		catch(InterruptedException e) {}
		
		System.out.println("adding one cucumber to the machine");
		numOfCucumbers++;
		notifyAll();
	}
	
	/**
	 * add one tomato into the slicer chamber
	 */
	synchronized void addOneTomato() {
		try {
			while(numOfTomatoes >= tomatoesNeededForOneSalad)
				wait();
		}
		catch(InterruptedException e) {}
		
		System.out.println("adding one tomato to the machine");
		numOfTomatoes++;
		notifyAll();
	}
	
	/**
	 * if there are enough vegetables in the slicer chamber, make another salad
	 */
	synchronized void sliceVegetables() {
		try {
			while((numOfCucumbers < cucumbersNeededForOneSalad) || (numOfTomatoes < tomatoesNeededForOneSalad))
				wait();
		}
		catch(InterruptedException e) {}
		
		makeNewSalad();
		notifyAll();
	}
	
	/**
	 * Make a new salad
	 */
	private void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
	}	
	
	/**
	 * 
	 * @return The number of prepared salads
	 */
	int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}
	
	/**
	 * @return The number of salads that should be prepared
	 */
	int getSaladsToPrepare() {
		return saladsToPrepare;
	}

}
