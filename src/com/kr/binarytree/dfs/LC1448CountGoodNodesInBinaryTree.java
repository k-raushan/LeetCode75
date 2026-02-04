/**
 * Day 35: LC 1448 - Count Good Nodes in Binary Tree
 * 
 * Algorithm: Depth-First Search (DFS) with Path Tracking
 * 1. Traverse the tree while passing the maximum value encountered
 * along the path.
 * 2. A node is 'good' if its value is greater than or equal to the
 * path's maximum.
 * 3. Update the path's maximum at each node before recursing to
 * children.
 * 
 * Time Complexity: O(n) - Every node is visited once.
 * Space Complexity: O(h) - Recursive stack depth based on tree
 * height.
 */
package com.kr.binarytree.dfs;

public class LC1448CountGoodNodesInBinaryTree {

	public static void main(String[] args) {
		SolutionLC1448 solution = new SolutionLC1448();

		// Create the root
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node1A = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);

		root.left = node1;
		root.right = node4;

		node1.left = node3;
		node1.right = null;

		node4.left = node1A;
		node4.right = node5;

		node1A.left = null;
		node1A.right = null;

		node5.left = null;
		node5.right = null;

		int i = solution.goodNodes(root);
		System.out.println("Good Nodes : " + i);

	}

}

class SolutionLC1448 {

	public int goodNodes(TreeNode root) {

		return dfs(root, root.val);
	}

	private int dfs(TreeNode node, int maxSoFar) {
		if (node == null)
			return 0;

		int count = 0;

		if (node.val >= maxSoFar) {
			count++;
			System.out.println("Current node is : " + node.val
					+ " Max So Far is/was : " + maxSoFar
					+ " and count is : " + count);
		}

		maxSoFar = Math.max(node.val, maxSoFar);

		int goodInLeft = dfs(node.left, maxSoFar);
		System.out.println("Current node is : " + node.val
				+ " goodInLeft : " + goodInLeft);

		int goodInRight = dfs(node.right, maxSoFar);
		System.out.println("Current node is : " + node.val
				+ " goodInRight : " + goodInRight);

		return count + goodInLeft + goodInRight;

	}
}