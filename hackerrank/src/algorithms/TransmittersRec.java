package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TransmittersRec {

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
		
		int[] locations = new int[houses[houses.length-1]+1];
		for( int i=0;i<houses.length;i++ ){
			locations[houses[i]]=houses[i];
		}
	
		
		int transmitterCount = setupTransmitter(locations,houses, houses[0],range);
		System.out.println(transmitterCount);
	}
	
	public static int setupTransmitter(int[] locations, int[] houses ,int currentIndex,int range){
		int previous = currentIndex;
		
		if(currentIndex>=locations.length ){
			return 0;
		}
		else if(currentIndex==locations.length-1){
			System.out.println(currentIndex+" setup");
			return 1;
		}
			
		
		if(currentIndex==houses[0]){
			
			if(currentIndex>locations.length){
				currentIndex -= currentIndex-locations.length;
			}
			//System.out.println(currentIndex+" setup");
			currentIndex = currentIndex+2*range >= locations.length ? locations.length-1 : currentIndex+2*range;
			if(locations[currentIndex]==0){
				currentIndex--;
			}
			return setupTransmitter(locations, houses,currentIndex, range);
		}
		else{
			if(locations[currentIndex]==0){
				return setupTransmitter(locations, houses,currentIndex-1, range);
			}
			
			if(currentIndex>houses[houses.length-1]){
				currentIndex = houses[houses.length-1];
				
				if( currentIndex-previous>=range ){
					System.out.println(currentIndex+" setup");
					currentIndex = currentIndex+2*range >= locations.length ? locations.length-1 : currentIndex+2*range;
					return 1+setupTransmitter(locations, houses,currentIndex, range);
				}
				else
					return 0;
			}
			
			if(locations[currentIndex]==0){
				currentIndex++;
			}
			System.out.println(locations[currentIndex]+" setup");		
			currentIndex = currentIndex+2*range >= locations.length ? locations.length-1 : currentIndex+2*range;
			return 1+setupTransmitter(locations, houses,currentIndex, range);
		}
	}

}
