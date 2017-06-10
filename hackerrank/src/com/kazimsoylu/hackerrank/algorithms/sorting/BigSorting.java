package com.kazimsoylu.hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BigSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] unsorted = new String[n];

		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			unsorted[unsorted_i] = in.next();
		}

		in.close();

		List<String> list = Arrays.asList(unsorted);
		list.sort((s1, s2) -> {
			return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
		});

		list.forEach(System.out::println);
	}
}
