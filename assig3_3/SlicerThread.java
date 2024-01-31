package assig3_3;

public class SlicerThread extends Thread {
	SlicerMachine machine;
	
	public SlicerThread(SlicerMachine machine) {
		this.machine = machine;
	}
	
	public void slice() {
		machine.sliceVegetables();
	}
	
	public void run() {
		while(machine.getNumOfPreparedSalads() < machine.getSaladsToPrepare()) {
			slice();
		}
	}
}

