package Linked_Lists;

import utility.Display;
import utility.LinkedList;
import utility.Node;

public class Partition {

	public static void main(String[] args) {

		/*
		 * Write code to partition a linked list around a value x, such that all nodes
		 * less than x come before all nodes greater than or equal to x. If x is
		 * contained within the list, the values of x only need to be after the elements
		 * less than x (see below). The partition element x can appear anywhere in the
		 * "right partition"; it does not need to appear between the left and right
		 * partitions. EXAMPLE Input: Output: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
		 * [partition= 5] 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
		 */

		// Take input as Unsorted linkedList
		LinkedList linkedlist = new LinkedList();
		linkedlist = LinkedList.insert(linkedlist, 3);
		linkedlist = LinkedList.insert(linkedlist, 5);
		linkedlist = LinkedList.insert(linkedlist, 8);
		linkedlist = LinkedList.insert(linkedlist, 5);
		linkedlist = LinkedList.insert(linkedlist, 10);
		linkedlist = LinkedList.insert(linkedlist, 2);
		linkedlist = LinkedList.insert(linkedlist, 1);
		
		Display.LinkedListdisplay(linkedlist);
		
		// no on around which partition will happen
		int partitionNo = 5;
		
		partition(linkedlist,partitionNo);
	}

	private static void partition(LinkedList linkedlist, int partitionNo) {
		LinkedList lessThan = new LinkedList();
		LinkedList equalToOrGreater = new LinkedList();
		
		Node strt = linkedlist.head;
		while(strt !=null)
		{
			if(strt.data < partitionNo)
			{  
				lessThan = LinkedList.insert(lessThan, strt.data);
			}else
			{
				equalToOrGreater = LinkedList.insert(equalToOrGreater, strt.data);
			}
			strt = strt.next;
		}
		//Final Merge
		LinkedList mergedList = LinkedList.Merge(lessThan, equalToOrGreater);
		
		//Display after Partition
		Display.LinkedListdisplay(mergedList);
		
		
		
	}

}
