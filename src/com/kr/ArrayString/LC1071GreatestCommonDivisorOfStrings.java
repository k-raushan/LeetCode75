package com.kr.ArrayString;

public class LC1071GreatestCommonDivisorOfStrings {

	public static void main(String[] args) {
		SolutionLC1071 solution = new SolutionLC1071();
		System.out.println(solution.gcdOfStrings("ABCABC", "ABC"));
		System.out.println(solution.gcdOfStrings("ABABAB", "ABAB"));
		System.out.println(solution.gcdOfStrings("LEET", "CODE"));
		System.out.println(solution.gcdOfStrings("AAAAAB", "AAA"));

	}
}

class SolutionLC1071 {

	public String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		} else {
			int gcdLength = getGCD(str1.length(), str2.length());
			return str1.substring(0, gcdLength);
		}
	}

	public int getGCD(int l1, int l2) {
		return (l2 == 0) ? l1 : getGCD(l2, l1 % l2);
	}

}