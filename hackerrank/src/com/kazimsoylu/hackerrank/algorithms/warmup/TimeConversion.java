package com.kazimsoylu.hackerrank.algorithms.warmup;

import java.util.Scanner;

public class TimeConversion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String time = in.next();

		String suffix = time.substring(time.length() - 2, time.length());
		Integer hour = Integer.valueOf(time.substring(0, 2));

		if (suffix.equals("PM") && hour < 12) {
			hour += 12;
		} else if (suffix.equals("AM") && hour == 12) {
			hour = 0;
		}

		System.out.printf("%02d:%s", hour, time.substring(3, time.length() - 2));
	}
}
