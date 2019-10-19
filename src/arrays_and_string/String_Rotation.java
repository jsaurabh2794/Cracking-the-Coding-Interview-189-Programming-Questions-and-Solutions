package arrays_and_string;

import java.util.Scanner;

public class String_Rotation {

	public static void main(String[] args) {
		/*
		 * Assume you have a method isSub05tring which checks if one word is a substring
		 * of another. Given two strings, 51 and 52, write code to check if 52 is a
		 * rotation of 51 using only one call to i5Sub5tring (e.g.,"waterbottle" is a
		 * rotation of"erbottlewat )
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("is String2 is rotation of string2?:");
		String str1 = input.nextLine();
		String str2 = input.nextLine();
		
		System.out.println(String_Rotation.isSubstring(str1,str2));

	}

	private static boolean isSubstring(String str1, String str2) {
     if(str1.length()!=str2.length() || str1.length() == 0 || str2.length()==0)
     {
    	 return false;
     }
     String newString = str1 + str1;
     if(newString.indexOf(str2) == -1)
     {
    	 return false;
     }
	return true;
	}

}
