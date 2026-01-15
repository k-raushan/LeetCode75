package com.kr.SlidingWindow;

public class LC1493LongestSubarrayOf1sAfterDeletingOneElement {

	public static void main(String[] args) {
		SolutionLC1493 solution = new SolutionLC1493();

		int[] array1 = { 1, 1, 0, 1 };
		System.out.println(
				solution.findMaxAverage(array1));

		int[] array2 = { 0, 1, 1, 1, 0, 1, 1, 0,
				1 };
		System.out.println(
				solution.findMaxAverage(array2));

		int[] array3 = { 1, 1, 1 };
		System.out.println(
				solution.findMaxAverage(array3));

	}

}

class SolutionLC1493 {
	public int findMaxAverage(int[] nums) {

		int k = 1;
		int left = 0;
		int maxOneCount = 0;
		int zerosInWindow = 0;

		for (int right = 0; right < nums.length; right++) {
			if (nums[right] == 0) {
				zerosInWindow++;
			}

			while (zerosInWindow > k) {
				if (nums[left] == 0) {
					zerosInWindow--;
				}
				left++;
			}

			maxOneCount = Math.max(maxOneCount,
					right - left);

		}

		return maxOneCount;
	}
}
