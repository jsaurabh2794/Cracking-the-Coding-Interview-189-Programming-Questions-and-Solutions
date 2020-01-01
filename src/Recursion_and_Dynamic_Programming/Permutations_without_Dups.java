package Recursion_and_Dynamic_Programming;

import java.util.ArrayList;

public class Permutations_without_Dups {

	public static void main(String[] args) {
		System.out.println(getPermutation("Saa"));
	}

	private static ArrayList<String> getPermutation(String word) {

		ArrayList<String> permutations = new ArrayList<String>();
		if (word.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char firstChar = word.charAt(0);
		String remainder = word.substring(1);
		ArrayList<String> words = getPermutation(remainder);
		for (String w : words) {
			for (int i = 0; i <=w.length(); i++) {
				String s = insertCharAt(w, firstChar, i);
				if(!permutations.contains(s))
				{
				permutations.add(s); //handles the duplicate
				}
			}
		}
		return permutations;
	}

	private static String insertCharAt(String word, char firstChar, int i) {

		String first = word.substring(0, i);
		String end = word.substring(i);
		return first + firstChar + end;
	}
}
