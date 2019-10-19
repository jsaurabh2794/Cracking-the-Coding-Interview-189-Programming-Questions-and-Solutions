package Linked_Lists;

import utility.LinkedList;
import utility.Node;

public class Return_Kth_to_Last {

	static int nodeNoFromLast = 0;

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

		// print the Linked-list
		display(linkedlist);

		// kth node from last
		int k = 5;

		// return the kth element from last
		recursiveWay(linkedlist.head, k);
		
		// return the kth element from last
	   System.out.printf("\nNode No %d is: %d\n", k,nonRecursiveWay(linkedlist.head, k));

	}

	private static int recursiveWay(Node linkedlistNode, int k) {
		Node node = linkedlistNode;
		if (node != null) {
			nodeNoFromLast = 1 + recursiveWay(node.next, k);
			if (nodeNoFromLast == k) {
				System.out.printf("Node No %d is: %d", k, node.data);
			}
		}

		return nodeNoFromLast;

	}

	private static int nonRecursiveWay(Node linkedlistNode, int k) {
		// Maintain two pointer whoose difference will be k
		Node node1 = linkedlistNode;
		Node node2;
		for (int i = 0; i < k; i++) {

			if (linkedlistNode.next != null) {
				linkedlistNode = linkedlistNode.next;
			}
		}
       node2 = linkedlistNode; //points to k node ahead;
       while(node2!=null)
       {
    	   node1 = node1.next;
    	   node2 = node2.next;
       }
		return node1.data;

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
