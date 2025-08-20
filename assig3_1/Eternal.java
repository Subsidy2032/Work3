package assig3_1;

public class Eternal {
	// Create an object to use as a lock, and states for the run order
	public static Object lock = new Object();
	public static boolean state1 = true;
	public static boolean state2 = false;
	public static boolean state3 = false;
	
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					// Wait until state1 is set to true
					synchronized(lock) {
						try {
							while(!state1)
								lock.wait();
						}
						
						catch(InterruptedException e) {}
						
						// Example A code block
						String message = "I am thread 1";
						System.out.println(message);
						
						// Set state1 to false (for waiting) and state2 to true for thread 2 to start running
						state1 = false;
						state2 = true;
						lock.notifyAll();
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					// Wait until state2 is set to true
					synchronized(lock) {
						try {
							while(!state2)
								lock.wait();
						}
						
						catch(InterruptedException e) {}
						
						// Example B code block
						String message = "I am thread 2";
						System.out.println(message);
						
						// Set state3 to true for thread 3 to start running (once he gets processor time)
						state3 = true;
						lock.notifyAll();
					}
				}
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				while(true) {
					// Wait until state3 is set to true
					synchronized(lock) {
						try {
							while(!state3)
								lock.wait();
						}
						
						catch(InterruptedException e) {}
						
						// Example C code block
						String message = "I am thread 3";
						System.out.println(message);
						
						// Set state3 and state2 to false (for waiting) and state1 to true for thread 1 to start running
						state1 = true;
						state2 = false;
						state3 = false;
						lock.notifyAll();
					}
				}
			}
		};
		
		// Start the threads
		t1.start();
		t2.start();
		t3.start();
	}

}
