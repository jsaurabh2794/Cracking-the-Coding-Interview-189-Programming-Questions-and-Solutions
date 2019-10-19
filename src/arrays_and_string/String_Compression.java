/**
 * 
 */
package arrays_and_string;

import java.util.Scanner;

/**
 * @author SAURABH SINGH RAJPUT
 *
 */
public class String_Compression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		
		System.out.println(stringCompression(str));
	}

	private static String stringCompression(String str) {
		StringBuffer finalString = new StringBuffer("");
		int characterCount = 1;
		for (int i = 0; i < str.length(); i++) {
			if(i+1 < str.length() && str.charAt(i) == str.charAt(i+1))
			{
				characterCount++;
			}else
			{
				finalString.append(str.charAt(i)+""+characterCount);
				characterCount = 1;
			}
		}
        
		if(finalString.toString().length() < str.length())
		{   
			return finalString.toString();
		}else
		{
			return str;
		}
	}

}
