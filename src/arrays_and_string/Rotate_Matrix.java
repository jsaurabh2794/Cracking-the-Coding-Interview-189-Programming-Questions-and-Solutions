package arrays_and_string;

public class Rotate_Matrix {

	public static void main(String[] args) {

		/**
		 * Given an image represented by an NxN matrix, where each pixel in the image is 4
           bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
		 */
		 
		// 2D Array Inialization
		int[][] matrix = { { 1, 2, 3 ,4 }, { 5, 6, 7,8 }, { 9, 10, 11,12 }, {13,14,15,16} };
		//int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotateClockWise(matrix); 
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println("\n");
		}
	}

	public static int[][] rotate(int[][] matrix) { //Book Method
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return matrix;
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top= matrix[first][i]; // top
				matrix[first][i] = matrix[last-offset][first]; //left -> top
				matrix[last-offset][first] = matrix[last][last - offset]; // bottom -> left
				matrix[last][last - offset] = matrix[i][last]; // right -> bottom
				matrix[i][last] = top; // right <- top
			}
		}
		return matrix;
	}
	/*Own Implementation -- inplace method*/
	public static int[][] rotateClockWise(int[][] matrix) {
		
		transpose(matrix);
		
		//clockWiseRotation(matrix);

		
		antiClockWiseRotation(matrix);


		return matrix;
	}

	private static int[][] transpose(int[][] matrix) {
		//First find transpose of matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix [i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			
		}
		return matrix;
	}

	private static int[][] antiClockWiseRotation(int[][] matrix) {
		//to get anti-clockwise rotation of original matrix -- rotate column wise of transposed matrix
		for (int i = 0; i < matrix.length; i++) {
			int indexFromLast = matrix.length - 1;
			for (int j = 0; j < matrix[0].length; j++) {
				if(indexFromLast > j)
				{
					int temp = matrix[indexFromLast][i];
					matrix[indexFromLast][i] = matrix[j][i];
					matrix[j][i]= temp;
					indexFromLast--;
				}else
				{
					break;
				}
			}
		}
		//to get anti-clockwise rotation of original matrix -- rotate column wise of transposed matrix
		return matrix;
	}
	/*Own Implmentation*/

	private static int[][] clockWiseRotation(int[][] matrix) {
		//to get clockwise rotation of original matrix -- rotate row wise of transposed matrix

		for (int i = 0; i < matrix.length; i++) {
			int indexFromLast = matrix.length - 1;
			for (int j = 0; j < matrix[0].length; j++) {
				if (indexFromLast > j) {
					int temp = matrix[i][indexFromLast];
					matrix[i][indexFromLast] = matrix[i][j];
					matrix[i][j] = temp;
					indexFromLast--;
				} else {
					break;
				}
			}
		}
		 
		//to get clockwise rotation of original matrix -- rotate row wise of transposed matrix
		return matrix;
	}
}
