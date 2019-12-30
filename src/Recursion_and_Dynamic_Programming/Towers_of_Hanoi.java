package Recursion_and_Dynamic_Programming;

public class Towers_of_Hanoi {

	public static void main(String[] args) {

		moveDiscs(3, "A", "C", "B");
	}

	//First to Last using middle
	private static void moveDiscs(int n, String First, String Last, String Middle)
	{
		if(n <=0) {
			return;
		}
		moveDiscs(n-1, First, Middle, Last); // First-> Middle using Last
		moveTop(n,First,Last);
		moveDiscs(n-1, Middle, Last, First); // Middle -> Last using First
	}

	private static void moveTop(int n, String first, String last) {
		System.out.println("Move Disc no "+ n + " from "+first+"-> "+last);
	}
	
}

