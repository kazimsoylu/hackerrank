package com.kazimsoylu.hackerrank.algorithms.search;

import java.util.Scanner;

public class SherlockAndArray {

	static String solve(int[] a) {
		int[] sumOfTheRight = new int[a.length];
		int[] sumOfTheLeftt = new int[a.length];

		sumOfTheRight[a.length - 1] = 0;
		sumOfTheLeftt[0] = 0;

		for (int i = a.length - 2; i >= 0; i--) {
			sumOfTheRight[i] = a[i + 1] + sumOfTheRight[i + 1];
		}

		for (int i = 1; i < a.length; i++) {
			sumOfTheLeftt[i] = a[i - 1] + sumOfTheLeftt[i - 1];
		}

		for (int i = 0; i < sumOfTheLeftt.length; i++) {
			if (sumOfTheLeftt[i] == sumOfTheRight[i]) {
				return "YES";
			}
		}

		return "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			String result = solve(a);
			System.out.println(result);
		}
	}
}
