package domus.server.sensors;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Shutter implements Runnable {

	private boolean up;
	private DateFormat dateFormat;
	Thread shutterBehaviour;

	public Shutter() {
		this.up = false;
		this.dateFormat = new SimpleDateFormat("HH:mm:ss"+", "+"dd/MM/yy");
		shutterBehaviour = new Thread(this, "shutter");
		shutterBehaviour.start();
	}

	public boolean isUp() {
		return this.up;
	}

	public void setShutter(boolean state) {
		this.up = state;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: shutter is " + up);
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(10000);
				if (up)
					setShutter(false);
				else
					setShutter(true);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrotto");
		}
	}

	/*
	 * public static void main(String[] args){ new Shutter(); }
	 */
}
