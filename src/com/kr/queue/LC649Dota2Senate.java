/**
 * Day 28: LC 649 - Dota2 Senate
 * 
 * Time Complexity: O(n) - Each senator votes or gets banned exactly
 * once. Even with multiple rounds, the total number of "poll"
 * operations is linear.
 * 
 * Space Complexity: O(n) - We store all initial indices across two
 * queues.
 */
package com.kr.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC649Dota2Senate {

	public static void main(String[] args) {
		SolutionLC649 solutionLC649 = new SolutionLC649();

		System.out.println(solutionLC649.predictPartyVictory("RD"));
		System.out
				.println("*****************************************");
		System.out.println(solutionLC649.predictPartyVictory("RDD"));
		System.out
				.println("*****************************************");

	}

}

class SolutionLC649 {
	public String predictPartyVictory(String senate) {

		Queue<Integer> radiantQueue = new LinkedList<>();
		Queue<Integer> direQueue = new LinkedList<>();

		int n = senate.length();

		// Separate indices into two teams
		for (int i = 0; i < n; i++) {
			if (senate.charAt(i) == 'R') {
				radiantQueue.add(i);
			} else {
				direQueue.add(i);
			}

		}

		// Battle until one team is gone
		while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
			int rIndex = radiantQueue.poll();
			int dIndex = direQueue.poll();

			// The one with the lower index bans the other
			// and joins the next round (current index + n)
			if (rIndex < dIndex) {
				radiantQueue.add(rIndex + n);
			} else {
				direQueue.add(dIndex + n);
			}
		}

		return radiantQueue.isEmpty() ? "Dire" : "Radiant";
	}
}