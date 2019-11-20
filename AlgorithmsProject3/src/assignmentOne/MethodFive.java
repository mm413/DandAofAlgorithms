/**Mark Meade
 * 11/8/19
 *MethodFive.java
 */


package assignmentOne;

import java.util.Arrays;

public class MethodFive {
	boolean exists;
	long [][] c;
	
	public MethodFive() {
		exists = true;
	}
	
	public long dynamicBinomial(int n, int k) {
		c = new long[n+1][k+1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <=k; j++) {
				if (j == 0 || i == j) {
					c[i][j] = 1;
				}
				if (j > 0 && i > 0) {
					c[i][j] = c[i-1][j-1] + c[i-1][j];
				}
			}
		}
		//System.out.println(Arrays.deepToString(c));
		return c[n][k];
	}

}