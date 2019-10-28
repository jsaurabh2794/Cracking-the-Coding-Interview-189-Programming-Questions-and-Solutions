package Stacks_and_Queues;

import utility.MyStack;

public class Stack_Min {

	public static void main(String[] args) {
   
		//Test Code
		stackWithMin stackWithMin = new stackWithMin();
		stackWithMin.push(5);
		stackWithMin.push(3);
		stackWithMin.push(1);
		stackWithMin.push(2);
		stackWithMin.push(9);
		stackWithMin.push(0);
		stackWithMin.pop();
		System.out.println(stackWithMin.minInmMinValueStack());
	}
	
	
}

class stackWithMin extends MyStack<Integer>{
	
	MyStack<Integer> minValueStack;

	public stackWithMin() {
		minValueStack = new MyStack<Integer>();
	}

	
	@Override
	public Integer pop() {
		if(super.peek() == minInmMinValueStack())
		{
			minValueStack.pop();
		}
		return super.pop();
	}

	@Override
	public void push(Integer data) {
		if(data < minInmMinValueStack())
		{
			minValueStack.push(data);
		}		super.push(data);
	}

	public int minInmMinValueStack() {
		if(minValueStack.isEmpty())
		{
			return Integer.MAX_VALUE;
		}
		return minValueStack.peek(); //topmost value will be minimum always
	}
	
}