/**
 * Day 16: LC 1004 - Max Consecutive Ones III
 * Time Complexity: O(n) - Sliding window expands right and contracts left when k is exceeded.
 * Space Complexity: O(1) - Only pointer variables used.
 */
package com.kr.SlidingWindow;

public class LC1004MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		SolutionLC1004 solution = new SolutionLC1004();

		int[] array1 = { 1, 1, 1, 0, 0, 0, 1, 1,
				1, 1, 0 };
		System.out.println(solution
				.findMaxAverage(array1, 2));

		int[] array2 = { 0, 0, 1, 1, 0, 0, 1, 1,
				1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		System.out.println(solution
				.findMaxAverage(array2, 3));

	}

}

class SolutionLC1004 {
	public int findMaxAverage(int[] nums, int k) {

		int left = 0;
		int maxOneCount = 0;
		int zerosInWindow = 0;

		for (int right = 0; right < nums.length; right++) {
			// 1. Expand: If we see a 0, count it
			if (nums[right] == 0) {
				zerosInWindow++;
			}

			// 2. Shrink: While we have more than 'k' zeros, move left
			while (zerosInWindow > k) {
				if (nums[left] == 0) {
					zerosInWindow--;
				}
				left++;
			}

			// 3. Record: The window [left...right] is now valid
			// The length is (right - left + 1)
			maxOneCount = Math.max(maxOneCount,
					right - left + 1);
		}

		return maxOneCount;
	}
}
