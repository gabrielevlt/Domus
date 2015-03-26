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

		try {
			// ISTANZA DEL SERVER
			Server server = new Server();
			
			// NOME OGGETTO REMOTO
			String serviceName = "Domus";
			
			// STUB
			RemoteDomusInterface stub= (RemoteDomusInterface) UnicastRemoteObject.exportObject(server.domus, 0);
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind(serviceName, stub);
			
			System.out.println("Server avviato!");;
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
