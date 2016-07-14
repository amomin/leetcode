package reverseVowelsOfString;

// NOTES ON SOLUTION:
//
// TIME: about 1 hr (!!)
//
// Things I had to look up
// Basics about chars in java - casting between ints and chars is ok
// String - how to set character at
// MAJOR - strings are IMMUTABLE - use string builder

// Errors:
// Line 15: error: for-each not applicable to expression type (for each loop on s)
// Line 15: error: for-each not applicable to expression type (again)
// Line 17: error: array required, but String found (use charAt method)
// Line 22: error: bad operand type String for unary operator '++' (s++ should be j++)
// Line 31: java.lang.StringIndexOutOfBoundsException: String index out of range: 0
//       (initialize string builder with value s)
//
// INCORRECT ASSUMPTIONS / QUESTIONS UNASKED:
// * Assumption that only lower case letters are vowels was incorrect.
// * FORGOT TO ASK IF y IS A VOWEL!

import java.util.ArrayList;

public class Solution implements ISolution {

	/* Notes:
	 * 	char a = (char) 96 + 1;
	 * 	char e = (char) (96 + 5);
	 * 	char i = (char) (96 + 9);
	 * 	char o = (char) (96 + 15);
	 * 	char u = (char) (96 + 21);
	 * 
	 *  Strategy 1:
	 *  Pass through string once to collect all vowels, store in an arraylist
	 *  Pass through again, replace with elements of the array list in reversed order.
	 */
	
	private boolean isVowel(char x) {
		//int i = (int) x;
		//return i == 97 || i == 101 || i == 105 || i ==111 || i == 117;
		//return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
		return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ||
		    x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U';
	}

    /*	
	 *  Strategy 1:
	 *  Pass through string once to collect all vowels, store in an arraylist
	 *  Pass through again, replace with elements of the array list in reversed order.
	 */

	public String reverseVowels(String s) {
		ArrayList<Character> vowels = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
		    if (isVowel(s.charAt(i))) {
		        vowels.add(s.charAt(i));
		    }
		}
		StringBuilder sb = new StringBuilder(s);
		int vowelPointer = vowels.size() - 1;
		for (int j = 0; j < s.length(); j++) {
		    char c = s.charAt(j);
		    if (isVowel(c)) {
		        char vowel = vowels.get(vowelPointer);
		        //s[j] = vowel;
		        vowelPointer--;
		        sb.setCharAt(j, vowel);
		    } else {
		        sb.setCharAt(j, c);
		    }
		}
		return sb.toString();
	}

}
