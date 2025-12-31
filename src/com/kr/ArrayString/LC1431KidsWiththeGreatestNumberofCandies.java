package com.kr.ArrayString;

import java.util.ArrayList;
import java.util.List;

public class LC1431KidsWiththeGreatestNumberofCandies {

	public static void main(String[] args) {
		SolutionLC1431 solution = new SolutionLC1431();
		int[] intArray1 = { 10, 20, 30, 40, 50, 60, 70, 80 };
		System.out.println(solution.kidsWithCandies(intArray1, 3));
		int[] intArray2 = { 4, 2, 1, 1, 2 };
		System.out.println(solution.kidsWithCandies(intArray2, 1));
		int[] intArray3 = { 12, 1, 12 };
		System.out.println(solution.kidsWithCandies(intArray3, 10));

	}
}

class SolutionLC1431 {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();

		// 1. Find the max value in the candies array
		int maxCandies = 0;
		for (int candy : candies) {
			maxCandies = Math.max(candy, maxCandies);
		}

		// 2. Loop through again and compare
		for (int candy : candies) {
			result.add((candy + extraCandies) >= maxCandies ? true : false);
		}

		return result;

	}
}
