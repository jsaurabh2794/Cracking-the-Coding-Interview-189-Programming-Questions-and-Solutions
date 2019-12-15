package Bit_Manipulation;

public class Flip_Bit_to_Win {

	public static void main(String[] args) {

	System.out.println(maxNoOfSequence(1775));
	}

	private static int maxNoOfSequence(long a) {

		if (~a == 0) { // if all are 1s then
			return Integer.BYTES * 8;
		}

		int currentLength = 0;
		int prevLength = 0;
		int maxLength = 1;
		while (a != 0) {
			if ((a & 1) == 1) { // Current bit is 1
                currentLength++;
			}else if((a & 1) == 0) {
				// Current bit is Zero
				//prevLength will be equal currentLength(if next bit is 1) else set to Zero;
				prevLength = (a & 2) == 0 ? 0:currentLength;
				currentLength = 0;
			}
		maxLength = Math.max(prevLength+currentLength+1, maxLength);
        a >>>=1; // Right shift with left pos shift to Zero;
		}

		return maxLength;
	}

}
