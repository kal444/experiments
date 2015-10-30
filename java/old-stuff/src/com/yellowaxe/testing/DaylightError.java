package com.yellowaxe.testing;

import java.util.Calendar;

public class DaylightError {
	/**
	 * this demostrates the bug of calculating dates with milliseconds
	 * when the US daylight saving time switches
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String startDate = "2006-04-02";
		String endDate = "2006-04-03";

		Calendar scal = Calendar.getInstance();
		scal.set(Integer.parseInt(startDate.substring(0, 4)), Integer
				.parseInt(startDate.substring(5, 7)) - 1, Integer
				.parseInt(startDate.substring(8)));

		Calendar ecal = Calendar.getInstance();
		ecal.set(Integer.parseInt(endDate.substring(0, 4)), Integer
				.parseInt(endDate.substring(5, 7)) - 1, Integer
				.parseInt(endDate.substring(8)));

		ecal.add(Calendar.DATE, 1);

		int diff = (int)(ecal.getTime().getTime()-scal.getTime().getTime())/(60*60*24*1000);

		System.out.println("number of days between " + startDate + " and "
				+ endDate + ": " + diff);
		return;
	}
}
