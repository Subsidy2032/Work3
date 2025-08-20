package assig3_3;

/**
 * A class to describe a tomato thread
 *
 */
public class TomatoesThread extends Thread {
	SlicerMachine machine;
	
	/**
	 * Constructor
	 * @param machine The machine to put tomatoes in
	 */
	public TomatoesThread(SlicerMachine machine) {
		this.machine = machine;
	}
	
	/**
	 * Add a tomato to the machine
	 */
	public void addTomatoes() {
		machine.addOneTomato();
	}
	
	/**
	 * Add tomatoes to the machine until there are enough prepared salads
	 */
	public void run() {
		while(machine.getNumOfPreparedSalads() < machine.getSaladsToPrepare()) {
			addTomatoes();
		}
	}
}
