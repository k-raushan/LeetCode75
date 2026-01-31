/**
 * Day 33: LC 2130 - Maximum Twin Sum of a Linked List
 * 
 * * Algorithm Comparison:
 * - SolutionLC2130 (Length-based): Uses a counter to find the split
 * point. (~1.5n passes)
 * - SolutionLC2130A (Fast/Slow): Optimized one-pass middle detection.
 * (~0.5n passes)
 * 
 * * Both approaches achieve the same complexity goals:
 * Time Complexity: O(n) - Linear traversal.
 * Space Complexity: O(1) - Constant space, in-place pointer reversal.
 */

package com.kr.linkedlist;

public class LC2130MaximumTwinSumOfALinkedList {

	public static void main(String[] args) {
		SolutionLC2130 solution = new SolutionLC2130();

		// Lets manually create the chain
		ListNode head1 = new ListNode(5);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(2);
		head1.next.next.next = new ListNode(1);

		int result1 = solution.pairSum(head1);
		System.out.println(result1);

		// Lets manually create the chain
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(2);
		head2.next.next.next = new ListNode(1);

		SolutionLC2130A solutionLC2130A = new SolutionLC2130A();
		int result2 = solutionLC2130A.pairSum(head2);
		System.out.println(result2);
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

/*
 * Algorithm: Length Counting + Midpoint Split + Reversal
 * 1. Count total nodes to find the midpoint index.
 * 2. Split the list into two halves based on the count.
 * 3. Reverse the second half to align 'twins' (first with last).
 * 4. Iterate through both halves simultaneously to find the maximum
 * sum.
 * 
 * O(n) to count + O(n/2) to reach middle = 1.5n passes.
 */

class SolutionLC2130 {
	public int pairSum(ListNode head) {

		ListNode currenNode = head;
		int count = 0;
		while (currenNode != null) {
			count++;
			currenNode = currenNode.next;
		}

		ListNode firstHalf = head;
		ListNode secondHalf = null;
		currenNode = head;
		int index = 0;
		while (currenNode != null) {
			index++;
			currenNode = currenNode.next;
			if (index == count / 2) {
				secondHalf = currenNode;
				break;
			}
		}

		printNode(firstHalf);
		printNode(secondHalf);

		// Reverse the second Half
		ListNode reversed = null;
		while (secondHalf != null) {
			ListNode nextTemp = secondHalf.next;
			secondHalf.next = reversed;
			reversed = secondHalf;
			secondHalf = nextTemp;
		}

		printNode(reversed);

		int max = 0;
		while (reversed != null) {
			max = Math.max(max, reversed.val + firstHalf.val);
			reversed = reversed.next;
			firstHalf = firstHalf.next;
		}

		return max;

	}

	public void printNode(ListNode result) {
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println("null");
		System.out.println("*************************");
	}
}

/*
 * Algorithm: Midpoint + Reverse Second Half + Twin Comparison
 * 1. Find middle node using Fast/Slow pointers (O(n)).
 * 2. Reverse the second half of the list to make 'twins' accessible
 * (O(n)).
 * 3. Traverse both halves simultaneously, calculating sums and
 * tracking the max (O(n)).
 * 
 * O(n/2) passes with two pointers = 0.5n passes.
 */
class SolutionLC2130A {
	public int pairSum(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Reverse the second Half
		ListNode reversed = null;
		while (slow != null) {
			ListNode nextTemp = slow.next;
			slow.next = reversed;
			reversed = slow;
			slow = nextTemp;
		}

		ListNode first = head;
		ListNode second = reversed;

		int max = 0;
		while (second != null) {
			max = Math.max(max, first.val + second.val);
			first = first.next;
			second = second.next;
		}

		return max;

	}

}