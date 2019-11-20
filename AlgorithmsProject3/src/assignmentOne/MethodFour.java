/**Mark Meade
 * 11/8/19
 *MethodFour.java
 */


package assignmentOne;

import java.util.Arrays;

//import java.util.Arrays;

public class MethodFour {
	boolean exist;
	long [][] c;

	public MethodFour() {
		exist = true; //just to have something in the constructor
	}
	
	public long memoizedBinomial(int n, int k){
		c = new long[n+1][k+1];
		//fill the array with -1's
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <=k; j++) {
				c[i][j] = -1;
				if (j == 0 || i == j) {
					c[i][j] = 1;
				}
			}
		}
		//System.out.println(Arrays.deepToString(c));
		c[n][k] = memoizedBinomialRecurse(n,k);
		//System.out.println(Arrays.deepToString(c));
		return (long) c[n][k];
	}
	
	public long memoizedBinomialRecurse(int n, int k) {
		if (c[n][k] == -1) {
			long num = memoizedBinomialRecurse((n-1), (k-1)) + memoizedBinomialRecurse(n-1, k);
			c[n][k] = num;
		}
		return c[n][k];
		
	}
}
