/**
 * Day 24: LC 2390 - Removing Stars From a String
 * 
 * * Time Complexity: O(n) - We iterate through the string exactly
 * once. Both append() and deleteCharAt() for a StringBuilder are O(1)
 * operations.
 * 
 * * Space Complexity: O(n) - We use a StringBuilder to store the
 * resulting string and a char array for iteration, both proportional
 * to the input size.
 */
package com.kr.stack;

public class LC2390RemovingStarsFromAString {

	public static void main(String[] args) {
		SolutionLC2390 solution = new SolutionLC2390();

		String s1 = "leet**cod*e";
		System.out.println(
				solution.removeStars(s1));

		String s2 = "erase*****";
		System.out.println(
				solution.removeStars(s2));

	}

}

class SolutionLC2390 {
	public String removeStars(String s) {

		StringBuilder builder = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c == '*'
					&& builder.length() > 0) {
				builder.deleteCharAt(
						builder.length() - 1);
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
}
