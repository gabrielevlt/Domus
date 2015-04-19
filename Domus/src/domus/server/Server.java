package domus.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import domus.server.RemoteDomusInterface;

public class Server {
	Domus domus;
	static String host = "localhost"; // OR REMOTE IP ADDRESS E.G. "52.10.94.138"
	static int exportingPort = 1100;
	static int bindingPort = 1099;
	static String serviceName = "Domus";

	public Server() {
		super();
		domus = new Domus();
	}

	public static void main(String[] args) {
		// ISTANZA DEL SERVER
		Server server = new Server();

		System.out.println("\n> The service is booting:");

		// SETTING PROPRIETA' DI SISTEMA
		System.setProperty("java.rmi.server.hostname", host);

		System.out.println(" > RMI service bound to host: " + host);

		try {
			// CREATING STUB EXPORTING REMOTE OBJECT
			RemoteDomusInterface remoteObjectStub = (RemoteDomusInterface) UnicastRemoteObject.exportObject(server.domus, exportingPort);

			System.out
					.println(" > Remote object exported successfully on port: "
							+ exportingPort);

			// CREATING REGISTRY FOR THE SERVICE
			Registry registry = LocateRegistry.createRegistry(bindingPort);
			// Registry registry=LocateRegistry.getRegistry();

			System.out
					.println(" > Service's registry created successfully on port: "
							+ bindingPort);

			// BINDING SERVICE AND STUB TO THE REGISTRY
			registry.rebind(serviceName, remoteObjectStub);

			System.out
					.println(" > Service and remote object bound to the registry successfully");

			System.out.println("> The service is ready!\n");

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
