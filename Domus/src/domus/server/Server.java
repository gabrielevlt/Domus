package domus.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import domus.server.RemoteDomusInterface;

public class Server {
	Domus domus;

	public Server() {
		super();
		domus = new Domus();
	}

	public static void main(String[] args) {
		// SETTING PROPRIETA' DI SISTEMA
		System.setProperty("java.rmi.server.hostname", "52.10.94.138");

		try {
			// ISTANZA DEL SERVER
			Server server = new Server();
			
			// NOME OGGETTO REMOTO
			String serviceName = "Domus";
			
			// STUB
			RemoteDomusInterface stub= (RemoteDomusInterface) UnicastRemoteObject.exportObject(server.domus, 1100);
			Registry registry=LocateRegistry.createRegistry(1099);
			registry.rebind(serviceName, stub);
			
			System.out.println("Server avviato!");;
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
