package Recursion_and_Dynamic_Programming;

public class Magic_Index {

	public static void main(String[] args) {

		int[] magicIndexArray = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		System.out.println(getMagicIndex(magicIndexArray));
		System.out.println(magicIndexVersion2(magicIndexArray, 0, magicIndexArray.length - 1));

	}

	private static int getMagicIndex(int[] array) {
		return magicIndex(array, 0, array.length - 1);
	}

	private static int magicIndex(int[] array, int start, int end) {
		if (start > end) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		if (midIndex == array[midIndex]) {
			return midIndex;
		} else if (array[midIndex] > midIndex) {
			return magicIndex(array, start, midIndex - 1);
		} else {
			return magicIndex(array, midIndex + 1, end);
		}
	}

// if not distinct element
	private static int magicIndexVersion2(int[] array, int start, int end) {
		if (start > end) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		if (midIndex == array[midIndex]) {
			return midIndex;
		}
		// search left
		int leftIndex = Math.min(midIndex - 1, array[midIndex]);
		int left = magicIndexVersion2(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		// search right
		int rightIndex = Math.max(midIndex + 1, array[midIndex]);
		int right = magicIndexVersion2(array, rightIndex, end);
		return right;
	}
}
