package domus.server.sensors;

public class Thermostat implements Runnable {

	// THERMOSTAT'S ATTRIBUTES
	private boolean on;
	private double settedTemperature;
	private double actualTemperature;

	// BEHAVIOUR
	Thread thermostatBehaviour;

	public Thermostat() {

		// SETTING FLAGS AND ATTRIBUTES
		this.on = true;
		this.settedTemperature = 22.5;
		this.actualTemperature = 22.5;

		// CREATING AND STARTING THERMOSTAT BEHAVIOUR THREAD
		this.thermostatBehaviour = new Thread(this, "thermostat");
		this.thermostatBehaviour.start();
	}

	public boolean isOn() {
		return this.on;
	}

	public void setThermostat(boolean b) {
		this.on = b;
	}

	public double getSettedTemperature() {
		return this.settedTemperature;
	}

	public void setSettedTemperature(double d) {
		this.settedTemperature = d;
	}

	public double getActualTemperature() {
		return this.actualTemperature;
	}

	public void setActualTemperature(double d) {
		this.actualTemperature = d;
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
