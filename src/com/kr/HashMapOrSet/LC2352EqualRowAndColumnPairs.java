/**
 * Day 23: LC 2352 - Equal Row and Column Pairs
 * 
 * Time Complexity: O(N^2) - We iterate through the N x N grid.
 * Creating each list takes O(N), and hashing/comparing a list of size
 * N takes O(N). Total: N * O(N) = O(N^2).
 * 
 * Space Complexity: O(N^2) - We store all N rows (each of size N) in
 * the HashMap. The column lists are processed one-by-one, keeping
 * auxiliary space at O(N^2).
 */
package com.kr.HashMapOrSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2352EqualRowAndColumnPairs {

	public static void main(String[] args) {
		SolutionLC2352 solution = new SolutionLC2352();
		SolutionLC2352_A solution_A = new SolutionLC2352_A();

		int[][] grid1 = { { 3, 2, 1 },
				{ 1, 7, 6 }, { 2, 7, 7 } };

		System.out.println(
				solution.equalPairs(grid1));
		System.out.println(
				solution_A.equalPairs(grid1));

		System.out.println(
				"**************************************");

		int[][] grid2 = { { 3, 1, 2, 2 },
				{ 1, 4, 4, 5 }, { 2, 4, 2, 2 },
				{ 2, 4, 2, 2 } };

		System.out.println(
				solution.equalPairs(grid2));
		System.out.println(
				solution_A.equalPairs(grid2));
		System.out.println(
				"**************************************");

	}

}

class SolutionLC2352 {

	public int equalPairs(int[][] grid) {

		Map<List<Integer>, Integer> rowMap = new HashMap<List<Integer>, Integer>();

		for (int i = 0; i < grid.length; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < grid.length; j++) {
				row.add(grid[i][j]);
			}
			rowMap.put(row,
					rowMap.getOrDefault(row, 0)
							+ 1);
		}

		int count = 0;

		// Build columns one-by-one and check against row Map
		for (int j = 0; j < grid.length; j++) {
			List<Integer> column = new ArrayList<>();
			for (int i = 0; i < grid.length; i++) {
				column.add(grid[i][j]);
			}
			// Add the frequency from the map (if it exists)
			count = count + rowMap
					.getOrDefault(column, 0);
		}

		return count;

	}

}

/*
 * The "Gold Standard" approach is often referred to as Sparse Hashing
 * or Custom Polynomial Rolling Hash.
 * 
 * Instead of creating N separate List<Integer> objects (which creates
 * a lot of memory pressure for the Garbage Collector), we convert
 * each row and column into a single long number. This allows us to
 * use a HashMap<Long, Integer>, which is significantly faster and
 * uses less memory.
 */

class SolutionLC2352_A {
	public int equalPairs(int[][] grid) {
		int n = grid.length;

		// Map stores: Key = Hash of the row, Value = Count of
		// occurrences
		Map<Long, Integer> rowHashes = new HashMap<>();

		// Calculate Hash for each Row
		for (int i = 0; i < n; i++) {
			long hash = 0;
			for (int j = 0; j < n; j++) {
				// Using a prime number (31) to create a unique
				// fingerprint
				hash = 31 * hash + grid[i][j];
			}
			rowHashes.put(hash, rowHashes
					.getOrDefault(hash, 0) + 1);
		}

		int count = 0;
		// Calculate Hash for each Column and check against
		// rowHashes
		for (int j = 0; j < n; j++) {
			long colHash = 0;
			for (int i = 0; i < n; i++) {
				colHash = 31 * colHash
						+ grid[i][j];
			}
			// If the column hash matches a row hash, we found pairs!
			count += rowHashes
					.getOrDefault(colHash, 0);
		}

		return count;
	}
}
