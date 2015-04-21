package domus.server.sensors;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Sprinkler implements Runnable {

	// SPRINKLER'S ATTRIBUTES
	private boolean on;
	private Calendar activationTime;
	private int dutyTime;

	// DATE AND HOUR FORMAT
	private SimpleDateFormat hourFormat;

	// BEHAVIOUR
	Thread sprinklerBehaviour;

	public Sprinkler() {

		// SETTING FLAGS
		this.on = true;

		// SETTING ACTIVATION
		this.activationTime = Calendar.getInstance();
		this.activationTime.setTime(new Date());
		this.activationTime.set(Calendar.HOUR_OF_DAY, 19);
		this.activationTime.set(Calendar.MINUTE, 0);

		// SETTING DUTY CYCLE
		this.dutyTime = 17;

		// SETTING DATE AND HOUR FORMAT
		this.hourFormat = new SimpleDateFormat("HH:mm");

		// CREATING AND STARTING SPRINKLER BEHAVIOUR THREAD
		this.sprinklerBehaviour = new Thread(this, "sprinkler");
		this.sprinklerBehaviour.start();
	}

	public boolean isOn() {
		return this.on;
	}

	public void setSprinkler(boolean b) {
		this.on = b;
	}

	public int getDutyTime() {
		return this.dutyTime;
	}

	public void setDutyTime(int i) {
		this.dutyTime = i;
	}

	public String getActivationTime() {
		return this.hourFormat.format(activationTime.getTime());
	}

	public void setActivationTime(int h, int m) {
		this.activationTime.set(Calendar.HOUR_OF_DAY, h);
		this.activationTime.set(Calendar.MINUTE, m);
	}

	public void run() {
		try {
			while (true) {
				while (!hourFormat.format(activationTime.getTime()).equals(
						hourFormat.format(new Date()))) {
					Thread.sleep(500);
					// WAIT
				}
				if (isOn()) {
					Thread.sleep(dutyTime * 1000);
				}
				Thread.sleep(60000);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrupted");
		}
	}
}
