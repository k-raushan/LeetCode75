/**
 * Day 19: LC 724 - Find Pivot Index
 * Time Complexity: O(n) - Total sum calculated once, then prefix sum updated in one pass.
 * Space Complexity: O(1) - Only using total sum and left sum variables.
 */
package com.kr.PrefixSum;

public class LC724FindPivotIndex {

	public static void main(String[] args) {
		SolutionLC724 solution = new SolutionLC724();

		int[] array1 = { 1, 7, 3, 6, 5, 6 };
		System.out.println(
				solution.pivotIndex(array1));

		System.out.println(
				"**************************************");

		int[] array2 = { 1, 2, 3 };
		System.out.println(
				solution.pivotIndex(array2));

	}

}

class SolutionLC724 {
	public int pivotIndex(int[] nums) {

		int left = 0;

		int totalSum = 0;
		while (left < nums.length) {
			totalSum += nums[left++];
		}

		int leftSum = 0;
		int rightSum = 0;
		for (left = 0; left < nums.length; left++) {
			rightSum = totalSum - leftSum
					- nums[left];
			if (leftSum == rightSum) {
				System.out.println("Left : "
						+ left + " leftSum : "
						+ leftSum + " rightSum : "
						+ rightSum);
				return left;
			} else {
				System.out.println("Left : "
						+ left + " leftSum : "
						+ leftSum + " rightSum : "
						+ rightSum);
				leftSum = leftSum + nums[left];
			}

		}

		return -1;

	}
}
