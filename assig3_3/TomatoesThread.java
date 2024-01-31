package assig3_3;

public class TomatoesThread extends Thread {
	SlicerMachine machine;
	
	public TomatoesThread(SlicerMachine machine) {
		this.machine = machine;
	}
	
	public void addTomatoes() {
		machine.addOneTomato();
	}
	
	public void run() {
		while(machine.getNumOfPreparedSalads() < machine.getSaladsToPrepare()) {
			addTomatoes();
		}
	}
}
