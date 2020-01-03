package Recursion_and_Dynamic_Programming;

enum Color {
	B, W, R, Y, G
}

public class Paint_Fill {

	public static void main(String[] args) {

		// Recurseviely paint whole screen outwards of given point
		Color[][] screen = { { Color.G, Color.G, Color.G }, { Color.G, Color.G, Color.G },
				{ Color.G, Color.G, Color.G } };

		int pixelRow = 1;
		int pixelCol = 1;
		Color newColor = Color.R;
		System.out.println("Before paint fill:");
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}

		boolean doneOrNot = paintFill(screen, pixelRow, pixelCol, newColor);
		if (doneOrNot) {
			System.out.println("After paint fill:");
			for (int i = 0; i < screen.length; i++) {
				for (int j = 0; j < screen[0].length; j++) {
					System.out.print(screen[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

	private static boolean paintFill(Color[][] screen, int pixelRow, int pixelCol, Color newColor) {

		if (screen[pixelRow][pixelCol] == newColor) {
			return false;
		}
		return paintFill(screen, pixelRow, pixelCol, screen[pixelRow][pixelRow], newColor);
	}

	private static boolean paintFill(Color[][] screen, int pixelRow, int pixelCol, Color originalColor,
			Color newColor) {

		if (pixelRow < 0 || pixelRow >= screen.length || pixelCol < 0 || pixelCol >= screen[0].length) {
			return false;
		}
		if (screen[pixelRow][pixelCol] == originalColor) {
			screen[pixelRow][pixelCol] = newColor;
			paintFill(screen, pixelRow - 1, pixelCol, originalColor, newColor); // up
			paintFill(screen, pixelRow + 1, pixelCol, originalColor, newColor); // down
			paintFill(screen, pixelRow, pixelCol - 1, originalColor, newColor); // left
			paintFill(screen, pixelRow, pixelCol + 1, originalColor, newColor); // right

		}

		return true;
	}

}
