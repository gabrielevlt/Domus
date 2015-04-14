package domus.server.sensors;

import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class Light implements Runnable {

	// LIGHT'S ATTRIBUTES
	private boolean on;

	// DATE FORMAT
	private SimpleDateFormat dateFormat;

	// BEHAVIOUR
	Thread lightBehaviour;

	public Light(String name) {

		// SETTING FLAGS
		this.on = false;

		// SETTING DATE FORMAT
		this.dateFormat = new SimpleDateFormat("HH:mm:ss" + ", " + "dd/MM/yy");

		// CREATING AND STARTING LIGHT BEHAVIOUR THREAD
		this.lightBehaviour = new Thread(this, name + ".light");
		this.lightBehaviour.start();
	}

	public boolean isOn() {
		return this.on;
	}

	public void setLight(boolean b) {
		this.on = b;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: light is now "
				+ (isOn() ? "on" : "off"));
	}

	public void run() {
		try {
			Random random = new Random();
			int randomInt;
			while (true) {
				randomInt = random.nextInt(5);
				Thread.sleep((randomInt + 3) * 1000);
				setLight(!isOn());
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrupted");
		}
	}
}
