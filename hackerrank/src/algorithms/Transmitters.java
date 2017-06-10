package algorithms;

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
		
		Arrays.sort( houses );
		
		int lastHouse = houses[houses.length-1];
		int[] array = new int[lastHouse+1];
		
		for( int house : houses ){
			array[house] = 1;
		}
		
		int firstHouse = houses[0];
		int currentIndex = firstHouse;
		
		int transmitterCount = 0;
		
		while(currentIndex<lastHouse){
			int temp = currentIndex;
			if( currentIndex==firstHouse && transmitterCount==0 ){
				//currentIndex += range;
				currentIndex = incrementIndex(currentIndex, range, array.length);
								
				if( array[currentIndex]==1 ){
					transmitterCount++;
					System.out.println("Transmitter on : "+currentIndex);
				}
				else{
					currentIndex--;
					while( currentIndex>= temp ){
						if( array[currentIndex] == 1 ){
							transmitterCount++;
							System.out.println("Transmitter on : "+currentIndex);
							break;
						}else{
							currentIndex--;
						}
					}
					
				}
			}else{
				int i = Arrays.binarySearch(houses, currentIndex );
				if(i==houses.length-1){
					currentIndex=i;
					transmitterCount++;
					System.out.println("Transmitter on : "+currentIndex);
					break;
				}
				else{
					currentIndex =  houses[i+1];
					int j = Arrays.binarySearch(houses, incrementIndex(currentIndex, range, array.length) );
					if( j<0 ){
						transmitterCount++;
						System.out.println("Transmitter on : "+currentIndex);
					}
				}
				
				temp = currentIndex;
				currentIndex = incrementIndex(currentIndex, range*2, array.length);
				
				while( currentIndex>= temp ){
					if( array[currentIndex] == 1 ){
						transmitterCount++;
						System.out.println("Transmitter on : "+currentIndex);
						break;
					}else{
						currentIndex--;
					}
				}
			}
		}
		
		System.out.println(transmitterCount);
	}
	
	private static int incrementIndex(int index, int increment ,int size){
		index += increment;
		if( index >= size ){
			index = size-1;
		}
		
		return index;
	}

}
