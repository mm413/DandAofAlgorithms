package assignmentOne;

public class MethodThree {
	
	public static long calculate(int n, int k) {
		long num;
		if (k == 0 || n == k) {
			num = 1;
		} else {
			num = calculate((n-1), (k-1)) + calculate(n-1, k);
		}
		return num;
	}
}
