package assig3_3;

/**
 * A class to describe a cucumber thread
 *
 */
public class CucumbersThread extends Thread {
	SlicerMachine machine;
	
	/**
	 * Constructor
	 * @param machine The machine to put cucumbers in
	 */
	public CucumbersThread(SlicerMachine machine) {
		this.machine = machine;
	}
	
	/**
	 * Add a cucumber to the machine
	 */
	public void addCucumbers() {
		machine.addOneCucumber();
	}
	
	/**
	 * Add cucumbers to the machine until there are enough prepared salads
	 */
	public void run() {
		while(machine.getNumOfPreparedSalads() < machine.getSaladsToPrepare()) {
			addCucumbers();
		}
	}
}