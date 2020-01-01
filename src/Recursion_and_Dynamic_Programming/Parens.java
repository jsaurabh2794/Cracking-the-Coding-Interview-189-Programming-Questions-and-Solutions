package Recursion_and_Dynamic_Programming;

import java.io.ObjectInputStream.GetField;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import utility.ExecutionTimeCalculator;

public class Parens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Instant start = ExecutionTimeCalculator.timeStart();

		//System.out.println(generateParensV1(4));
		System.out.println(generateParens(2));

		Instant end = ExecutionTimeCalculator.timeStop();
		System.out.println("Execution Time: " + Duration.between(start, end).toMillis() + " ms");
	}

	private static Set<String> generateParensV1(int remaining) {
		Set<String> parens = new HashSet<String>();
		if (remaining == 0) {
			parens.add("");
			return parens;
		}

		Set<String> prev = generateParensV1(remaining - 1);
		for (String s : prev) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					String newString = insertParenAtEveryLeftParen(s, i);
					parens.add(newString);
				}
			}
			parens.add("()" + s); // begining also we have to add
		}

		return parens;
	}

	private static String insertParenAtEveryLeftParen(String s, int leftIndex) {

		String start = s.substring(0, leftIndex + 1);
		String end = s.substring(leftIndex + 1);

		return start + "()" + end;
	}

	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem)
			return;// invalid state

		if (leftRem == 0 && rightRem == 0) {/* Out of left and right parentheses */
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '(';// Add left and recurse
			addParen(list, leftRem - 1, rightRem, str, index + 1);

			str[index] = ')';// Add right and recurse
			addParen(list, leftRem, rightRem - 1, str, index + 1);
		}
	}

	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}

}
