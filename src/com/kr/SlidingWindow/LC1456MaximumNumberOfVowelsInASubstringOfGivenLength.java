package com.kr.SlidingWindow;

public class LC1456MaximumNumberOfVowelsInASubstringOfGivenLength {

	public static void main(String[] args) {
		SolutionLC1456 solution = new SolutionLC1456();

		String s1 = "abciiidef";
		System.out.println(
				solution.maxVowels(s1, 3));
		System.out.println(
				"*****************************");

		String s2 = "aeiou";
		System.out.println(
				solution.maxVowels(s2, 2));
		System.out.println(
				"*****************************");

	}

}

class SolutionLC1456 {
	public int maxVowels(String s, int k) {

		if (s.length() < k) {
			return -1;
		}

		System.out.println(
				"s : " + s + " and k : " + k);

		char[] chars = s.toCharArray();

		int currentVowel = 0;

		int i = 0;
		while (i < k) {
			if (isVowel(chars[i]))
				currentVowel++;
			i++;
		}

		int maxVowel = currentVowel;

		System.out.println("for i = " + (i - 1)
				+ " current vowel " + currentVowel
				+ " and max " + maxVowel);

		for (i = k; i < s.length(); i++) {
			if (isVowel(chars[i - k])) {
				currentVowel--;
			}
			if (isVowel(chars[i])) {
				currentVowel++;
			}
			if (currentVowel > maxVowel) {
				maxVowel = currentVowel;
				if (maxVowel == k) {
					return k;
				}
			}
			System.out.println("for i = " + i
					+ " current vowel "
					+ currentVowel + " and max "
					+ maxVowel);
		}

		return maxVowel;

	}

	private boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i'
				|| c == 'o' || c == 'u';
	}
}
