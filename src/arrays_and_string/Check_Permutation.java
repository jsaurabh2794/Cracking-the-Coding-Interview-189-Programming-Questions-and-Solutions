package arrays_and_string;

import java.util.Scanner;

public class Check_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter two string to check one is a permutation of the other");
		String s1 = inp.next();
		String s2 = inp.next();
		int isPermutation = 1;
		boolean charSet[] = new boolean[128];
		if (s1.length() != s2.length()) {
			System.out.println("one is not a permutation of the other");
		}
		for (int i = 0; i < s1.length(); i++) {
			charSet[s1.charAt(i)] = true;
		}
		for (int i = 0; i < s2.length(); i++) {
			if (!charSet[s1.charAt(i)]) {
				isPermutation = 0;
				break;

			}
		}
		if(isPermutation == 0)
		{
			System.out.println("one is not a permutation of the other");

		}else
		{
			System.out.println("one is a permutation of the other");

		}
	}

}
