package domus.server.sensors;

public class Light {
	private boolean turnedOn;
	
	public Light(){
		this.turnedOn=false;
	}

	public boolean isTurnedOn() {
		return this.turnedOn;
	}

	public void setLight(boolean state) {
		this.turnedOn = state;
	}

}
