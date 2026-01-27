/**
 * Day 29: LC 2095 - Delete the Middle Node of a Linked List
 * 
 * Algorithm: Tortoise and Hare (Fast & Slow Pointers)
 * 1. Use two pointers: 'slow' moves 1 step, 'fast' moves 2 steps.
 * 2. Maintain a 'prev' pointer to track the node before 'slow'.
 * 3. When 'fast' reaches the end, 'slow' is at the middle.
 * 4. Update 'prev.next' to 'slow.next' to skip/delete the middle
 * node.
 * 
 * Time Complexity: O(n) - Single pass through the list.
 * Space Complexity: O(1) - Modified the list in-place without extra
 * storage.
 */

package com.kr.linkedlist;

public class LC2095DeleteTheMiddleNodeOfALinkedList {

	public static void main(String[] args) {
		SolutionLC2095 solution = new SolutionLC2095();

		// Lets manually create the chain
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(6);

		// Pass only the HEAD to the solution
		ListNode result = solution.deleteMiddle(head);

		// Print the result by walking the chain
		ListNode current = result;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");

	}

}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class SolutionLC2095 {
	public ListNode deleteMiddle(ListNode head) {

		// Edge case: if there's only one node, deleting the middle
		// leaves it empty
		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;       // Keep track of the node before 'slow'
			slow = slow.next;  // Moves 1 step
			fast = fast.next.next; // Moves 2 steps
		}

		// 'slow' is now at the middle. 'prev' is right before it.
		// We delete 'slow' by connecting 'prev' to the node AFTER
		// 'slow'.
		prev.next = slow.next;

		return head;

	}
}