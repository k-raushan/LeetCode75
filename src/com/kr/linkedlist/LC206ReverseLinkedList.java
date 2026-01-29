/**
 * Day 31: LC 206 - Reverse Linked List
 * 
 * 
 * Algorithm: Iterative Pointer Reversal
 * 1. Use 'revised' (prev) to track the head of the new reversed list.
 * 2. In each step, save current.next so we don't lose the chain.
 * 3. Point current.next back to 'revised'.
 * 4. Move 'revised' and 'current' forward.
 * 
 * 
 * Time Complexity: O(n) - Single pass through the list.
 * Space Complexity: O(1) - Reversal done in-place.
 */

package com.kr.linkedlist;

public class LC206ReverseLinkedList {

	public static void main(String[] args) {
		SolutionLC206 solution = new SolutionLC206();

		// Lets manually create the chain
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		// Pass only the HEAD to the solution
		ListNode result = solution.reverseList(head);

		// Print the result by walking the chain
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println("null");

	}

}

// Definition for singly-linked list.
/*
 * class ListNode {
 * int val;
 * ListNode next;
 * 
 * ListNode() {
 * }
 * 
 * ListNode(int val) {
 * this.val = val;
 * }
 * 
 * ListNode(int val, ListNode next) {
 * this.val = val;
 * this.next = next;
 * }
 * }
 */

class SolutionLC206 {
	public ListNode reverseList(ListNode head) {
		// 1,2,3,4,5
		ListNode revised = null;
		ListNode current = head;
		while (current != null) {
			ListNode temp = current.next;
			current.next = revised;
			revised = current;
			current = temp;

			// Below code is just for understanding.
			// Print the result by walking the revised chain
			ListNode result = revised;
			while (result != null) {
				System.out.print(result.val + " -> ");
				result = result.next;
			}
			System.out.println("null");

			// Print the result by walking the current chain
			result = current;
			while (result != null) {
				System.out.print(result.val + " -> ");
				result = result.next;
			}
			System.out.println("null");
			System.out.println("******************");

		}
		return revised;

	}
}