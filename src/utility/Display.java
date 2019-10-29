package utility;

import utility.MyStack.StackNode;

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

	public static <T> void StackDataDisplay(MyStack<T> stack)
	{
		StackNode<T> top = stack.top;
		System.out.println("--");
		while(top!=null)
		{
			System.out.println(top.data);
			top = top.next;
		}
	   System.out.println("--");		
	}
}
