package Bit_Manipulation;

public class Pairwise_Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 17;
		System.out.println("17->"+Integer.toBinaryString(17));
		
		int swappedBit = OddEvenSwappedBit(x);
		System.out.println("After Swapped "+swappedBit +"->"+Integer.toBinaryString(swappedBit));
	}

	private static int OddEvenSwappedBit(int x) {

		return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
	}

}
