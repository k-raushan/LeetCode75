package com.kr.TwoPointers;

import java.util.Arrays;

public class LC1679MaxNumberOfKSumPairs {

	public static void main(String[] args) {
		SolutionLC1679 solution = new SolutionLC1679();

		int[] array1 = { 1, 2, 3, 4 };
		System.out.println(solution
				.maxOperations(array1, 5));

		int[] array2 = { 3, 1, 3, 4, 3 };
		System.out.println(solution
				.maxOperations(array2, 6));

		int[] array3 = { 3, 3, 3, 3 };
		System.out.println(solution
				.maxOperations(array3, 6));

	}

}

class SolutionLC1679 {
	public int maxOperations(int[] nums, int k) {

		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int pairs = 0;

		while (left < right) {
			int sum = nums[left] + nums[right];

			if (sum == k) {
				pairs++;
				left++;
				right--;
			} else if (sum < k) {
				left++;
			} else {
				right--;
			}
		}

		return pairs;
	}
}
