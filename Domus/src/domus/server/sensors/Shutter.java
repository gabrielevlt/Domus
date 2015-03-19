package domus.server.sensors;

public class Shutter {
	private boolean state;
	
	private Shutter(){
		state=false;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
