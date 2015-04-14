package domus.server.sensors;

import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class Shutter implements Runnable {

	// SHUTTER'S ATTRIBUTES
	private boolean up;

	// DATE FORMAT
	private SimpleDateFormat dateFormat;

	// BEHAVIOUR
	Thread shutterBehaviour;

	public Shutter(String name) {

		// SETTING FLAGS
		this.up = false;

		// SETTING DATE FORMAT
		this.dateFormat = new SimpleDateFormat("HH:mm:ss" + ", " + "dd/MM/yy");

		// CREATING AND STARTING SHUTTER BEHAVIOUR THREAD
		this.shutterBehaviour = new Thread(this, name + ".shutter");
		this.shutterBehaviour.start();
	}

	public boolean isUp() {
		return this.up;
	}

	public void setShutter(boolean b) {
		this.up = b;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: shutter is now "
				+ (isUp() ? "up" : "down"));
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
