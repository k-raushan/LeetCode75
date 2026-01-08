package com.kr.TwoPointers;

public class LC392IsSubsequence {

	public static void main(String[] args) {
		SolutionLC392 solution = new SolutionLC392();

		System.out.println(solution
				.isSubsequence("abc", "ahbgdc"));

		System.out.println(solution
				.isSubsequence("axc", "ahbgdc"));

	}

}

class SolutionLC392 {
	public boolean isSubsequence(String s,
			String t) {
		if (s.length() == 0)
			return true;

		if (s.length() > t.length())
			return false;

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		int sIndex = 0;
		int tIndex = 0;

		while (tIndex < tArr.length) {
			if (tArr[tIndex] == sArr[sIndex]) {
				sIndex++;
			}
			if (sIndex == sArr.length) {
				return true;
			}
			tIndex++;
		}

		return false;
	}
}
