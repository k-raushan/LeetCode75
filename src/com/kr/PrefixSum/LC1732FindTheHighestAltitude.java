/**
 * Day 18: LC 1732 - Find the Highest Altitude
 * Time Complexity: O(n) - Calculating prefix sums on the fly to find the max.
 * Space Complexity: O(1) - Only tracking current altitude and max altitude.
 */
package com.kr.PrefixSum;

public class LC1732FindTheHighestAltitude {

	public static void main(String[] args) {
		SolutionLC1732 solution = new SolutionLC1732();

		int[] gain1 = { -5, 1, 5, 0, -7 };
		System.out.println(
				solution.largestAltitude(gain1));

		System.out.println(
				"**************************************");

		int[] gain2 = { -4, -3, -2, -1, 4, 3, 2 };
		System.out.println(
				solution.largestAltitude(gain2));

	}

}

class SolutionLC1732 {
	public int largestAltitude(int[] gain) {

		int currentAltitude = 0;
		int maxAltitude = 0;

		for (int i = 0; i < gain.length; i++) {

			currentAltitude = currentAltitude
					+ gain[i];

			maxAltitude = Math.max(maxAltitude,
					currentAltitude);

			System.out.println("At point i : " + i
					+ " The altitude gain is : "
					+ gain[i]
					+ " currentAltitude : "
					+ currentAltitude
					+ " maxAltitude : "
					+ maxAltitude);

		}
		return maxAltitude;

	}
}
