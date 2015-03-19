package domus.server.sensors;

public class Light {
	private boolean state;
	
	public Light(){
		state=false;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
