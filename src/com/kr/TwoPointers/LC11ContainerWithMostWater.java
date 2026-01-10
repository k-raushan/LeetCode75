package com.kr.TwoPointers;

public class LC11ContainerWithMostWater {

	public static void main(String[] args) {
		SolutionLC11 solution = new SolutionLC11();

		int[] array = { 1, 2, 10, 10, 2, 1 };
		System.out
				.println(solution.maxArea(array));

	}

}

class SolutionLC11 {
	public int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int maxWater = 0;

		while (left < right) {

			int min = Math.min(height[left],
					height[right]);

			maxWater = Math.max(maxWater,
					min * (right - left));

			while (left < right
					&& height[left] <= min) {
				left++;
			}
			while (left < right
					&& height[right] <= min) {
				right--;
			}

		}
		return maxWater;
	}
}
