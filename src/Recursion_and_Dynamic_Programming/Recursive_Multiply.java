package Recursion_and_Dynamic_Programming;

public class Recursive_Multiply {

	public static void main(String[] args) {
		int productResult = getProductRecursively(8, 8);
		System.out.println(productResult);

	}

	private static int getProductRecursively(int i, int j) {

		int smaller = i > j ? j : i;
		int bigger = i > j ? i : j;

		return produtRecursively(smaller, bigger);
	}

	private static int produtRecursively(int smaller, int bigger) {

		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}

		int s = smaller >> 1; // divide by two
		int halfProduct = getProductRecursively(s, bigger);
		if (smaller % 2 == 0) {
			return halfProduct + halfProduct; // * by 2
		} else {
			return halfProduct + halfProduct + bigger; // if odd then one more extra addtion of bigger part.
		}
	}

}
