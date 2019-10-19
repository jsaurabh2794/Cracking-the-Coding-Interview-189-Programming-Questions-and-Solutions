package arrays_and_string;

import java.util.Scanner;

public class Is_Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter string to check is unique characters:");
		String str= inp.next();
		//Suppose ASCII char set is using...means 128 character will be there
		boolean charSet[]= new boolean[128];
		boolean isUnique = true;
		for (int i=0;i< str.length();i++)
		{
			int val = str.charAt(i);
			if(charSet[val])
			{
				isUnique = false;
				break;
			}
			charSet[val] = true;
		}
		if(!isUnique)
		{
			System.out.println("Not unique characters.");
		}else
		{
			System.out.println("unique characters.");

		}
		inp.close();
	}

}
