package Bit_Manipulation;

public class Insertion {

	/*
	 * You are given two 32-bit numbers, N and M, and two bit positions, iand j.
	 * Write a method to insert Minto N such that Mstarts at bit j and ends at bit
	 * i. You can assume that the bits j through ihave enough space to fit all of M.
	 * That is, if M = 10011, you can assume that there are at least 5 bits between
	 * j and i. You would not, for example, have j = 3and i= 2, because Mcould not
	 * fully fit between bit 3 and bit 2.
	 */
	/*
	 * EXAMPLE Input: N = 10000000000 ,M 10011 10011, i = 2, j=6 output: 10001001100
	 */

	public static void main(String args[]) {

		int n = 1024, m = 19, i = 2, j = 6;
		int result = updateBits(n, m, i, j);
		System.out.println("After update is:" + result);
		System.out.println("Binary of 'result'->" + Integer.toBinaryString(result));

	}

	public static int updateBits(int n, int m, int i, int j) {
		// create Mask bit to clear bit from i through j eg.i = 2, j =4 then
		// result should be 1110011
		
		System.out.println("Binary of 'n->'"+Integer.toBinaryString(n));
		System.out.println("Binary of 'm->'"+Integer.toBinaryString(m));
		
		System.out.println("---------------------------------------------");

		int allOnes = ~0; // will give 32bit(OS int Size) sequence of ones
		System.out.println("Binary of 'allOnes'->" + Integer.toBinaryString(allOnes));
		// all 1s before j then all 0s eg. 11100000

		int right = allOnes << (j + 1);
		System.out.println("Binary of 'right'->" + Integer.toBinaryString(right));

		// all 1s after i position
		int left = (1 << i) - 1;
		System.out.println("Binary of 'left'->" + Integer.toBinaryString(left));

		/* (1 << 2) - 1 = 100 - 1 = 011 */

		int mask = right | left; // bitwise OR
		System.out.println("Binary of 'mask'->" + Integer.toBinaryString(mask));

		// clear bit from i through j

		int nWithClearedBit = n & mask; // bitwise AND will make all position from i to j -> Zero
		System.out.println("Binary of 'nWithClearedBit'->" + Integer.toBinaryString(nWithClearedBit));

		// shift M to correct position so it can fit over there

		int mWithShiftedBit = m << i;
		System.out.println("Binary of 'mWithShiftedBit'->" + Integer.toBinaryString(mWithShiftedBit));

		return nWithClearedBit | mWithShiftedBit; // bitwise OR

	}
}
