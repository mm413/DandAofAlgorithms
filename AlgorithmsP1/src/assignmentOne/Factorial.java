package assignmentOne;

public class Factorial {

	public static long factorial(int num) {
		long total = 1;
		for (int i = 0; i < num; i++) {
			total *= (num - i);
		}
		return total;
	}
}
