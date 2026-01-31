/**
 * Day 33: LC 104 - Maximum Depth of Binary Tree
 * 
 * 
 * * Knowledge Point: Level-Order Array Representation
 * - Array: [3, 9, 20, null, null, 15, 7]
 * - Mapping: Root(3) -> L:9, R:20. 9 -> L:null, R:null. 20 -> L:15,
 * R:7.
 * 
 * * Time Complexity: O(n)
 * * Space Complexity: O(h)
 */
package com.kr.binarytree.dfs;

public class LC104MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		SolutionLC104 solution = new SolutionLC104();

		// 1. Create the nodes
		TreeNode root = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);

		// 2. Connect them based on the example
		root.left = node9;
		root.right = node20;

		// 9 has null children, so we leave them

		node20.left = node15;
		node20.right = node7;

		// 3. Pass to your method
		int depth = solution.maxDepth(root);
		System.out.println("Maximum Depth: " + depth);

		System.out.println("**************************************");

	}

}

// Definition for a binary tree node.
class SolutionLC104 {
	public int maxDepth(TreeNode root) {

		System.out.println("Current Node is : "
				+ (root != null ? root.val : "null"));

		if (root == null) {
			return 0;
		}

		int leftDepth = maxDepth(root.left);
		System.out.println("For node : " + root.val
				+ " left depth is : " + leftDepth);
		int rightDepth = maxDepth(root.right);
		System.out.println("For node : " + root.val
				+ " right depth is : " + rightDepth);
		System.out.println("Max depth at this stage is : "
				+ (Math.max(leftDepth, rightDepth) + 1));
		System.out.println("**********************************");

		return Math.max(leftDepth, rightDepth) + 1;
	}
}