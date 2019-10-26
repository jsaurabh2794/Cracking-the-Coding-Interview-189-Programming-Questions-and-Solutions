package Stacks_and_Queues;

import java.util.EmptyStackException;

import userDefinedException.FullStackException;

public class Three_in_One {

	private int noOfStacks = 3;
	private int stackCapacity;
	private int values[]; // values in stack Array
	private int size[];
	
	public void fixedMultiStack(int stackSize)
	{
		stackCapacity = stackSize;
		values = new int[stackCapacity * noOfStacks];
		size = new int[noOfStacks];
	}
	
	public void push(int stackNum, int dataToPush) throws FullStackException
	{
		if(isFullStack(stackNum))
		{
			throw new FullStackException();
		}
		int top = indexOfTop(stackNum);
		size[stackNum]++;
		values[top] = dataToPush;
	}
	
	private int indexOfTop(int stackNum) {
		
		return (stackCapacity*stackNum) + size[stackNum] - 1;
	}

	private boolean isFullStack(int stackNum) {
		return size[stackNum] == stackCapacity;
	}
	
	public int pop(int stackNum) {
		if(size[stackNum] == 0)
		{
			throw new EmptyStackException();
		}
		int top = indexOfTop(stackNum);
		int dataToPop = values[top];
		values[top] = 0; // clear data
		size[stackNum]--;
		return dataToPop;
		
	}
	
	public int peek(int stackNum)
	{
		if(size[stackNum] == 0)
		{
			throw new EmptyStackException();
		}
		int top = indexOfTop(stackNum);
		int dataAtPeek= values[top];
		
		return dataAtPeek;
	}

	
}
