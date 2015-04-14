package domus.server.sensors;

import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Thermostat implements Runnable {

	private boolean on;
	private double settedTemperature;
	private double actualTemperature;
	private DateFormat dateFormat;
	Thread thermostatBehaviour;

	public Thermostat() {
		this.on = true;
		this.settedTemperature = 22.5;
		this.actualTemperature = 22.5;
		this.dateFormat = new SimpleDateFormat("HH:mm:ss" + ", " + "dd/MM/yy");
		thermostatBehaviour = new Thread(this, "thermostat");
		thermostatBehaviour.start();
	}

	public boolean isOn() {
		return this.on;
	}

	public void setOn(boolean on) {
		this.on = on;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: thermostat is now "
				+ this.on);
	}

	public double getSettedTemperature() {
		return this.settedTemperature;
	}

	public void setSettedTemperature(double settedTemperature) {
		this.settedTemperature = settedTemperature;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date())
				+ "] says: the wanted tempearture now is "
				+ this.settedTemperature);
	}

	public double getActualTemperature() {
		return this.actualTemperature;
	}

	public void setActualTemperature(double actualTemperature) {
		this.actualTemperature = actualTemperature;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date())
				+ "] says: the actual temperature sensed is "
				+ this.actualTemperature);
	}

	public void run() {
		try {
			double randomDouble;
			while (true) {
				Thread.sleep(60000);
				if(on){
					randomDouble=Math.random();
					if(randomDouble%2==0){
						if(((int)(randomDouble*10)%10)%2==0){
							
							setActualTemperature(((getActualTemperature()+getSettedTemperature())/2)+randomDouble);
						}else{
							setActualTemperature(((getActualTemperature()+getSettedTemperature())/2)-randomDouble);
						}
					}else{
						if(((int)(randomDouble*10)%10)%2==0){
							setActualTemperature(((getActualTemperature()+getSettedTemperature())/2)+randomDouble);
						}else{
							setActualTemperature(((getActualTemperature()+getSettedTemperature())/2)-randomDouble);
						}
					}
					
				}
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrotto");
		}
	}

	public static void main(String[] args){ new Thermostat(); }

}
