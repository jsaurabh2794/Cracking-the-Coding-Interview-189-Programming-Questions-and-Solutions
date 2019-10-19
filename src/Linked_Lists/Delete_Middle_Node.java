package Linked_Lists;

import utility.LinkedList;
import utility.Node;

public class Delete_Middle_Node {

	public static void main(String[] args) {
		// LinkedList Creation and initialization
		LinkedList linkedlist = new LinkedList();
		linkedlist = LinkedList.insert(linkedlist, 1);
		linkedlist = LinkedList.insert(linkedlist, 3);
		linkedlist = LinkedList.insert(linkedlist, 4);
		linkedlist = LinkedList.insert(linkedlist, 1);
		linkedlist = LinkedList.insert(linkedlist, 3);
		linkedlist = LinkedList.insert(linkedlist, 4);
		linkedlist = LinkedList.insert(linkedlist, 7);
		linkedlist = LinkedList.insert(linkedlist, 6);

		// Before
		display(linkedlist);
		// Delete any node except first and last if you have given access to node which
		// needs to be deleted

		Node nodeToBeDeleted = linkedlist.head.next.next; // 4 to be deleted
		deleteNode(nodeToBeDeleted);

		// After
		display(linkedlist);

	}

	private static void deleteNode(Node nodeToBeDeleted) {
		if(nodeToBeDeleted == null || nodeToBeDeleted.next == null)
		{
			return;
		}
        Node nextNode = nodeToBeDeleted.next;
        nodeToBeDeleted.data=nextNode.data;
        nodeToBeDeleted.next = nextNode.next;
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
