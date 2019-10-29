package Stacks_and_Queues;

import utility.QueueUsingTwoStacks;

public class Queue_via_Stacks {

	public static void main(String[] args) {

		QueueUsingTwoStacks<Integer> queueUsingTwoStacks = new QueueUsingTwoStacks<Integer>();
		queueUsingTwoStacks.add(5);
		queueUsingTwoStacks.add(6);
		queueUsingTwoStacks.add(7);
		queueUsingTwoStacks.add(8);
		queueUsingTwoStacks.add(9);
		
		System.out.println("Peek is:"+queueUsingTwoStacks.peek());
		System.out.println("Removed element is:"+queueUsingTwoStacks.remove());

	}

}

