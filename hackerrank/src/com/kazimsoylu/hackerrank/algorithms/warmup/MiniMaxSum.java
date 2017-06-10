package com.kazimsoylu.hackerrank.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[5];
		for (int arr_i = 0; arr_i < 5; arr_i++) {
			arr[arr_i] = in.nextInt();
		}

		Arrays.sort(arr);
		long max = 0, min = 0;

		for (int i = 0; i < 4; i++) {
			min += arr[i];
		}

		for (int i = arr.length - 1; i > arr.length - 5; i--) {
			max += arr[i];
		}

		System.out.printf("%d %d\n", min, max);
	}
}
