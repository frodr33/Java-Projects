package stringarrayprac;

public class URLify {
	/*
	 * Write a method to replace all spaces
	 *  in a string with '%20: You may assume 
	 *  that the string has sufficient space 
	 *  at the end to hold the additional characters,
	 *  and that you are given the "true" length
	 *  of the string. (Note: if implementing in 
	 *  Java, please use a character array so that
	 *  you can perform this operation in place.
	 *  
	 *  EX. 
	 *  	input: "Mr John Smith    " , 13
	 *  	output: "Mr%20John%20Smith"
	 */
	
	/*
	 * Precondition:
	 * 	There is enough space in 
	 * 	char array to hold string
	 * 
	 * 	Keeps two loop pointers and a
	 * 	last variable to keep track of 
	 *  multiple spaces
	 *  
	 *  Solution not correct, supposed to
	 *  be done in place!
	 */
	public static String makeURL(String str, Integer length) {
		int j = 0;
		boolean last = false;
		char[] arr = new char[length*3]; // most cases
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == ' ' && last == false) {
				arr[j] = '%';
				arr[j + 1] = '2';
				arr[j + 2] = '0';
				j += 3;
				last = true;
			} else if (str.charAt(i) == ' '){
				j++;
				
			} else {
				arr[j] = str.charAt(i);
				j++;
				last = false;		
			}
		}
		return new String(arr);
	}
	
	/* SOLUTION: Done in place!
	 * APPROACH: TWO-SCAN
	 * 	1st Scan: Counts Spaces
	 * 	2nd Scan: Goes backwards and
	 * 	if there is a space puts %20 
	 *  before that index! Dont have to
	 *  worry about overwriting data bc
	 *  "index" is the exact length of
	 *  the new string
	 * 
	 */
	public static String makeURLSOL(char[] str, Integer length) {
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		
		int index = length + spaceCount * 2;
		for (int i = length - 1 ; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;

			} else {
				str[index - 1] = str[i];
				index--;
			}	
		}
		return "";
	}
	
	public static void main(String args[]) {
		System.out.println(makeURL("Mr John Smith    ", 13));
		
	}
}
