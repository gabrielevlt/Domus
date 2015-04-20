package domus.server.sensors;

import java.util.Random;

public class Shutter implements Runnable {

	// SHUTTER'S ATTRIBUTES
	private boolean up;

	// BEHAVIOUR
	Thread shutterBehaviour;

	public Shutter(String name) {

		// SETTING FLAGS
		this.up = false;

		// CREATING AND STARTING SHUTTER BEHAVIOUR THREAD
		this.shutterBehaviour = new Thread(this, name + ".shutter");
		this.shutterBehaviour.start();
	}

	public boolean isUp() {
		return this.up;
	}

	public void setShutter(boolean b) {
		this.up = b;
	}

	public void run() {
		try {
			Random random = new Random();
			int randomInt;
			while (true) {
				randomInt = random.nextInt(11);
				Thread.sleep((randomInt + 3) * 1000);
				setShutter(!isUp());
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrupted");
		}
	}
}
