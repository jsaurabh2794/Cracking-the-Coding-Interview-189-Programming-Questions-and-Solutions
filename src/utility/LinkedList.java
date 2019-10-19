package utility;

public class LinkedList {

	public Node head;

	public static LinkedList insert(LinkedList list, int data) {

		Node node = new Node(data);
		node.next = null;

		if (list.head == null) {
			list.head = node;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
		}

		return list;

	}
	
	public static LinkedList Merge(LinkedList list1, LinkedList list2) {
 
		LinkedList newList = null;
		Node strtOfList1 = list1.head;
		while(strtOfList1.next != null)
		{
			strtOfList1 = strtOfList1.next;
		}
		strtOfList1.next = list2.head;
		return list1;

	}
}


