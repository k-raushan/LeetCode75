/**
 * Day 22: LC 1657 - Determine if Two Strings Are Close.
 * 
 * Time Complexity: O(n) - We iterate through the strings to build
 * sets and maps. Sorting the frequency lists takes O(k log k) where k
 * is the number of unique characters (max 26), which is constant.
 * 
 * Space Complexity: O(1) - Although we use Sets and Maps, they only
 * store up to 26 unique characters, representing constant space
 * relative to the input size.
 */
package com.kr.HashMapOrSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC1657DetermineIfTwoStringsAreClose {

	public static void main(String[] args) {
		SolutionLC1657 solution = new SolutionLC1657();

		String word1 = "abc";
		String word2 = "bca";

		System.out.println(solution
				.closeStrings(word1, word2));

		System.out.println(
				"**************************************");

		word1 = "a";
		word2 = "aa";

		System.out.println(solution
				.closeStrings(word1, word2));

		System.out.println(
				"**************************************");
		word1 = "cabbba";
		word2 = "abbccc";

		System.out.println(solution
				.closeStrings(word1, word2));

		System.out.println(
				"**************************************");

	}

}

class SolutionLC1657 {

	public boolean closeStrings(String word1,
			String word2) {

		// 1. Lets check the length criteria
		if (!(word1.length() == word2.length()))
			return false;

		// 2. Character Set Check (Must have
		// exactly the same unique characters)
		Set<Character> set1 = new HashSet<Character>();
		for (char c : word1.toCharArray()) {
			set1.add(c);
		}

		Set<Character> set2 = new HashSet<Character>();
		for (char c : word2.toCharArray()) {
			set2.add(c);
		}

		if (!set1.equals(set2))
			return false;

		// 3. Frequency Distribution Check

		return getSortedList(word1)
				.equals(getSortedList(word2));

	}

	private List<Integer> getSortedList(
			String word) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : word.toCharArray()) {
			map.put(c,
					map.getOrDefault(c, 0) + 1);
		}
		List<Integer> list = new ArrayList<Integer>(
				map.values());
		Collections.sort(list);

		return list;

	}

}
