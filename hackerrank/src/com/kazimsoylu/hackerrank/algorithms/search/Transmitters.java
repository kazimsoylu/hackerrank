package com.kazimsoylu.hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class Transmitters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfHouses = in.nextInt();
		int range = in.nextInt();
		int[] houses = new int[numberOfHouses];
		for (int x_i = 0; x_i < numberOfHouses; x_i++) {
			houses[x_i] = in.nextInt();
		}
		in.close();

		Arrays.sort(houses);

		int lastHouse = houses[houses.length - 1];
		int[] array = new int[lastHouse + 1];

		for (int house : houses) {
			array[house] = 1;
		}

		int transmitterCount = putTransmitter(array, houses,houses[0], true, range);
		System.out.println(transmitterCount);

	}

	private static int putTransmitter(int[] array, int[] houses ,int start, boolean firstHouse, int range) {

		int currentIndex = start;

		if (currentIndex == array.length-1){
			System.out.println("T:"+currentIndex);
			return 1;
		}
		else if(currentIndex>array.length){
			return 0;
		}
		
		if( array[currentIndex]==0 ){
			while (currentIndex < array.length) {
				if (array[currentIndex] == 0) {
					currentIndex++;
				}
				else
					break;
			}
		}

		currentIndex = incrementIndex(currentIndex, range, array.length);

		// check if the house exists at currentIndex
		if (array[currentIndex] == 1) {
			System.out.println("T:"+currentIndex);
			currentIndex += range+1;
			return 1 + putTransmitter(array, houses,currentIndex, false, range);
		} else {
			currentIndex--;
			while (currentIndex >= start) {
				if (array[currentIndex] == 1) {
					System.out.println("T:"+currentIndex);
					return 1 + putTransmitter(array, houses, currentIndex + range + 1, false, range);
				} else {
					currentIndex--;
				}
			}
		}

		return 0;

	}
	
	private static int incrementIndex(int index, int increment ,int size){
		index += increment;
		if( index >= size ){
			index = size-1;
		}
		
		return index;
	}

}
