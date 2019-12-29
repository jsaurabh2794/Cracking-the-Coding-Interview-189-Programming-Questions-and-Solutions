package Recursion_and_Dynamic_Programming;

import java.util.Arrays;

public class Triple_Step {

	public static void main(String[] args) {

		int noOfSteps = 3;
		System.out.println(getNoOfCountWays(noOfSteps));
	}

	public static int getNoOfCountWays(int n) {
		int memory[] = new int[n + 1];
		Arrays.fill(memory, -1);
		return noOfCountWays(n, memory);
	}

	private static int noOfCountWays(int n, int[] memory) {
		if(n < 0) {
			return 0;
		}else if(n == 0) {
			return 1;
		}else if(memory[n] > -1) {
			return memory[n];
		}else {
			return noOfCountWays(n-1, memory)+noOfCountWays(n-2, memory)+noOfCountWays(n-3, memory);
		}
		
	}

}
