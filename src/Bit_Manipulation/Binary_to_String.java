package Bit_Manipulation;

import java.util.Scanner;

public class Binary_to_String {

	public static void main(String[] args) {

		// Input to convert into Binary
		Scanner input = new Scanner(System.in);

		/*
		 * double number = input.nextDouble(); String binaryToString =
		 * binaryToString(number); System.out.println(binaryToString);
		 */

		/*
		 * int numberToBinary = input.nextInt(); String decimalToBinary =
		 * decimalToBinary(numberToBinary); System.out.println(decimalToBinary);
		 */
		
		double numberToBinary = input.nextDouble();
		String decimalToBinary = decimalToBinary(numberToBinary);
		System.out.println(decimalToBinary);

	}

	private static String binaryToString(double number) {

		StringBuilder binaryToString = new StringBuilder("");
		if (number >= 1 || number < 0) {
			return "ERROR";
		}

		binaryToString.append(".");
		while (number > 0) {
			// Limit is up to 32 Character
			if (binaryToString.length() >= 32) {
				System.out.println(binaryToString.toString());
				return "ERROR";
			}
			double num = 2 * number;
			if (num >= 1) {
				binaryToString.append("1");
				number = num - 1;
			} else {
				binaryToString.append("0");
				number = num;
			}
		}

		return binaryToString.toString();
	}

	private static String decimalToBinary(int number) {
		StringBuilder decimalToBinary = new StringBuilder("");

		if (number < 0) {
			return "ERROR";
		}

		while (number > 0) {
			decimalToBinary.append(number % 2);
			number = number / 2;
		}

		return decimalToBinary.reverse().toString();
	}

	private static String decimalToBinary(double number) {
		StringBuilder decimalToBinary = new StringBuilder("");

		if (number < 0) {
			return "ERROR";
		}
		
		int integralPart = (int)number;
		double fractionalPart = number - integralPart;
		
		decimalToBinary.append(decimalToBinary(integralPart));
		decimalToBinary.append(binaryToString(fractionalPart));
		
		return decimalToBinary.toString();

	}
}
