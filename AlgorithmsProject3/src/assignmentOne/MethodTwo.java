/**Mark Meade
 * 11/8/19
 *MethodTwo.java
 */

package assignmentOne;
import java.lang.Math;

public class MethodTwo {
	
	public static long calculate(int n, int k) {
		long total;
		long numerator= 1;
		long denom = Factorial.factorial(k);
		int i = 1;
		while (i <= k) {
			numerator *= Math.abs(i - (n+1));
			i++;
		}
		total = numerator/denom;
		return total;
	}
}
