package Stacks_and_Queues;

import utility.Display;
import utility.MyStack;

public class Sort_Stack {

	public static void main(String[] args) {

		MyStack<Integer> stackNeedToBeSorted = new MyStack<Integer>();
		stackNeedToBeSorted.push(5);
		stackNeedToBeSorted.push(4);
		stackNeedToBeSorted.push(6);
		stackNeedToBeSorted.push(8);
		stackNeedToBeSorted.push(7);
		stackNeedToBeSorted.push(1);
		
		Display.StackDataDisplay(stackNeedToBeSorted);
		sortStackUsingOneExtraStack extraStack=new sortStackUsingOneExtraStack();
		Display.StackDataDisplay(extraStack.sort(stackNeedToBeSorted));

	}

}

class sortStackUsingOneExtraStack {

	MyStack<Integer> tempStack = new MyStack<Integer>();

	public MyStack<Integer> sort(MyStack<Integer> stackToSort) {
		while (!stackToSort.isEmpty()) {
			tempStack.push(stackToSort.pop()); // copied into temp stack
		}
		while (!tempStack.isEmpty()) {
			int dataToPushAtCorrectPlace = tempStack.pop();
			while (!stackToSort.isEmpty() && stackToSort.peek() < dataToPushAtCorrectPlace) {
				tempStack.push(stackToSort.pop());
			}
			stackToSort.push(dataToPushAtCorrectPlace);
		}

		return stackToSort;
	}

}