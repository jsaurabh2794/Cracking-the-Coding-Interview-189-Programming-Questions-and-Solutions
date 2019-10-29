package Stacks_and_Queues;

import java.util.ArrayList;
import java.util.EmptyStackException;

import utility.MyStack;

public class Stack_of_Plates {

	public static void main(String[] args) {

		SetOfStacks setOfStacks = new SetOfStacks(3);
		setOfStacks.pushToStack(3);
		setOfStacks.pushToStack(4);
		setOfStacks.pushToStack(5);
		setOfStacks.pushToStack(6);
		setOfStacks.pushToStack(7);
		setOfStacks.pushToStack(8);
		setOfStacks.pushToStack(9);
		
		setOfStacks.popFromTheStack();
		System.out.println(setOfStacks.popFromTheStack());
	}

}

class SetOfStacks {
	ArrayList<MyStack<Integer>> stacksOfPlates;
	int thresholdStackSizeOfPlates; // Maximum plates can be there in one stack
	MyStack<Integer> CurrentPlateStack;

	public SetOfStacks(int thresholdStackSizeOfPlates) {
		CurrentPlateStack = new MyStack<Integer>();
		stacksOfPlates = new ArrayList<MyStack<Integer>>();
		this.thresholdStackSizeOfPlates = thresholdStackSizeOfPlates;
		stacksOfPlates.add(CurrentPlateStack);
	}

	public void pushToStack(int plateNo) {
		if (getLastStack() != null && (getLastStack().sizeOfStack() < thresholdStackSizeOfPlates)) {
			CurrentPlateStack.push(plateNo);
		}else
		{
			CurrentPlateStack = new MyStack<Integer>();
			CurrentPlateStack.push(plateNo);
			stacksOfPlates.add(CurrentPlateStack);
			
		}
	}
	
	public int popFromTheStack()
	{
		MyStack<Integer> lastStack = getLastStack();
		if(lastStack.isEmpty())
		{
			throw new EmptyStackException();
		}
		int popedPlate = lastStack.pop(); //poping the item
		if(lastStack.size == 0) // if size is zero in last stack we remove that stack from list of stacks
		{
			stacksOfPlates.remove(stacksOfPlates.size() - 1);
			
		}
		if(stacksOfPlates.size() > 0) // if still list of stacks is greater than zero than we assign last stack to current plate of stack
		{
			CurrentPlateStack = stacksOfPlates.get(stacksOfPlates.size() - 1);
		}
		return popedPlate;
	}
	

	public MyStack<Integer> getLastStack() {
		return this.CurrentPlateStack;
	}
}