package com.kr.ArrayString;

public class LC1768MergeStringsAlternately {

	public static void main(String[] args) {
		SolutionLC1768 solution = new SolutionLC1768();
		System.out.println(solution.mergeAlternately("abc", "pqr"));
		System.out.println(solution.mergeAlternately("ab", "pqrs"));
		System.out.println(solution.mergeAlternately("abcd", "pq"));

	}

}

class SolutionLC1768 {
	public String mergeAlternately(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();

		StringBuilder result = new StringBuilder(n1 + n2);

		int minLength = Math.min(n1, n2);

		for (int i = 0; i < minLength; i++) {
			result.append(word1.charAt(i));
			result.append(word2.charAt(i));
		}

		if (word1.length() > word2.length()) {
			result.append(word1.substring(minLength));
		} else {
			result.append(word2.substring(minLength));
		}

		return result.toString();
	}
}
