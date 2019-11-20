/**Mark Meade
 * 11/8/19
 *Factorial.java
 */

package assignmentOne;

public class Factorial {

	public static long factorial(int num) {
		long product = 1;
		for (int i = 1; i <= num; i++) {
			product = product * i;
		}
		return product;
	}
}
