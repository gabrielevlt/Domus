package domus.server;

import domus.server.sensors.*;

public class Domus {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
