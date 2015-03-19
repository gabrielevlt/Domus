package domus.server.sensors;

public class Thermostat {
	private boolean on;
	private double settedTemperature;
	private double actualTemperature;
	
	public Thermostat(){
		this.on=false;
		this.settedTemperature=22.5;
		this.actualTemperature=22.5;
	}

	public boolean isOn() {
		return this.on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getSettedTemperature() {
		return this.settedTemperature;
	}

	public void setSettedTemperature(double settedTemperature) {
		this.settedTemperature = settedTemperature;
	}

	public double getActualTemperature() {
		return this.actualTemperature;
	}

	public void setActualTemperature(double actualTemperature) {
		this.actualTemperature = actualTemperature;
	}

}
