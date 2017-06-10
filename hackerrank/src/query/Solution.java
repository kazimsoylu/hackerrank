package query;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] nums = { 2, 10, 5, 4, 8 };
		int[] maxes = { 3, 1, 7, 8 };

		int[] count = counts(nums, maxes);

		for (int i : count) {
			System.out.println(i);
		}

		System.out.println();

		int[] num = { 1, 4, 2, 4 };
		int[] maxe = { 3, 5 };
		count = counts(num, maxe);

		for (int i : count) {
			System.out.println(i);
		}
	}

	/*
	 * Sorts the nums array, and applys binary search for all elements in maxes
	 * array Sorting takes nlogn ( quick sort ) Binary search takes logn Looping
	 * for maxes takes n Time complexity => O(nlogn)+O(nlogn) = O(nlogn)
	 * 
	 * Spatial analysis: count array takes O(n) Quick sort has O(logn) space
	 * complexity ( but Java uses modified version, so it can be different )
	 * Binary search has O(1) space complexity
	 */
	static int[] counts(int[] nums, int[] maxes) {

		int[] count = new int[maxes.length];

		// sort nums array to apply binary search
		Arrays.sort(nums);

		for (int i = 0; i < maxes.length; i++) {
			/*
			 * find the location of the maxes[i] in nums array if maxes[i] does
			 * not exist in nums array find the point at which the key would be
			 * inserted into the array ( Arrays.binarySearch provides this )
			 */
			int index = Arrays.binarySearch(nums, maxes[i]); // binary search
																// takes O(logn)
			// if index is negative, the key does not exist in the array and
			// index = -insertion_point-1
			if (index < 0) {
				index = (index * -1) - 1;
			} else if (index >= 0) {
				index++;
			}

			count[i] = index;

		}

		return count;
	}

}
