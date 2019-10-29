package utility;

public class QueueUsingTwoStacks<T> {

	MyStack<T> stack1 = new MyStack<T>(); //For Adding
	MyStack<T> stack2 = new MyStack<T>(); // For Removing
	
	public void add(T data)
	{
		stack1.push(data);
	}
	public T peek()
	{
		shiftDataFromStack1ToStack2();
		T data = stack2.peek();
		return data;
		
	}
	public T remove()
	{
		shiftDataFromStack1ToStack2();
		T data = stack2.pop();
		return data;
	}
	
	public void shiftDataFromStack1ToStack2()
	{
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}
}
