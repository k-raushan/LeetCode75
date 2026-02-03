/**
 * Day 34: LC 872 - Leaf-Similar Trees
 * 
 * Algorithm: Depth-First Search (DFS) Leaf Extraction
 * 1. Use a helper function to perform DFS on each tree.
 * 2. If a node is a "leaf" (left == null && right == null), add its
 * value to a list.
 * 3. Compare the resulting leaf sequences from both trees for
 * equality.
 * 
 * Time Complexity: O(T1 + T2) - Visiting every node in both trees.
 * Space Complexity: O(L1 + L2) - Storing the leaf values in lists.
 */
package com.kr.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC872LeafSimilarTrees {

	public static void main(String[] args) {
		SolutionLC872 solution = new SolutionLC872();

		// Create the root1
		TreeNode root1 = new TreeNode(3);
		TreeNode r1Node5 = new TreeNode(5);
		TreeNode r1Node1 = new TreeNode(1);
		TreeNode r1Node6 = new TreeNode(6);
		TreeNode r1Node2 = new TreeNode(2);
		TreeNode r1Node9 = new TreeNode(9);
		TreeNode r1Node8 = new TreeNode(8);
		TreeNode r1Node7 = new TreeNode(7);
		TreeNode r1Node4 = new TreeNode(4);

		root1.left = r1Node5;
		root1.right = r1Node1;
		r1Node5.left = r1Node6;
		r1Node5.right = r1Node2;
		r1Node1.left = r1Node9;
		r1Node1.right = r1Node8;
		r1Node6.left = null;
		r1Node6.right = null;
		r1Node2.left = r1Node7;
		r1Node2.right = r1Node4;

		// Create the root2
		TreeNode root2 = new TreeNode(3);
		TreeNode r2Node5 = new TreeNode(5);
		TreeNode r2Node1 = new TreeNode(1);
		TreeNode r2Node6 = new TreeNode(6);
		TreeNode r2Node7 = new TreeNode(7);
		TreeNode r2Nood4 = new TreeNode(4);
		TreeNode r2Node2 = new TreeNode(2);
		TreeNode r2Node9 = new TreeNode(9);
		TreeNode r2Node8 = new TreeNode(8);

		root2.left = r2Node5;
		root2.right = r2Node1;
		r2Node5.left = r2Node6;
		r2Node5.right = r2Node7;
		r2Node1.left = r2Nood4;
		r2Node1.right = r2Node2;
		r2Node6.left = null;
		r2Node6.right = null;
		r2Node7.left = null;
		r2Node7.right = null;
		r2Nood4.left = null;
		r2Nood4.right = null;
		r2Node2.left = r2Node9;
		r2Node2.right = r2Node8;
		r2Node9.left = null;
		r2Node9.right = null;
		r2Node8.left = null;
		r2Node8.right = null;

		boolean flag = solution.leafSimilar(root1, root2);
		System.out.println("Similar Leaf : " + flag);

	}

}

class SolutionLC872 {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = new ArrayList<>();
		List<Integer> leaves2 = new ArrayList<>();

		getLeaves(root1, leaves1);
		getLeaves(root2, leaves2);

		System.out.println(leaves1);
		System.out.println(leaves2);

		return leaves1.equals(leaves2);
	}

	private void getLeaves(TreeNode node, List<Integer> leaves) {
		if (node == null)
			return;

		if (node.left == null && node.right == null) {
			leaves.add(node.val);
		}

		getLeaves(node.left, leaves);
		getLeaves(node.right, leaves);
	}
}