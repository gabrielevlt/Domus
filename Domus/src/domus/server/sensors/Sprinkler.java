package domus.server.sensors;

import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Sprinkler implements Runnable{
	private boolean working;
	private int dutyTime;
	private DateFormat dateFormat;
	Thread sprinklerBehaviour;
	
	public Sprinkler(){
		this.working=false;
		this.dutyTime=5;
		this.dateFormat = new SimpleDateFormat("HH:mm:ss"+", "+"dd/MM/yy");
		sprinklerBehaviour = new Thread(this, "sprinkler");
		sprinklerBehaviour.start();
	}

	public boolean isWorking() {
		return this.working;
	}

	public void setSprinkler(boolean state) {
		this.working = state;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: sprinkler is "
				+ working);
	}

	public int getDutyTime() {
		return this.dutyTime;
	}

	public void setDutyTime(int dutyTime) {
		this.dutyTime = dutyTime;
		System.out.println(Thread.currentThread() + " @ ["
				+ dateFormat.format(new Date()) + "] says: new duty time is "
				+ dutyTime);
	}
	
	public void run(){
		try{
			Random random=new Random();
			int randomInt;
			while(true){
				Thread.sleep(1000);
				if(working)
					Thread.sleep(dutyTime*1000);
				else{
					randomInt=random.nextInt(600);
					while((randomInt%dutyTime)!=0)
						randomInt=random.nextInt(600);
					System.out.println(Thread.currentThread() + " @ ["
							+ dateFormat.format(new Date()) + "] says: next duty cycle in about "
							+ randomInt/60 +" minutes");
					Thread.sleep(randomInt*1000);
					if(!working)
						setSprinkler(true);
					Thread.sleep(dutyTime*1000);
					setSprinkler(false);
				}
			}
		} catch(InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrotto");
		}
	}
	
	public static void main(String[] args){
		new Sprinkler();
	}

}
