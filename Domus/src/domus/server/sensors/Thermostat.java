package domus.server.sensors;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Thermostat implements Runnable {

	// THERMOSTAT'S ATTRIBUTES
	private boolean on;
	private double settedTemperature;
	private double actualTemperature;

	// DATE FORMAT
	private SimpleDateFormat dateFormat;

	// BEHAVIOUR
	Thread thermostatBehaviour;

	public Thermostat() {

		// SETTING FLAGS AND ATTRIBUTES
		this.on = true;
		this.settedTemperature = 22.5;
		this.actualTemperature = 22.5;

		// SETTING DATE FORMAT
		this.dateFormat = new SimpleDateFormat("HH:mm:ss" + ", " + "dd/MM/yy");

		// CREATING AND STARTING THERMOSTAT BEHAVIOUR THREAD
		this.thermostatBehaviour = new Thread(this, "thermostat");
		this.thermostatBehaviour.start();
	}

	public boolean isOn() {
		return this.on;
	}

	public void setThermostat(boolean b) {
		this.on = b;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: thermostat is now "
				+ (isOn() ? "on" : "off"));
	}

	public double getSettedTemperature() {
		return this.settedTemperature;
	}

	public void setSettedTemperature(double d) {
		this.settedTemperature = d;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date())
				+ "] says: the wanted tempearture now is "
				+ getSettedTemperature());
	}

	public double getActualTemperature() {
		return this.actualTemperature;
	}

	public void setActualTemperature(double d) {
		this.actualTemperature = d;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date())
				+ "] says: the actual temperature sensed is "
				+ getActualTemperature());
	}

	public void run() {
		try {
			double randomDouble;
			while (true) {
				Thread.sleep(60000);
				if (isOn()) {
					randomDouble = Math.random();
					if (randomDouble % 2 == 0) {
						if (((int) (randomDouble * 10) % 10) % 2 == 0) {

							setActualTemperature(((getActualTemperature() + getSettedTemperature()) / 2)
									+ randomDouble);
						} else {
							setActualTemperature(((getActualTemperature() + getSettedTemperature()) / 2)
									- randomDouble);
						}
					} else {
						if (((int) (randomDouble * 10) % 10) % 2 == 0) {
							setActualTemperature(((getActualTemperature() + getSettedTemperature()) / 2)
									+ randomDouble);
						} else {
							setActualTemperature(((getActualTemperature() + getSettedTemperature()) / 2)
									- randomDouble);
						}
					}

				}
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrupted");
		}
	}
}
