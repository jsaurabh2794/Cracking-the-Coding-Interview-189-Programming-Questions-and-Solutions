package Linked_Lists;

import utility.Display;
import utility.LinkedList;
import utility.Node;

public class Sum_Lists {

	public static void main(String[] args) {
		/*
		 * You have two numbers represented by a linked list, where each node contains a
		 * single digit.The digits are stored in reverse order, such that the 1 's digit
		 * is at the head of the list. Write a function that adds the two numbers and
		 * returns the sum as a linked list. Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That
		 * is,617 + 295. Output: 2 -> 1 -> 9. That is, 912. FOLLOW UP Suppose the digits
		 * are stored in forward order. Repeat the above problem. EXAMPLE lnput:(6 ->
		 * 1-> 7) + (2 -> 9 -> 5). That is,617 + 295. Output: 9 -> 1 -> 2. That is, 912.
		 */

		// Input of linkedList---
		LinkedList linkedList1 = new LinkedList();
		linkedList1 = LinkedList.insert(linkedList1, 7);
		linkedList1 = LinkedList.insert(linkedList1, 1);
		linkedList1 = LinkedList.insert(linkedList1, 6);

		LinkedList linkedList2 = new LinkedList();
		linkedList2 = LinkedList.insert(linkedList2, 5);
		linkedList2 = LinkedList.insert(linkedList2, 9);
		linkedList2 = LinkedList.insert(linkedList2, 2);
		
		LinkedList linkedList3 = new LinkedList();
		linkedList3 = LinkedList.insert(linkedList3, 6);
		linkedList3 = LinkedList.insert(linkedList3, 1);
		linkedList3 = LinkedList.insert(linkedList3, 7);

		LinkedList linkedList4 = new LinkedList();
		linkedList4 = LinkedList.insert(linkedList4, 2);
		linkedList4 = LinkedList.insert(linkedList4, 9);
		linkedList4 = LinkedList.insert(linkedList4, 5);
		

		Display.LinkedListdisplay(sumList(linkedList1, linkedList2)); // Using Reverse

		Display.LinkedListdisplay(sumListForward(linkedList3, linkedList4)); // Using Forward


	}

	private static LinkedList sumList(LinkedList linkedList1, LinkedList linkedList2) {
		/*
		 * Eg. 1->2->3 + 5->3->2 = 321 + 235 = 556 Reverse Order
		 */

		LinkedList newList = new LinkedList();

		Node list1Node = linkedList1.head;
		Node list2Node = linkedList2.head;

		int carry = 0;

		while (list1Node != null || list2Node != null) {
			int sum = 0;
			if (list1Node != null) {
				sum = carry + list1Node.data;
				list1Node = list1Node.next;
			}
			if (list2Node != null) {
				sum = sum + list2Node.data;
				list2Node = list2Node.next;
			}
			carry = sum / 10;
			newList = LinkedList.insert(newList, sum % 10);

		}
		return newList;
	}
	
	private static LinkedList sumListForward(LinkedList list1, LinkedList list2) {
		/*
		 * Eg. 1->2->3 + 5->3->2 = 123 + 532 = 655 Reverse Order
		 */
         LinkedList newList = new LinkedList();
         int no1 = 0;  
         int no2 = 0;
         
         while (list1.head!=null) {
        	 no1 = no1*10 + list1.head.data;
        	 list1.head = list1.head.next;
         }
         while (list2.head!=null) {
        	 no2 = no2*10 + list2.head.data;
        	 list2.head = list2.head.next;
         }
         
         int newSum = no1+no2;
       
         Node tail = null;
         
         while(newSum > 0)
         {
        	 Node n1 =new Node(newSum%10);
        	 n1.next = tail;
        	 tail = n1;
        	 newSum = newSum/10;
        	 
         }
         newList.head = tail;
         return newList;
		
	}

}
