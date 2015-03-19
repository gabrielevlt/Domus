package domus.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import domus.server.RemoteDomusInterface;

public class TestClient {

	public static void main(String[] args) {
		// CREAZIONE SECURITY MANAGER
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		
		try {
			// NOME OGGETTO REMOTO
			String serviceName = "Domus";
			
			// STUB
			Registry registry=LocateRegistry.getRegistry("localhost");
			RemoteDomusInterface rdi= (RemoteDomusInterface) registry.lookup(serviceName);
			System.out.println(rdi.getLightState());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
