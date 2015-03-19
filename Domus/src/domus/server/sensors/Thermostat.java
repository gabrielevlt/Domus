package domus.server.sensors;

public class Thermostat {
	private boolean on;
	private double temperature;
	
	public Thermostat(){
		on=false;
		temperature=22.5;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

}
