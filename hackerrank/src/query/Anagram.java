package query;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		String[] a = {"hhpddlnnsjfoyxpci","jk","abb","mn","abc"};
		String[] b = {"ioigvjqzfbpllssuj","kj","bbc","op","def"};
		
		int count[] = getMinimumDifference(a, b);	

		for (int i : count) {
			System.out.println(i);
		}

	}

	/**
	 * Time complexity : Worst case O(n*n)
	 * Space complexity : O(n) to store result. 
	 * If we interested in only finding anagram difference for an element,
	 * space complexity will be O(1)  
	 * @param a
	 * @param b
	 * @return min difference to make anagram 
	 */
    static int[] getMinimumDifference(String[] a, String[] b) {
    	
    	//takes O(n) space
    	int[] diff = new int[a.length];
    	
    	for( int i=0; i<a.length; i++ ){
    		String s1 = a[i];
    		String s2 = b[i];
    		
    		if(s1.length()!=s2.length()){
    			diff[i]=-1;  //O(1) time
    		}else{
    			
    			/*
    			 * iterate over a[i] and remove the characters of a[i] from b[i]
    			 * this operation takes O(n) time, O(1) space
    			 */
    			for( char c : s1.toCharArray() ){
    				s2=removeChar(s2, c);
    			}
    			diff[i] = s2.length();
    		}
    	}
    	
    	return diff;

    }
    
    static String removeChar(String s, char c){
    	return s.replaceFirst( Character.toString(c) , "");
    }

}
