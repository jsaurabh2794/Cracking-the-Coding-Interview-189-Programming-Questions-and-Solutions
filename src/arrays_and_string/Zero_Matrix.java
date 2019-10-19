package arrays_and_string;

public class Zero_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2D Array initialization
		int[][] matrix = { { 1, 2, 3, 4 }, { 0, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
		// int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		// To Nulify the row
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				matrixToNulify("row", i,matrix);
			}
		}

		// To Nulify the col
		for (int i = 0; i < col.length; i++) {
			if (col[i]) {
				matrixToNulify("col", i,matrix);
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println("\n");
		}
	}

	private static int[][] matrixToNulify(String string, int i, int[][] matrix) {
		// TODO Auto-generated method stub
       if(string.equals("row"))
       {
    	  for (int j = 0; j < matrix.length; j++) {
			matrix[i][j] = 0;
		} 
       }else
       {
    	   for (int j = 0; j < matrix[0].length; j++) {
   			matrix[j][i] = 0;
   		}  
       }
       return matrix;
	}

}
