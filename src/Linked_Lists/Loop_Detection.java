package Linked_Lists;

import java.util.Hashtable;

import utility.Display;
import utility.LinkedList;
import utility.Node;

public class Loop_Detection {

	public static void main(String[] args) {

		// Create a Loop Containing LinkedList
		LinkedList linkedList = new LinkedList();
		linkedList = LinkedList.insert(linkedList, 7);
		linkedList = LinkedList.insert(linkedList, 1);
		linkedList = LinkedList.insert(linkedList, 6);
		linkedList = LinkedList.insert(linkedList, 3);
		linkedList = LinkedList.insert(linkedList, 4);
		linkedList = LinkedList.insert(linkedList, 8);
		linkedList = LinkedList.insert(linkedList, 8);
		linkedList = LinkedList.insert(linkedList, 9);
		
		Node head = linkedList.head;
		while(head.next != null)
		{
			head = head.next;
		}
		head.next = linkedList.head.next.next; //pointing to 4th node
		
		loopDetection(linkedList);
	}

	private static void loopDetection(LinkedList linkedList) {

		Hashtable<Integer,Node> nodes = new Hashtable<Integer,Node>();
		Node strt = linkedList.head;
		while(strt.next != null) {
			if(nodes.contains(strt))
			{
				System.out.println("Loop starts from here: "+strt.data);
				break;
				
			}else
			{
				nodes.put(strt.data,strt);
			}
			strt = strt.next;
		}
	}

}
