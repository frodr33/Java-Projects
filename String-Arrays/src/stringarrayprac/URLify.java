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
	
	
	
	public static void main(String args[]) {
		System.out.println(makeURL("Mr John Smith    ", 13));
		
	}
}
