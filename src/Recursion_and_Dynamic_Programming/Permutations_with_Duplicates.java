package Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;

public class Permutations_with_Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getPermutation("Saa"));
	}

	private static ArrayList<String> getPermutation(String s) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}

	private static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining,
			ArrayList<String> result) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c, count - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c, count);
			}
		}
	}

	private static HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}
}
