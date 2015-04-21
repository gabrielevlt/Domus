package domus.server.sensors;

import java.util.Random;

public class Light implements Runnable {

	// LIGHT'S ATTRIBUTES
	private boolean on;

	// BEHAVIOUR
	Thread lightBehaviour;

	public Light(String name) {

		// SETTING FLAGS
		this.on = false;


		// CREATING AND STARTING LIGHT BEHAVIOUR THREAD
		this.lightBehaviour = new Thread(this, name + ".light");
		this.lightBehaviour.start();
	}

	public boolean isOn() {
		return this.on;
	}

	public void setLight(boolean b) {
		this.on = b;
	}

	public void run() {
		try {
			Random random = new Random();
			int randomInt;
			while (true) {
				randomInt = random.nextInt(11);
				Thread.sleep((randomInt + 7) * 1000);
				setLight(!isOn());
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrupted");
		}
	}
}
