package stringarrayprac;
import java.util.HashMap;
public class IsPalindrome {

	/*
	 * Palindrome Permutation: Given a string,
	 * write a function to check if it is a 
	 * permutation of a palindrome. A palindrome 
	 * is a word or phrase that is the same forwards
	 * and backwards. A permutation is a rearrangement
	 * of letters. The palindrome does not need to 
	 * be limited to just dictionary words
	 * 
	 * EX.
	 * 	input: Tact Coa
	 * 	Output: True("taco cat", "atco cta", etc)
	 */
	
	
	/* Check if a string is a palindrome. 
	 * This method checks to see if there is
	 * and even number of all characters except
	 * one AT MOST. Then it will be a palindrome
	 * 
	 * Complexity: O(2n) is O(n) 
	 * 
	 */
	public static boolean isPalindrome(String str) {
		boolean oneOdd = false;
		HashMap<Character, Integer> Hm = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char charVal = str.charAt(i);
			if (charVal != ' ') {
				
				/* If letter not already in hashmap
				 * add it, and if it is then make its
				 * value increase by one. Then you can loop
				 * through the values and make sure
				 * there is only one odd
				 */
				if (!Hm.containsKey(str.charAt(i))){
					Hm.put(str.charAt(i), 1);
					
				} else {
					int curr_val = Hm.get(str.charAt(i));
					Hm.put(str.charAt(i), curr_val + 1);
					
				}
			}
		}
		for (Integer i : Hm.values()) {
			if (i % 2 == 1 && oneOdd == false) {
				oneOdd = true;
				if (Hm.get(str.charAt(str.length()/2 + 1)) 
						!= i) {
					return false;
					
				}
			} else if (i % 2 == 1) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("HeellH"));
	}
}
