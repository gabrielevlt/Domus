package domus.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	Domus domus;

	public Server() {
		super();
		domus = new Domus();
	}

	public static void main(String[] args) {
		// CREAZIONE SECURITY MANAGER
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());

		try {
			// ISTANZA DEL SERVER
			Server server = new Server();
			
			// NOME OGGETTO REMOTO
			String serviceName = "Domus";
			
			// STUB
			RemoteDomusInterface stub= (RemoteDomusInterface) UnicastRemoteObject.exportObject(server.domus, 0);
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind(serviceName, stub);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
