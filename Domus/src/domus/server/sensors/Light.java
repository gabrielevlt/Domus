package domus.server.sensors;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Light implements Runnable {
	private boolean light; 
	private DateFormat dateFormat;
	Thread lightBehaviour;

	public Light(String name) {
		light = false;
		this.dateFormat = new SimpleDateFormat("HH:mm:ss"+", "+"dd/MM/yy");
		lightBehaviour = new Thread(this, "light:" + name);
		lightBehaviour.start();
	}

	public boolean isOn() {
		return light;
	}

	public void setLight(boolean state) {
		light = state;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: light is "
				+ light);
	}

	public void run() {
		try {
			while (true) {
				//ogni 5000ms cambia lo stato della luce
				Thread.sleep(5000);
				setLight( !isOn() );
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrotto");
		}
	}

	//public static void main(String[] args){ new Light(); }
}
