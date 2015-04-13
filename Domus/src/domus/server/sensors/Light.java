package domus.server.sensors;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Light implements Runnable {

	private boolean turnedOn;
	private DateFormat dateFormat;
	Thread lightBehaviour;

	public Light() {
		this.turnedOn = false;
		this.dateFormat = new SimpleDateFormat("HH:mm:ss"+", "+"dd/MM/yy");
		lightBehaviour = new Thread(this, "light");
		lightBehaviour.start();
	}

	public boolean isTurnedOn() {
		return this.turnedOn;
	}

	public void setLight(boolean turnedOn) {
		this.turnedOn = turnedOn;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: light is "
				+ turnedOn);
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(5000);
				if (isTurnedOn())
					setLight(false);
				else
					setLight(true);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrotto");
		}
	}

	public static void main(String[] args){ new Light(); }
}
