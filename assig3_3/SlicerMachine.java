package assig3_3;

public class SlicerMachine {
	
	int numOfCucumbers = 0;
	int numOfTomatoes = 0;
	int numOfPreparedSalads = 0;
	int saladsToPrepare;
	
	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;
	
	public SlicerMachine(int saladsToPrepare) {
		this.saladsToPrepare = saladsToPrepare;
	}
	
	// add one cucumber into the slicer chamber
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

	// add one tomato into the slicer chamber
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
	
	// if there are enough vegetables in the slicer
	// chamber, make another salad
	synchronized void sliceVegetables() {
		try {
			while((numOfCucumbers < cucumbersNeededForOneSalad) || (numOfTomatoes < tomatoesNeededForOneSalad))
				wait();
		}
		catch(InterruptedException e) {}
		
		makeNewSalad();
		notifyAll();
	}

	private void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
	}	
	
	int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}
	
	int getSaladsToPrepare() {
		return saladsToPrepare;
	}

}
