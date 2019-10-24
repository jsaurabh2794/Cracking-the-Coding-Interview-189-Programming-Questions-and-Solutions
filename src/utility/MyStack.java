package utility;

import java.util.EmptyStackException;

public class MyStack<T> {

	public static class StackNode<T> {
		public T data;
		public StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}

	}
	
	public StackNode<T> top;
	
	public T pop() {
		if(top == null)
		{
			throw new EmptyStackException();
		}
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public void push(T data)
	{
		StackNode<T> node = new StackNode<T>(data);
		node.next = top;
		top = node;
	}
	
	public T peek()
	{
		if(top == null)
		{
			throw new EmptyStackException();
		}
		return top.data;
	}
	public boolean isEmpty()
	{
		return top == null;
	}
}
