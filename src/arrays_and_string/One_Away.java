package arrays_and_string;

import java.util.Scanner;

public class One_Away {

	public static void main(String[] args) {

		/* Question:
		 * There are three types of edits that can be performed on strings: insert a
		 * character, remove a character, or replace a character. Given two strings,
		 * write a function to check if they are one edit (or zero edits) away.
          EXAMPLE
		 * pale, ple -> true 
		 * pales, pale -> true 
		 * pale, bale -> true 
		 * pale, bae -> false
		 */

		// Take boyh string as input
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter first string:");
		String first = inp.next();
		System.out.print("Enter Second string:");
		String second = inp.next();

		// check if both strings is equal means--One Replace is required.
		
	    if (first.length() == second.length()) {
			System.out.println(oneReplaceCheck(first, second));
		} else if (first.length() + 1 == second.length()) {
			// handling both insertion and removal using one method
            System.out.println(oneInsertCheck(second,first));
		}
		else if (first.length()  == second.length() + 1) {
			// handling both insertion and removal using one method
            System.out.println(oneInsertCheck(first,second));
		}

	}

	private static boolean oneInsertCheck(String First, String Second) {
		int indexForStringOne = 0;
		int indexForStringTwo = 0;
		
		while(indexForStringOne < First.length() && indexForStringTwo < Second.length())
		{
			if(First.charAt(indexForStringTwo) != Second.charAt(indexForStringOne))
			{
				if(indexForStringOne != indexForStringTwo)
				{
					return false;
				}
				indexForStringTwo++;
			}else
			{
				indexForStringOne++;
				indexForStringTwo++;
			}
		}
		return true;
		
	}

	private static boolean oneReplaceCheck(String first, String second) {
		boolean oneReplaceDone = false;
		for(int i=0; i< first.length(); i++)
		{
			if(first.charAt(i) != second.charAt(i))
			{
				if(oneReplaceDone)
				{
					return false;
				}
			oneReplaceDone = true;	
			}
		}
		return true;

	}

}
