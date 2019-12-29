/**
 * 
 */
package Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author SAURABH SINGH RAJPUT
 *
 */
public class Robot_in_a_Grid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int gridTotalRow = 5;
		int gridTotalColumn = 4;
		
		int Grid[][] = new int[gridTotalRow][gridTotalColumn];
		ArrayList<Point> path = getPath(Grid, gridTotalRow, gridTotalColumn);
		System.out.print("Path:");
		for(Point p: path) {
			System.out.print("("+p.row+","+p.column+")->");
		}
		System.out.print("End");
	}

	static class Point{
		int row, column;

		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}
		
	}
	
	public static ArrayList<Point> getPath(int[][] Grid, int row, int column){
		ArrayList<Point> path =  new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if( path(Grid, row-1, column-1, path, failedPoints)){
			return path;
		}
		return null;
	}

	private static boolean path(int[][] grid, int i, int j, ArrayList<Point> path,
			HashSet<Point> failedPoints) {
		if(i< 0 || j < 0) {
			return false;
		}
		// check this point is present as failed point to reach to goal
		Point p = new Point(i, j);
		if(failedPoints.contains(p)) {
			return false;
		}
		
		// check if we reached to origin
		boolean isAtOrigin = (i==0 && j==0);
		
		if(isAtOrigin || path(grid, i-1, j, path, failedPoints) || path(grid, i, j-1, path, failedPoints)) {
			path.add(p);
			return true;
		}
		// means it did not enter to if block
		failedPoints.add(p); // cache the 
		return false;
	}
}
