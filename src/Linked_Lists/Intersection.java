package Linked_Lists;

import utility.Display;
import utility.LinkedList;
import utility.Node;

public class Intersection {

	public static void main(String[] args) {

		// Creating linked list which are intersecting -- Starts
		LinkedList linkedList1 = new LinkedList();
		linkedList1 = LinkedList.insert(linkedList1, 7);
		linkedList1 = LinkedList.insert(linkedList1, 1);
		linkedList1 = LinkedList.insert(linkedList1, 6);
		linkedList1 = LinkedList.insert(linkedList1, 3);
		linkedList1 = LinkedList.insert(linkedList1, 4);

		LinkedList linkedList2 = new LinkedList();
		linkedList2 = LinkedList.insert(linkedList2, 8);
		linkedList2 = LinkedList.insert(linkedList2, 7);
		linkedList2 = LinkedList.insert(linkedList2, 10);
		linkedList2 = LinkedList.insert(linkedList2, 12);
		linkedList2 = LinkedList.insert(linkedList2, 75);

		// intersecting
		Node head = linkedList2.head;
		while (head.next != null) {
			// will traverse till end then merge
			head = head.next;
		}
		head.next = linkedList1.head.next.next; // I connected at 3rd node
		// Creating linked list which are intersecting -- ends

		/* Display Linked list */
		Display.LinkedListdisplay(linkedList1);
		Display.LinkedListdisplay(linkedList2);
		/* Display Linked list */

		TailandSize list1 = TailandSize.checkTailandSize(linkedList1);
		TailandSize list2 = TailandSize.checkTailandSize(linkedList2);

		if (list1.tail != list2.tail) {
			System.out.println("Not intersecting anywhere");
			return;
		}

		Node node = findIntersection(linkedList1, list1, linkedList2, list2);
		System.out.println("Node:"+ node.data);
	}

	private static Node findIntersection(LinkedList linkedList1, TailandSize list1, LinkedList linkedList2,
			TailandSize list2) {

		// Skip off the nodes which is bigger
		int diff = Math.abs(list1.size - list2.size);
		
		//Below case is when first list is equal or greater than second list
		Node strt1 = linkedList1.head;
		Node strt2 = linkedList2.head;
		
		//Below case is when second list is  greater than first list
		if (list1.size < list2.size) {
			strt1 = linkedList2.head;

			strt2 = linkedList1.head;
		}
		
		//Skip the node which is bigger
		while (diff > 0 && strt1.next != null) {
			strt1 = strt1.next;
			diff--;
		}

		while (strt1.next != strt2.next) {
			strt1 = strt1.next;
			strt2 = strt2.next;
		}
		
		// Return any one of two node when node becomes equal
		return strt1.next;

	}

}

class TailandSize {
	Node tail;
	int size;

	public TailandSize(Node tail, int size) {
		this.tail = tail;
		this.size = size;
	}

	public static TailandSize checkTailandSize(LinkedList list) {
		int size = 0;
		Node node = list.head;
		while (node.next != null) {
			node = node.next;
			size++;
		}
		return new TailandSize(node, size);
	}
}
