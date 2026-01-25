/**
 * Day 26: LC 394 - Decode String
 * 
 * Time Complexity: O(MaxK * N) - Where N is the length of the string
 * and MaxK is the maximum value of the numerical multipliers. We
 * visit each character once, but the time to construct the result
 * involves appending strings multiple times based on the multipliers.
 * 
 * Space Complexity: O(M + N) - Where M is the number of letters in
 * the decoded string and N is the number of brackets (stack depth).
 * In the worst case of deep nesting, the stack stores the context for
 * each level.
 */
package com.kr.stack;

import java.util.Stack;

public class LC394DecodeString {

	public static void main(String[] args) {
		SolutionLC394 solution = new SolutionLC394();

		String s1 = "3[a]2[bc]";
		System.out.println(solution.decodeString(s1));

		String s2 = "3[a2[c]]";
		System.out.println(solution.decodeString(s2));

		String s3 = "2[abc]3[cd]ef";
		System.out.println(solution.decodeString(s3));

	}

}

class SolutionLC394 {
	public String decodeString(String s) {

		// Stack to store the repeat counts
		Stack<Integer> countStack = new Stack<>();

		// Stack to store the strings formed before entering a new '['
		Stack<StringBuilder> stringStack = new Stack<>();

		// Current working string
		StringBuilder currentString = new StringBuilder();

		// Current repeat count
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				// Build the number k (handling multi-digit numbers)
				k = k * 10 + (ch - '0');
			} else if (ch == '[') {
				// Push the number of times to repeat
				countStack.push(k);
				// Push the string built so far
				stringStack.push(currentString);

				// Reset for the new inner bracket section
				currentString = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				// Finished a section: retrieve the previous string
				// and repeat count
				StringBuilder decodedString = stringStack.pop();
				int currentK = countStack.pop();

				// Append the current section k times to the previous
				// string
				for (int i = 0; i < currentK; i++) {
					decodedString.append(currentString);
				}

				// Update currentString to point to the newly merged
				// result
				currentString = decodedString;
			} else {
				// Just a regular character, append to current string
				currentString.append(ch);
			}
		}

		return currentString.toString();
	}
}
