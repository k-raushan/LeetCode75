/**
 * Day 25: LC 735 - Asteroid Collision
 * 
 * Time Complexity: O(n) - Each asteroid is pushed and popped at most
 * once. Even with a nested while loop, every element enters and
 * leaves the stack only once.
 * 
 * Space Complexity: O(n) - In the worst case (no collisions), we
 * store all asteroids in the stack.
 */
package com.kr.stack;

import java.util.Stack;

public class LC735AsteroidCollision {

	public static void main(String[] args) {
		SolutionLC735 solution = new SolutionLC735();

		int[] asteroids1 = { 5, 10, -5 };
		System.out.println(solution.asteroidCollision(asteroids1));

		int[] asteroids2 = { 8, -8 };
		System.out.println(solution.asteroidCollision(asteroids2));

		int[] asteroids3 = { 3, 5, -6, 2, -1, 4 };
		System.out.println(solution.asteroidCollision(asteroids3));

	}

}

class SolutionLC735 {
	public int[] asteroidCollision(int[] asteroids) {

		Stack<Integer> stack = new Stack<Integer>();

		for (int ast : asteroids) {
			boolean destroyed = false;

			// Only collide if current is moving Left (<0) and top is
			// moving Right (>0)
			while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
				if (Math.abs(ast) > stack.peek()) {
					// Stack asteroid explodes, keep checking next
					stack.pop();
					continue;
				} else if (Math.abs(ast) == stack.peek()) {
					stack.pop(); // Both explode
					destroyed = true;
				} else {
					// Current asteroid explodes
					destroyed = true;
				}
				break;
			}

			if (!destroyed) {
				stack.push(ast);
			}
		}

		// Convert stack to array
		int[] result = new int[stack.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		return result;

	}
}
