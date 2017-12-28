package stringarrayprac;

import java.util.Arrays;

public class CheckPermutation {

	/*
	Check Permutation: Given two strings,
	write a method to decide if one is a 
	permutation of the other
	
	NOTE: This can easily be done 
	with HashSet, think of something
	else though
	
	NOTE: Brute force, 3 for loops, 
	not nested
	*/
	
	
	
	
	/* Method 1:
	 *  Sort the string by first converting 
	 *  it into a char array and then using
	 *  Array.sort(), which implements merge
	 *  sort, O(n log n)
	 */ 
	public static boolean isPerm_1(String str1, String str2) {
		if (str1.length() != str2.length()) return false;

		return sort(str1).equals(sort(str2)); 
	}
	
	public static String sort(String str) {
		char[] content = str.toCharArray();	
		Arrays.sort(content);
		
		// Need "new String()" because
		// we are creating a new object
		// kind of like String str = new String("");
		return new String(content);
	}
	
	/////////////////////////////////////////////////////////////
	
	/* Method 2
	 * 	This method will check if a 
	 * 	a string is a permutation simply 
	 *  by using an array
	 */
	
	public static boolean isPerm_2(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		int[] letters = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			letters[str1.charAt(i)]++;
		}
		
		for (int j = 0; j < str2.length(); j++) {
			char indx = str2.charAt(j);
			letters[indx]--;
			if (letters[indx] < 0) return false;
		}
		
		return true;
	}
	
	
	public static void main(String args[]) {
		System.out.println(isPerm_1("hello", "elloh"));
		System.out.println(isPerm_2("hello", "elloh"));
	}
	
}
