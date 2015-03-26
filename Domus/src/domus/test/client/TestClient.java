package domus.test.client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import domus.server.RemoteDomusInterface;

/*
	Classe di test, che prova ad utilizzare i metodi remoti esposti dal server RMI

*/

public class TestClient {

	public static void main(String[] args) {
		
		try {
			// NOME OGGETTO REMOTO
			String serviceName = "Domus";
			
			// STUB
			Registry registry=LocateRegistry.getRegistry("localhost");
			RemoteDomusInterface rdi= (RemoteDomusInterface) registry.lookup(serviceName);
			System.out.println(rdi.getLightState());
			rdi.setLightState(true);
			System.out.println(rdi.getLightState());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
