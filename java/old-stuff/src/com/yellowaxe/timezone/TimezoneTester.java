package com.yellowaxe.timezone;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimezoneTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Do we use DST? "
				+ TimeZone.getDefault().useDaylightTime());

		/*
		 * The bill amends the Uniform Time Act of 1966 by changing the start
		 * and end dates of daylight saving time, beginning in 2007. Clocks were
		 * set ahead one hour on the second Sunday of March (March 11, 2007)
		 * instead of on the first Sunday of April (April 1, 2007). Clocks were
		 * set back one hour on the first Sunday in November (November 4, 2007),
		 * rather than on the last Sunday of October (October 28, 2007).
		 */

		Calendar dst[] = { new GregorianCalendar(2007, 3 - 1, 10),
				new GregorianCalendar(2007, 3 - 1, 12),
				new GregorianCalendar(2007, 11 - 1, 3),
				new GregorianCalendar(2007, 11 - 1, 5) };

		for (int i = 0; i < dst.length; i++) {
			Calendar cal = dst[i];

			System.out.println("Is " + cal.getTime() + " in DST? "
					+ TimeZone.getDefault().inDaylightTime(cal.getTime()));
		}
	}

}
