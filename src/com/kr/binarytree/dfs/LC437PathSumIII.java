/**
 * Day 36: LC 437 - Path Sum III
 * 
 * 
 * Algorithm: Double DFS (Brute Force Approach)
 * 1. Primary DFS (pathSum) visits every node in the tree.
 * 2. Secondary DFS (countPaths) starts at each node to find all
 * downward paths equal to targetSum.
 * 3. Use 'long' for the sum calculation to prevent integer overflow
 * in large trees.
 * 
 * 
 * Time Complexity: O(n^2) in worst case (skewed tree), O(n log n)
 * for balanced.
 * Space Complexity: O(h) - Recursive stack depth.
 */
package com.kr.binarytree.dfs;

public class LC437PathSumIII {

	public static void main(String[] args) {
		SolutionLC437 solution = new SolutionLC437();

		// [10,5,-3,3,2,null,11,3,-2,null,1]
		// Create the root
		TreeNode root = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node3N = new TreeNode(-3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node11 = new TreeNode(11);
		TreeNode node3A = new TreeNode(3);
		TreeNode node2N = new TreeNode(-2);
		TreeNode node1 = new TreeNode(1);

		root.left = node5;
		root.right = node3N;

		node5.left = node3;
		node5.right = node2;

		node3N.left = null;
		node3N.right = node11;

		node3.left = node3A;
		node3.right = node2N;

		node2.left = null;
		node2.right = node1;

		node11.left = null;
		node11.right = null;

		node3A.left = null;
		node3A.right = null;

		node2N.left = null;
		node2N.right = null;

		node1.left = null;
		node1.right = null;

		int target = 8;

		int i = solution.pathSum(root, target);
		System.out.println("Good Nodes : " + i);

	}

}

class SolutionLC437 {

	public int pathSum(TreeNode root, int targetSum) {

		if (root == null)
			return 0;

		// 1. Count paths starting at THIS node
		long countFromRoot = countPaths(root, targetSum);

		// 2. the left and right children should do the same
		int countFromLeft = pathSum(root.left, targetSum);
		int countFromRight = pathSum(root.right, targetSum);

		return (int) countFromRoot + countFromLeft + countFromRight;
	}

	private long countPaths(TreeNode node, long remainingSum) {
		if (node == null)
			return 0;

		long count = 0;
		// If the current node itself completes the sum
		if (node.val == remainingSum) {
			count = 1;
		}

		// Continue looking down to see if further nodes (even if they
		// sum to 0) create more paths
		return count + countPaths(node.left, remainingSum - node.val)
				+ countPaths(node.right, remainingSum - node.val);
	}
}