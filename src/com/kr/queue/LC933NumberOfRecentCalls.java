/**
 * Day 27: LC 933 - Number of Recent Calls
 * 
 * Time Complexity: O(1) amortized - While a single ping might remove
 * multiple old elements, each element is added and removed exactly
 * once.
 * 
 * Space Complexity: O(W) - Where W is the window size (3000ms).
 * In the worst case, we store all pings that fall within that time
 * frame.
 */
package com.kr.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC933NumberOfRecentCalls {

	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();

		System.out.println(recentCounter.ping(1));
		System.out
				.println("*****************************************");
		System.out.println(recentCounter.ping(100));
		System.out
				.println("*****************************************");
		System.out.println(recentCounter.ping(3001));
		System.out
				.println("*****************************************");
		System.out.println(recentCounter.ping(3002));

	}

}

class RecentCounter {

	Queue<Integer> queue = new LinkedList<>();

	public RecentCounter() {

	}

	public int ping(int t) {

		queue.add(t);
		int range[] = { t - 3000, t };

		System.out.println("Queue contains : " + queue.toString());

		System.out.println(
				"Current Window is : " + range[0] + ":" + range[1]);

		while (!queue.isEmpty() && queue.peek() < range[0]) {
			System.out.println("Queue peek " + queue.poll()
					+ "is follow behind the lowest range, throwing it away.");
			// queue.poll();
		}

		return queue.size();

	}
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */