/**
 * Day 21: LC 1207 - Unique Number of Occurrences
 * Time Complexity: O(n) - Building a frequency map and then a set of those frequencies.
 * Space Complexity: O(n) - Storing frequencies in a HashMap and counts in a HashSet.
 */
package com.kr.HashMapOrSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC1207UniqueNumberOfOccurrences {

	public static void main(String[] args) {
		SolutionLC1207 solution = new SolutionLC1207();

		int[] array1 = { 1, 2, 2, 1, 1, 3 };

		System.out.println(solution
				.uniqueOccurrences(array1));

		System.out.println(
				"**************************************");

		int[] array2 = { 1, 2 };

		System.out.println(solution
				.uniqueOccurrences(array2));

		System.out.println(
				"**************************************");
		int[] array3 = { -3, 0, 1, -3, 1, 1, 1,
				-3, 10, 0 };

		System.out.println(solution
				.uniqueOccurrences(array3));

		System.out.println(
				"**************************************");

	}

}

class SolutionLC1207 {
	public boolean uniqueOccurrences(int[] arr) {

		HashMap<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
		for (int i : arr) {
			inputMap.put(i,
					inputMap.getOrDefault(i, 0)
							+ 1);
		}
		System.out.println(inputMap);

		Set<Integer> countSet = new HashSet<Integer>();
		for (int i : inputMap.values()) {
			if (!countSet.add(i)) {
				return false;
			}
		}
		return true;
	}

}
