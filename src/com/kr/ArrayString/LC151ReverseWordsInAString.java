package com.kr.ArrayString;

public class LC151ReverseWordsInAString {

	public static void main(String[] args) {
		SolutionLC151 solution = new SolutionLC151();

		System.out.println(solution.reverseWords(" the sky is blue"));

		System.out.println(solution.reverseWords(" hello world "));

		System.out.println(solution.reverseWords("a good   example"));

		System.out.println(solution.reverseWords("abc"));

		SolutionLC151A solutionLC151A = new SolutionLC151A();

		System.out.println(solutionLC151A.reverseWords(" the sky is blue"));

		System.out.println(solutionLC151A.reverseWords(" hello world "));

		System.out.println(solutionLC151A.reverseWords("a good   example"));

		System.out.println(solutionLC151A.reverseWords("abc"));

	}

}

class SolutionLC151 {
	public String reverseWords(String s) {

		StringBuilder builder = new StringBuilder();
		int leftCharAt = -1;
		int rightCharAt = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ' && rightCharAt < 0) {
				rightCharAt = i;
			}

			if (rightCharAt >= 0) {
				if (s.charAt(i) == ' ') {
					leftCharAt = i + 1;
				} else if (i == 0) {
					leftCharAt = i; // This captures the very first character
				}
			}

			if (leftCharAt >= 0 && rightCharAt >= 0) {
				if (!builder.isEmpty()) {
					builder.append(" ");
				}
				builder.append(s.substring(leftCharAt, rightCharAt + 1));
				leftCharAt = -1;
				rightCharAt = -1;
			}
		}
		return builder.toString();
	}
}

class SolutionLC151A {
	public String reverseWords(String s) {

		StringBuilder builder = new StringBuilder();

		int i = s.length() - 1;
		while (i >= 0) {
			// 1. Skip trailing spaces for the current word
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}

			// If we ran out of string after skipping spaces, stop
			if (i < 0) {
				break;
			}

			// 2. Mark the end of the word (right boundary)
			int rightCharAt = i;

			// 3. Move i backward until we hit a space (find the start of the word)
			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}

			// 4. Append a space only if we already have a word in our builder
			if (builder.length() > 0) {
				builder.append(" ");
			}

			// 5. Use substring to grab the word (from i+1 to right+1)
			builder.append(s.substring(i + 1, rightCharAt + 1));
		}

		return builder.toString();
	}
}
