package obj;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class Reloj extends Thread {

	JLabel reloj;
	
	public Reloj(JLabel reloj)
	{
		this.reloj=reloj;
	}

	@Override
	public void run() {
		
		while(true)
		{
			Calendar now = Calendar.getInstance();
			reloj.setText(now.get(Calendar.HOUR) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND));	
			try {
				Thread.sleep(950);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
