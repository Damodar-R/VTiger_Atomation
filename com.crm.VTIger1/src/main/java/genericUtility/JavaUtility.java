package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * this is an utility class to perform java functionality
 * @author DDR
 */
public class JavaUtility {
	/**
	 * this generic method is to get calendar
	 * @param pattern
	 * @return
	 */
	public static String getCalendarDetails(String pattern){
		Calendar cal=Calendar.getInstance();
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(d);
			
	}
	/**
	 * this generic method is to generate random number
	 * @param pattern
	 * @return
	 */
public static int generateRandamNumber(int bound) {
	Random r=new Random();
	 return r.nextInt(bound);
}
}
