package domus.server.sensors;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Shutter implements Runnable {

	private boolean shutter; 
	private DateFormat dateFormat;
	Thread shutterBehaviour;

	public Shutter(String name) {
		shutter = false;
		this.dateFormat = new SimpleDateFormat("HH:mm:ss"+", "+"dd/MM/yy");
		shutterBehaviour = new Thread(this, "shutter:" + name );
		shutterBehaviour.start();
	}

	public boolean isUp() {
		return shutter;
	}

	public void setShutter(boolean state) {
		shutter = state;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: shutter is " + shutter);
	}

	public void run() {
		try {
			while (true) {
				//ogni 10000ms cambia lo stato della tapparella
				Thread.sleep(10000);
				setShutter( !isUp() );
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrotto");
		}
	}

	/*
	 * public static void main(String[] args){ new Shutter(); }
	 */
}
