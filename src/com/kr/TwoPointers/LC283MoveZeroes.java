package com.kr.TwoPointers;

import java.util.Arrays;

public class LC283MoveZeroes {

	public static void main(String[] args) {
		SolutionLC283 solution = new SolutionLC283();

		int[] array1 = { 0, 1, 0, 3, 12 };
		solution.moveZeroes(array1);
		System.out.println(Arrays.toString(array1));

		int[] array2 = { 0 };
		solution.moveZeroes(array2);
		System.out.println(Arrays.toString(array2));

	}

}

class SolutionLC283 {
	public void moveZeroes(int[] nums) {

		int nonZeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[nonZeroIndex] = nums[i];
				if (nonZeroIndex != i) {
					nums[i] = 0;
				}
				nonZeroIndex++;
			}
		}

	}
}
