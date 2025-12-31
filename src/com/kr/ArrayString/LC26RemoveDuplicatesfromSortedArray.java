package com.kr.ArrayString;

public class LC26RemoveDuplicatesfromSortedArray {

	public static int removeDuplicates(int[] nums) {
		if (nums.length >= 1) {
			int k = 1;
			int currentUnique = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] != currentUnique) {
					currentUnique = nums[i];
					nums[k++] = nums[i];
				}
				// Arrays.stream(nums).forEach(value -> System.out.print(value));
				// System.out.println();
			}
			return k;
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] i = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(i));
	}

}
