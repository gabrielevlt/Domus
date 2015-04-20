package domus.server.sensors;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Sprinkler implements Runnable {

	// SPRINKLER'S ATTRIBUTES
	private boolean on;
	private boolean working;
	private Calendar activationTime;
	private int dutyTime;

	// DATE AND HOUR FORMAT
	private SimpleDateFormat hourFormat;

	// BEHAVIOUR
	Thread sprinklerBehaviour;

	public Sprinkler() {

		// SETTING FLAGS
		this.on = true;
		this.working = false;

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

	public boolean isWorking() {
		return this.working;
	}

	public void setWorking(boolean b) {
		this.working = b;
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
					Thread.sleep(100);
					// WAIT
				}
				if (isOn()) {
					setWorking(true);
					Thread.sleep(dutyTime * 1000);
					setWorking(false);
				}
				Thread.sleep(60000);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrupted");
		}
	}

	/*
	 * public void run(){ try{ Random random=new Random(); int randomInt;
	 * while(true){ Thread.sleep(1000); if(working) Thread.sleep(dutyTime*1000);
	 * else{ randomInt=random.nextInt(600); while((randomInt%dutyTime)!=0)
	 * randomInt=random.nextInt(600); System.out.println(Thread.currentThread()
	 * + " @ [" + dateFormat.format(new Date()) +
	 * "] says: next duty cycle in about " + randomInt/60 +" minutes");
	 * Thread.sleep(randomInt*1000); if(!working) setSprinkler(true);
	 * Thread.sleep(dutyTime*1000); setSprinkler(false); } } }
	 * catch(InterruptedException e) { System.out.println(Thread.currentThread()
	 * + " interrotto"); } }
	 */
}
