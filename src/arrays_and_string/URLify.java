package arrays_and_string;

import java.util.Scanner;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String url = input.nextLine();
		int count = input.nextInt();
		
		urlify(url,count);

	}

	public static void urlify(String url, int trueLength) {
		
		   String wordArray[] = url.split(" ");
		   StringBuffer newurl = new StringBuffer("");
		   for(int i =0;i< wordArray.length-1;i++)
		   {
			   newurl.append(wordArray[i]+"%20");
		   }
		   newurl.append(wordArray[wordArray.length-1]);
		   System.out.println(newurl);
		
	}

}
