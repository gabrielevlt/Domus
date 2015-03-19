package domus.server.sensors;

public class Sprinkler {
	private boolean state;
	private int duty_time;
	
	public Sprinkler(){
		state=false;
		duty_time=5;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getDuty_time() {
		return duty_time;
	}

	public void setDuty_time(int duty_time) {
		this.duty_time = duty_time;
	}

}
