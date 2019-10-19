package Linked_Lists;

import utility.Display;
import utility.LinkedList;
import utility.Node;

public class Palindrome {

	public static void main(String[] args) {

		// Input Linked List
		LinkedList linkedList1 = new LinkedList();
		linkedList1 = LinkedList.insert(linkedList1, 0);
		linkedList1 = LinkedList.insert(linkedList1, 1);
		linkedList1 = LinkedList.insert(linkedList1, 2);
		linkedList1 = LinkedList.insert(linkedList1, 1);
		linkedList1 = LinkedList.insert(linkedList1, 0);

		// Display Linked List
		Display.LinkedListdisplay(linkedList1);

		// Reverse LinkedList and Check Palindrome

		System.out.println("Palindrome : "+palindromeByReverse(linkedList1));

	}

	private static boolean palindromeByReverse(LinkedList linkedList1) {
		LinkedList listToBeReverse = linkedList1;

		LinkedList reversedLinkedList = reverse(listToBeReverse);

		Display.LinkedListdisplay(reversedLinkedList);

		Node strt1 = linkedList1.head;
		Node strt2 = reversedLinkedList.head;

		boolean isPalindrome = true;

		while (strt1 != null) {
			if (strt1.data != strt2.data) {
				isPalindrome = false;
				break;
			}
			strt1 = strt1.next;
			strt2 = strt2.next;
		}
     return isPalindrome;
	}

	private static LinkedList reverse(LinkedList linkedList1) {

		/* 1->2->3->4->null to 4->3->2->1->null */

		LinkedList reversed = new LinkedList();
		Node curr = linkedList1.head;
		Node prev = null;
		Node nextNode = null;

		while (curr != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;

		}

		reversed.head = prev;
		return reversed;
	}

}
