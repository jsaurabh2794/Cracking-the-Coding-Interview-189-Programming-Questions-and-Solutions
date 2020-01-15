package Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class Eight_Queens {

	static final int GRID_SIZE = 4;
	public static void main(String[] args) {
		// We only need a single array where column [ r] = c indicates that row r has a queen at column c

		Integer[] column = new Integer[GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueen(0,column,results); // start putting from 0th row
		for(Integer[] intgerArray: results) {
			System.out.println(Arrays.asList(intgerArray));
		}
		
	}
	private static void placeQueen(int row, Integer[] column, ArrayList<Integer[]> results) {	
		if(row == GRID_SIZE) {
			results.add(column.clone()); // putting queen col Wise
		}else
		{
			for(int col = 0; col<GRID_SIZE;col++) {
				if(checkValidLocation(row,col,column)) {
					column[row] = col;
					placeQueen(row+1, column, results);
				}
			}
		}
	}
	private static boolean checkValidLocation(int row1, int col1, Integer[] column) {

		// check till that row in every column
		for(int row2 = 0; row2 < row1; row2++)
		{
			int col2 = column[row2];
			if(col2 == col1) // if same column
			{
				return false;
			}
			//diagonals check
			int colDistance = Math.abs(col2 - col1); 
			int rowDistance = Math.abs(row2 - row1);
			
			if(colDistance == rowDistance)
			{
				return false;
			}
			// no need to check last tow because still it needs to fill
			
		}
		
		return true;
	}

}
