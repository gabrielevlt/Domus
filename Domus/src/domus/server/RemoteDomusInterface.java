package domus.server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteDomusInterface extends Remote{
	
	// THERMOSTAT
	boolean getThermostatState() throws RemoteException;
	double getActualTermperature() throws RemoteException;
	double getSettedTermperature() throws RemoteException;
	double setSettedTermperature() throws RemoteException;
	
	// LIGHT
	boolean getLightState() throws RemoteException;
	boolean setLightState() throws RemoteException;
	
	// SHUTTER
	boolean getShutterState() throws RemoteException;
	boolean setShutterState() throws RemoteException;
	
	// SPRINKLER
	boolean getSprinklerState() throws RemoteException;
	boolean setSprinklerState() throws RemoteException;
	int getDutyTime() throws RemoteException;
	int setDutyTime() throws RemoteException;
}
