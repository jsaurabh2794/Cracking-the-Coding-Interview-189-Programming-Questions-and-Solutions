package Linked_Lists;

import java.util.HashSet;

import utility.LinkedList; // Own Implementation
import utility.Node;;

public class Remove_Dups {

	public static void main(String[] args) {

		// Take input as Unsorted linkedList
		LinkedList linkedlist = new LinkedList();
		linkedlist = LinkedList.insert(linkedlist, 1);
		linkedlist = LinkedList.insert(linkedlist, 3);
		linkedlist = LinkedList.insert(linkedlist, 4);
		linkedlist = LinkedList.insert(linkedlist, 1);
		linkedlist = LinkedList.insert(linkedlist, 3);
		linkedlist = LinkedList.insert(linkedlist, 4);
		linkedlist = LinkedList.insert(linkedlist, 7);
		linkedlist = LinkedList.insert(linkedlist, 6);

		// print the Linked-list before removing the duplicates
		display(linkedlist);

		removeTheDuplicatesWithoutUsingExtraSpace(linkedlist);

		// print the Linked-list after removing the duplicates
		display(linkedlist);
	}

	private static void removeTheDuplicatesUsingExtraSpace(LinkedList linkedlist) {
		// done using extra buffer
		if (linkedlist == null) {
			return;
		}
		Node head = linkedlist.head;
		HashSet<Integer> duplicateCount = new HashSet<Integer>();
		duplicateCount.add(head.data);

		while (head.next != null) {
			if (duplicateCount.contains(head.next.data)) {
				head.next = head.next.next;
			} else {
				duplicateCount.add(head.next.data);
				head = head.next;
			}
		}
	}
	private static void removeTheDuplicatesWithoutUsingExtraSpace(LinkedList linkedlist) {
		// done without using extra buffer
		if (linkedlist == null) {
			return;
		}
		Node head = linkedlist.head;

		while (head.next != null) {
			int data = head.data;
			Node runner = head;
			while(runner.next!=null)
			{
				if(data == runner.next.data)
				{
					runner.next = runner.next.next;
				}else
				{
					runner = runner.next;
				}
			}
			head = head.next;
		}
	}

	private static void display(LinkedList linkedlist) {

		if (linkedlist == null) {
			return;
		}
		Node head = linkedlist.head;
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("null");
	}

}
