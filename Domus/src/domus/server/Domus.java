package domus.server;

import java.rmi.RemoteException;

import domus.server.RemoteDomusInterface;

import domus.server.sensors.*;

public class Domus implements RemoteDomusInterface {
	Thermostat thermostat;
	Light light;
	Shutter shutter;
	Sprinkler sprinkler;

	public Domus() {
		thermostat = new Thermostat();
		light = new Light();
		shutter = new Shutter();
		sprinkler = new Sprinkler();
	}

	@Override
	public boolean getThermostatState() throws RemoteException {
		return thermostat.isOn();
	}

	@Override
	public double getActualTemperature() throws RemoteException {
		return thermostat.getActualTemperature();
	}

	@Override
	public double getSettedTemperature() throws RemoteException {
		return thermostat.getSettedTemperature();
	}

	@Override
	public void setSettedTemperature(double d) throws RemoteException {
		thermostat.setSettedTemperature(d);

	}

	@Override
	public boolean getLightState() throws RemoteException {
		return light.isTurnedOn();
	}

	@Override
	public void setLightState(boolean b) throws RemoteException {
		light.setLight(b);
	}

	@Override
	public boolean getShutterState() throws RemoteException {
		return shutter.isUp();
	}

	@Override
	public void setShutterState(boolean b) throws RemoteException {
		shutter.setShutter(b);
	}

	@Override
	public boolean getSprinklerState() throws RemoteException {
		return sprinkler.isWorking();
	}

	@Override
	public void setSprinklerState(boolean b) throws RemoteException {
		sprinkler.setSprinkler(b);
	}

	@Override
	public int getDutyTime() throws RemoteException {
		return sprinkler.getDutyTime();
	}

	@Override
	public void setDutyTime(int i) throws RemoteException {
		sprinkler.setDutyTime(i);
	}

}
