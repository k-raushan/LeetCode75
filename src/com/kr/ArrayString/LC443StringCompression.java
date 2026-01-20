/**
 * Day 9: LC 443 - String Compression
 * Time Complexity: O(n) - Single pass through the array with two pointers.
 * Space Complexity: O(1) - Modifying the input array in-place.
 */
package com.kr.ArrayString;

public class LC443StringCompression {

	public static void main(String[] args) {
		SolutionLC443 solution = new SolutionLC443();

		char[] array1 = { 'a', 'a', 'b', 'b', 'c',
				'c', 'c' };
		System.out.println(
				solution.compress(array1));

		char[] array2 = { 'a' };
		System.out.println(
				solution.compress(array2));

		char[] array3 = { 'a', 'b', 'b', 'b', 'b',
				'b', 'b', 'b', 'b', 'b', 'b', 'b',
				'b' };
		System.out.println(
				solution.compress(array3));

	}

}

class SolutionLC443 {
	public int compress(char[] chars) {

		int write = 0; // Where we write the result
		int index = 0; // Use a single pointer for reading

		while (index < chars.length) {
			char currentChar = chars[index];
			int count = 0;

			// Count consecutive characters
			while (index < chars.length
					&& chars[index] == currentChar) {
				index++;
				count++;
			}

			// Write the character
			chars[write++] = currentChar;

			// Write the count digits
			if (count > 1) {
				for (char c : Integer
						.toString(count)
						.toCharArray()) {
					chars[write++] = c;
				}
			}
		}

		return write;
	}
}
