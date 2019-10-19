package utility;

public class Display {

	 public static void LinkedListdisplay(LinkedList linkedlist) {

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
