package stringarrayprac;

public class ex1 {
	
	/*
	Is Unique: Implement an algorithm to determine 
	if a string has all unique characters. What if you
	cannot use additional data structures?
	*/
	
	
	
	/* First Solution:
	 * 	Creates an array of boolean values
	 * 	to keep track of which char's have
	 * 	been used already. Notice that we
	 * 	cast from char to int.
	 * 
	 * Complexity:
	 * 	Time: O(n)
	 * 	Space: O(1)
	 * 
	 */
	public static boolean isUnique(String str) {
		if (str.length() > 128) return false;
		
		boolean[] arr = new boolean[128]; // 128 char alphabet
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (arr[val]) {
				return false;
				
			} else {
				arr[val] = true;
				
			}
		}
		return true;
	}
	
	
    /* Second Solution:
     * 	(No Additional Data Structures)
     * 
     * 	2 For loops to check a single char
     *  with every other char in the string
     *  
     * Complexity:
     *  Time: O(n^2)
     * 
     */
	public static boolean isUniqueNoDS(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			char curr_char = str.charAt(i);
			for (int j = 0; j < str.length(); j++) {
				if (curr_char == str.charAt(j) && i != j) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	
	public static void main(String args[]) {
		
		System.out.println(isUnique("Hello"));
		System.out.println(isUniqueNoDS("Hello"));		
		System.out.println(isUniqueNoDS("abcde-"));		
		System.out.println(isUnique("abcde-"));		
		
	}
}
