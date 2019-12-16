package Bit_Manipulation;

class Next_Number {

	// Main Function to find next
	// smallest number bigger than n
	static int getNext(int n) {

		/* Compute c0 and c1 */
		int c = n;
		int c0 = 0;
		int c1 = 0;

		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}

		// If there is no bigger number
		// with the same no. of 1's
		if (c0 + c1 == 31 || c0 + c1 == 0)
			return -1;

		// position of rightmost
		// non-trailing zero
		int p = c0 + c1;

		// Flip rightmost
		// non-trailing zero
		n |= (1 << p);

		// Clear all bits
		// to the right of p
		n &= ~((1 << p) - 1);

		// Insert (c1-1) ones
		// on the right.
		n |= (1 << (c1 - 1)) - 1;

		return n;
	}

	// Driver Code
	public static void main(String[] args) {

		int n = 5; // input 1
		System.out.println(getNext(n));

		n = 8; // input 2
		System.out.println(getNext(n));
	}
}
