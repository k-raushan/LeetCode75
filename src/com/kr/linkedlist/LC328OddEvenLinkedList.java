/**
 * Day 30: LC 328 - Odd Even Linked List
 * 
 * Algorithm: Two-Pointer Chain Stitching
 * 1. Maintain two pointers (odd and even) to build two separate
 * lists.
 * 2. Save the head of the even list ('evenHead') to reconnect later.
 * 3. Iterate once: odd.next takes even.next, then even.next takes
 * odd.next.
 * 4. Finally, attach the even list to the tail of the odd list.
 * 
 * * Time Complexity: O(n) - Linear scan of the list.
 * * Space Complexity: O(1) - Rearranged pointers in-place.
 */

package com.kr.linkedlist;

public class LC328OddEvenLinkedList {

	public static void main(String[] args) {
		SolutionLC328 solution = new SolutionLC328();

		// Lets manually create the chain
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		// Pass only the HEAD to the solution
		ListNode result = solution.oddEvenList(head);

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

class SolutionLC328 {
	public ListNode oddEvenList(ListNode head) {

		if (head == null)
			return null;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = even.next;

			even.next = odd.next;
			even = odd.next;

			// Code below in while loop is two just for visualisation
			// how the odd and even is moving on the fly
			System.out.print("Odd : ");
			ListNode current = odd;
			while (current != null) {
				System.out.print(current.val + " -> ");
				current = current.next;
			}
			System.out.println("null");

			System.out.print("Even : ");
			current = even;
			while (current != null) {
				System.out.print(current.val + " -> ");
				current = current.next;
			}
			System.out.println("null");

			System.out.print("EvenHead : ");
			current = evenHead;
			while (current != null) {
				System.out.print(current.val + " -> ");
				current = current.next;
			}
			System.out.println("null");

			System.out.print("head : ");
			current = head;
			while (current != null) {
				System.out.print(current.val + " -> ");
				current = current.next;
			}
			System.out.println("null");
			System.out.println();

			System.out.println("*********************************");

		}

		System.out.println("Stitch the odd and even together");
		odd.next = evenHead;

		return head;

	}
}