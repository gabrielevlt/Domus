package domus.test.client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.*;
import java.io.*;

import domus.server.RemoteDomusInterface;

/*
	Classe di test, che prova ad utilizzare i metodi remoti esposti dal server RMI

*/

public class TestClient {

	public static void main(String[] args) {
		
		try {
			/*URL myip=new URL("http://checkip.amazonaws.com");
			BufferedReader in=new BufferedReader(new InputStreamReader(myip.openStream()));
			String ip=in.readLine();
			System.out.println("your remote ip is: "+ip);
			
			System.setProperty("java.rmi.server.hostname", ip);*/
			// NOME OGGETTO REMOTO
			String serviceName = "Domus";
			
			// STUB
			Registry registry=LocateRegistry.getRegistry("52.10.94.138");
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
