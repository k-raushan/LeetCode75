/**
 * Day 8: LC 334 - Increasing Triplet Subsequence
 * Time Complexity: O(n) - We maintain two variables (first, second) in a single pass.
 * Space Complexity: O(1) - Only two variables used regardless of input size.
 */
package com.kr.ArrayString;

public class LC334IncreasingTripletSubsequence {

	public static void main(String[] args) {
		SolutionLC334 solution = new SolutionLC334();

		int[] array1 = { 1, 2, 3, 4, 5 };
		System.out.println(solution
				.increasingTriplet(array1));

		int[] array2 = { 5, 4, 3, 2, 1 };
		System.out.println(solution
				.increasingTriplet(array2));

		int[] array3 = { 2, 1, 5, 0, 4, 6 };
		System.out.println(solution
				.increasingTriplet(array3));

	}

}

class SolutionLC334 {
	public boolean increasingTriplet(int[] nums) {

		int i = Integer.MAX_VALUE;
		int j = Integer.MAX_VALUE;

		for (int n : nums) {
			if (n <= i) {
				i = n;
			} else if (n <= j) {
				j = n;
			} else {
				return true;
			}
		}
		return false;
	}
}
