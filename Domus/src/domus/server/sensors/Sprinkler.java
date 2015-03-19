package domus.server.sensors;

public class Sprinkler {
	private boolean working;
	private int dutyTime;
	
	public Sprinkler(){
		this.working=false;
		this.dutyTime=5;
	}

	public boolean isWorking() {
		return this.working;
	}

	public void setSprinkler(boolean state) {
		this.working = state;
	}

	public int getDutyTime() {
		return this.dutyTime;
	}

	public void setDutyTime(int dutyTime) {
		this.dutyTime = dutyTime;
	}

}
