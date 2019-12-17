package Bit_Manipulation;

public class Conversion {

	static int count;
	public static void main(String[] args) {

		System.out.println("29-->"+Integer.toBinaryString(29));
		System.out.println("15-->"+Integer.toBinaryString(15));
        //System.out.println(Integer.toBinaryString(7 << 1));
		System.out.println("29 XOR 15 -->"+ Integer.toBinaryString((29^15)));
		
		System.out.println(noOfBitFlipedToConvert(29,15));
	}

	public static int noOfBitFlipedToConvert(int A, int B) {

		for (int c = A ^ B; c != 0; c = c >> 1) {

		 count += c & 1;
		}

		return count;
	}
}
