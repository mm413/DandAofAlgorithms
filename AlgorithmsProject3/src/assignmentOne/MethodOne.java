/**Mark Meade
 * 11/8/19
 *MethodOne.java
 */

package assignmentOne;

public class MethodOne {
	
	public static long calculate(int n, int k) {
		long solution;
		
		//had to use these temp things to stop divide by 0 error.
		long tempnk = Factorial.factorial(n-k);
		if (tempnk == 0) {
			tempnk = 1;
		}
		long tempk = Factorial.factorial(k);
		if (tempk == 0) {
			tempk = 1;
		}
		solution = Factorial.factorial(n) / (tempk*tempnk);
		return solution;
	}
}
