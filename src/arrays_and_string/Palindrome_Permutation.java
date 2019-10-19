package arrays_and_string;

import java.util.Hashtable;
import java.util.Scanner;

public class Palindrome_Permutation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine().toUpperCase();
        Hashtable<Character, Integer> characterCount = new Hashtable<Character, Integer>();
		int charset[] = new int[128];
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)!=' ')
			{
				charset[str.charAt(i)]++;
				if(characterCount.get(str.charAt(i))!=null)
				{
					int count = characterCount.get(str.charAt(i));
					characterCount.put(str.charAt(i),count+1);
				}else
				
					characterCount.put(str.charAt(i),1);
				}

			}
		
		palindromePermutation_v_2(characterCount);
		
		palindromePermutation_v_1(charset);
		}





	private static void palindromePermutation_v_2(Hashtable<Character, Integer> characterCount) {
		int onlyOneCharacterhaveOddCount = 0;
		boolean flagForPossible = true;
		for(int val: characterCount.values())
		{
		
			if(val % 2 == 1 && onlyOneCharacterhaveOddCount ==0)
			{
				onlyOneCharacterhaveOddCount++;
			}else if(val % 2 !=0)
			{
				flagForPossible = false;
				break;
			}
		}
		if(flagForPossible)
		{
			System.out.println("Yes");
		}else
		{
			System.out.println("No");
		}
	}
		
		
		
	

	private static void palindromePermutation_v_1(int[] charset) {
		boolean allcharMultipleoftwotimes = true;
		int OddNoofCharacter = 0;
		
		for (int i = 0; i < charset.length; i++) {
			
			if(charset[i] !=0)
			{
				if(charset[i]%2 == 1 && OddNoofCharacter == 0)
				{
					OddNoofCharacter++;
				}else if(charset[i] %2!= 0)
				{
					allcharMultipleoftwotimes = false;
				}
			}
		}
		
		if(allcharMultipleoftwotimes && (OddNoofCharacter == 0 || OddNoofCharacter == 1))
		{
			System.out.println("Yes");
		}else
		{
			System.out.println("No");	
		}
	}

}
