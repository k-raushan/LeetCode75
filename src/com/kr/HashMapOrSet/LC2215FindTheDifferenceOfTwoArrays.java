/**
 * Day 20: LC 2215 - Find the Difference of Two Arrays
 * Time Complexity: O(n + m) - Building sets for both arrays and iterating through them.
 * Space Complexity: O(n + m) - Storing unique elements in HashSets.
 */
package com.kr.HashMapOrSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC2215FindTheDifferenceOfTwoArrays {

	public static void main(String[] args) {
		SolutionLC2215 solution = new SolutionLC2215();

		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 2, 4, 6 };

		System.out.println(solution
				.findDifference(array1, array2));

		System.out.println(
				"**************************************");

	}

}

class SolutionLC2215 {
	public List<List<Integer>> findDifference(
			int[] nums1, int[] nums2) {

		Set<Integer> set1 = new HashSet<Integer>();
		for (int i : nums1) {
			set1.add(i);
		}

		Set<Integer> set2 = new HashSet<Integer>();
		for (int i : nums2) {
			set2.add(i);
		}

		return Arrays.asList(
				removeElementOfSecoundFromFirst(
						set1, set2),
				removeElementOfSecoundFromFirst(
						set2, set1));

	}

	private List<Integer> removeElementOfSecoundFromFirst(
			Set<Integer> first,
			Set<Integer> second) {
		List<Integer> result = new ArrayList<Integer>();
		for (int val : first) {
			if (!second.contains(val)) {
				result.add(val);
			}
		}
		return result;
	}
}
