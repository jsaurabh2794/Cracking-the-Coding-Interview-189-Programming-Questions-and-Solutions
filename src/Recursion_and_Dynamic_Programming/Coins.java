package Recursion_and_Dynamic_Programming;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import utility.ExecutionTimeCalculator;

public class Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Given an infinite number of quarters (25 cents), dimes (1O cents), nickels (5
		 * cents), and pennies (1 cent), write code to calculate the number of ways of
		 * representing n cents.
		 */

		int n = 100;
		// With Recursion
		Instant i1 = ExecutionTimeCalculator.timeStart();
		System.out.println(makeChangeV1(n));
		Instant i2 = ExecutionTimeCalculator.timeStop();
		
		System.out.println("Time1:"+Duration.between(i1, i2).toMillis());

		// Without Recursion
		Instant i3 = ExecutionTimeCalculator.timeStart();
		System.out.println(makeChangeV2(n));
		Instant i4 = ExecutionTimeCalculator.timeStop();
		System.out.println("Time2:"+Duration.between(i3, i4).toMillis());
	}

	public static int makeChangeV1(int amount, int[] denoms, int[][] map, int index) {
		if (map[amount][index] > 0) {
			return map[amount][index];
		}
		if (index >= denoms.length - 1)
			return 1; // last denom
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChangeV1(amountRemaining, denoms, map, index + 1);
		}
		map[amount][index] = ways;
		return ways;
	}

	public static int makeChangeV1(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		int[][] map = new int[n + 1][denoms.length];
		return makeChangeV1(n, denoms, map, 0);
	}

	public static int makeChangeV2(int n) {
		int[] denoms = { 2,3,5,10 };
		int[][] map = new int[denoms.length][n+1];

		 // Zero rupees coin using all coins is Always 1 ways
		for(int i=0;i<denoms.length;i++)
		{
			map[i][0] = 1;
		}

		// for the first given denom is it possible to create all amount
		for(int i=1;i<=n;i++)
		{
			map[0][i] = i % denoms[0] == 0 ? 1 : 0  ;
		}
		
		
		
		// Apply for loop
		for (int i = 1; i < denoms.length; i++) {
			for (int j = 1; j <= n; j++) {
              if(denoms[i] > j) // denom is greater than 
              {
            	  map[i][j] = i > 0 ? map[i-1][j] : 0;
              }else
              {
            	  map[i][j] = map[i-1][j] + map[i][j - denoms[i]];
              }
			}
		}

		return map[denoms.length -1][n];
	}

}
