package com.kazimsoylu.hackerrank.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int height[] = new int[n];
		for (int height_i = 0; height_i < n; height_i++) {
			height[height_i] = in.nextInt();
		}

		Arrays.sort(height);
		int length = height.length;
		int maxElement = height[length - 1];
		int candleCount = 1;

		for (int i = length - 2; i >= 0; i--) {
			if (maxElement == height[i]) {
				candleCount++;
			} else {
				break;
			}
		}

		System.out.println(candleCount);
	}
}
