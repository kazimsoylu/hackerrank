package com.kazimsoylu.hackerrank.algorithms.strings;

import java.util.Scanner;

public class SuperReducedString {

	 static String super_reduced_string(String s) {

			while (true) {
				String temp = s;
				s = reduce(s);

				if (s.equals(temp)) {
					return s;
				}
				if (s.length() == 0) {
					return "Empty String";
				}
				if (s.length() < 2) {
					break;
				}
			}

			return s;
		}

		static String reduce(String s) {

			if (s.length() < 2) {
				return s;
			}

			if (s.charAt(0) != s.charAt(1)) {
				return s.charAt(0) + reduce(s.substring(1));
			}
			else {
				return reduce(s.substring(2));
			}
		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			String s = in.next();
			String result = super_reduced_string(s);
			System.out.println(result);
		}
}
