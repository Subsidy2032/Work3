package assig3_3;

public class CucumbersThread extends Thread {
	SlicerMachine machine;
	
	public CucumbersThread(SlicerMachine machine) {
		this.machine = machine;
	}
	
	public void addCucumbers() {
		machine.addOneCucumber();
	}
	
	public void run() {
		while(machine.getNumOfPreparedSalads() < machine.getSaladsToPrepare()) {
			addCucumbers();
		}
	}
}