package domus.server.sensors;

public class Shutter {
	private boolean up;
	
	public Shutter(){
		this.up=false;
	}

	public boolean isUp() {
		return this.up;
	}

	public void setShutter(boolean state) {
		this.up = state;
	}
	
}
