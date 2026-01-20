/**
 * Day 5: LC 345 - Reverse Vowels of a String
 * Time Complexity: O(n) - Two-pointer approach visits each character once.
 * Space Complexity: O(n) - Required for the character array to perform swaps.
 */
package com.kr.ArrayString;

public class LC345ReverseVowelsOfAString {

	public static void main(String[] args) {
		SolutionLC345 solution = new SolutionLC345();

		System.out.println(solution
				.reverseVowels("IceCreAm"));

		System.out.println(solution
				.reverseVowels("leetcode"));

	}

}

class SolutionLC345 {
	public String reverseVowels(String s) {
		int i = 0;
		int j = s.length() - 1;
		char[] array = s.toCharArray();
		while (i < j) {
			while (i < j && !isVowel(array[i])) {
				i++;
			}
			while (i < j && !isVowel(array[j])) {
				j--;
			}
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		s = String.valueOf(array);
		return s;
	}

	private boolean isVowel(char c) {
		return "aeiouAEIOU".indexOf(c) != -1;
	}
}
