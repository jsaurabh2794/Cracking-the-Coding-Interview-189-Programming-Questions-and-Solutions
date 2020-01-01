package utility;

import java.time.Duration;
import java.time.Instant;

public class ExecutionTimeCalculator {

	static Instant start;
	static Instant finish;
	
	public static Instant timeStart() {
		start = Instant.now();
		return start;
	}
	
	public static Instant timeStop() {
		finish = Instant.now();
		return finish;
	}
	
}
