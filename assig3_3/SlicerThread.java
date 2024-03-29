package assig3_3;

/**
 * A class to describe a slicer thread
 * @author author Ron Bitan (315924316) && Noam Muchink (212472484)
 *
 */
public class SlicerThread extends Thread {
	SlicerMachine machine;
	
	/**
	 * Constructor
	 * @param machine The machine to slice the vegetables in
	 */
	public SlicerThread(SlicerMachine machine) {
		this.machine = machine;
	}
	
	/**
	 * Slicing the vegetables
	 */
	public void slice() {
		machine.sliceVegetables();
	}
	
	/**
	 * Slicing vegetables until there are enough prepared salads
	 */
	public void run() {
		while(machine.getNumOfPreparedSalads() < machine.getSaladsToPrepare()) {
			slice();
		}
	}
}

