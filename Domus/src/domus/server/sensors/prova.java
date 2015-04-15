package domus.server.sensors;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class prova {

	public static void main(String[] args) {
		SimpleDateFormat df= new SimpleDateFormat("HH:mm");
		Calendar c=Calendar.getInstance();
		Calendar actual=Calendar.getInstance();
		actual.setTime(new Date());
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 16);
		c.set(Calendar.MINUTE, 40);
		
		System.out.println(df.format(c.getTime()));
		System.out.println(df.format(actual.getTime()));
		System.out.println(df.format(c.getTime()).equals(df.format(actual.getTime())));
		
		/*SimpleDateFormat df= new SimpleDateFormat("HH:mm");
		Date date=new Date();
		System.out.println(df.format(date));
		String orachevoglio="16:15";
		System.out.println(orachevoglio);
		System.out.println(orachevoglio.equals(df.format(date)));*/

	}

}
