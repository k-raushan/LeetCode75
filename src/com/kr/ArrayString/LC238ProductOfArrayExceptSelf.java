package com.kr.ArrayString;

import java.util.Arrays;

public class LC238ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		SolutionLC238 solution = new SolutionLC238();
		SolutionLC238A lc238a = new SolutionLC238A();

		int[] array1 = { 7, 2, 3, 4 };
		System.out.println(Arrays.toString(solution.productExceptSelf(array1)));
		System.out.println(Arrays.toString(lc238a.productExceptSelf(array1)));

		int[] array2 = { -1, 1, 0, -3, 3 };
		System.out.println(Arrays.toString(solution.productExceptSelf(array2)));
		System.out.println(Arrays.toString(lc238a.productExceptSelf(array2)));

	}

}

class SolutionLC238 {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int j = 0;
			result[i] = 1;
			while (j < nums.length) {
				if (i != j) {
					result[i] = result[i] * nums[j];
				}
				j++;
			}
		}
		return result;
	}
}

class SolutionLC238A {
	public int[] productExceptSelf(int[] nums) {

		int length = nums.length;

		int[] result = new int[length];

		result[0] = 1;

		for (int i = 1; i < length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}

		int rightProduct = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] = result[i] * rightProduct;
			rightProduct = rightProduct * nums[i];
		}

		return result;
	}
}
