package com.yellowaxe.timezone;
import java.util.TimeZone;

public class DefaultTimeZoneTester {
	public static void main(String[] args) {
		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz.getID());
		System.out.println(tz.getDisplayName());
	}
}
