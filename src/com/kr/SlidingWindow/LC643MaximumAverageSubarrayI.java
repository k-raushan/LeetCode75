package com.kr.SlidingWindow;

public class LC643MaximumAverageSubarrayI {

	public static void main(String[] args) {
		SolutionLC643 solution = new SolutionLC643();

		int[] array1 = { 1, 12, -5, -6, 50, 3 };
		System.out.println(solution
				.findMaxAverage(array1, 4));

		int[] array2 = { 5 };
		System.out.println(solution
				.findMaxAverage(array2, 1));

	}

}

class SolutionLC643 {
	public double findMaxAverage(int[] nums,
			int k) {

		double currentSum = 0;
		int i = 0;
		while (i < k) {
			currentSum = currentSum + nums[i++];
		}

		double maxSum = currentSum;

		for (i = k; i < nums.length; i++) {
			currentSum = currentSum - nums[i - k]
					+ nums[i];
			if (currentSum > maxSum)
				maxSum = currentSum;
		}

		return maxSum / k;
	}
}
