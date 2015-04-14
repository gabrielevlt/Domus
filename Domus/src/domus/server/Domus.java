package domus.server;

import java.rmi.RemoteException;

import domus.server.RemoteDomusInterface;

import domus.server.sensors.*;

public class Domus implements RemoteDomusInterface {
	Thermostat thermostat;
	Light[] light;
	Shutter[] shutter;
	Sprinkler sprinkler;

	public Domus() {
		thermostat = new Thermostat();
		
		light = new Light[3];
		light[0] = new Light("Kitchen");
		light[1] = new Light("Living room");
		light[2] = new Light("Bathroom");
		
		shutter = new Shutter[3];
		shutter[0] = new Shutter("Kitchen");
		shutter[1] = new Shutter("Living room");
		shutter[2] = new Shutter("Bathroom");
		
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
	public boolean getLightState(int room) throws RemoteException {
		return light[room].isOn();
	}

	@Override
	public void setLightState(int room, boolean b) throws RemoteException {
		light[room].setLight( b);
	}

	@Override
	public boolean getShutterState(int room) throws RemoteException {
		return shutter[room].isUp();
	}

	@Override
	public void setShutterState(int room, boolean b) throws RemoteException {
		shutter[room].setShutter(b);
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
