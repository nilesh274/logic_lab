package day4;

public class IDGenerator {
	private static int next = 1000;
	
	public static int nextId() {
		return next++;
	}
}
