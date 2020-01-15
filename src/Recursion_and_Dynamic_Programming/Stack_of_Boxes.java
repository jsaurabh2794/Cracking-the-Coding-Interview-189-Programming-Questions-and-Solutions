package Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Stack_of_Boxes {

	static class Box {

		int height, width, length;

		public Box(int height, int width, int length) {
			this.height = height;
			this.width = width;
			this.length = length;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public boolean canBeAbove(Box bottom) {

			return this.height > bottom.height ;
		}

	}

	public static void main(String[] args) {

		ArrayList<Box> boxesList = new ArrayList<Box>();
		boxesList.add(new Box(10, 11, 12));
		boxesList.add(new Box(13, 14, 15));
		boxesList.add(new Box(16, 17, 18));
		boxesList.add(new Box(19, 20, 21));
		boxesList.add(new Box(22, 23, 24));

		int maxHeightStack = creeateStack(boxesList);
		System.out.println(maxHeightStack);

	}

	private static int creeateStack(ArrayList<Box> boxesList) {
		// TODO Auto-generated method stub
		/* Sort in decending order by height. */
		Collections.sort(boxesList, new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				// TODO Auto-generated method stub
				return o2.height - o1.height;
			}
		});
		int maxHeight = 0;
		for (int i = 0; i < boxesList.size(); i++) {
			int height = createStack(boxesList, i);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}

	private static int createStack(ArrayList<Box> boxesList, int bottomindex) {
		Box bottom = boxesList.get(bottomindex);
		int maxHeight = 0;
		for (int i = bottomindex + 1; i < boxesList.size(); i++) {
			if (boxesList.get(i).canBeAbove(bottom)) {
				int height = createStack(boxesList, i);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		maxHeight += bottom.height;
		return maxHeight;
	}
}
