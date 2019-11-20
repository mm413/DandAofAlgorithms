/**Mark Meade
 * 11/8/19
 *AssignmentOneMain.java
 */
 



package assignmentOne;

import java.util.*;

public class AssignmentOneMain {

	public static void main(String[] args) {
	
	//to prevent a stack overflow, keep all values of n below 25
	
//		get values for k and n from user:
		System.out.println("enter a value for n:");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("enter a value for k:");
		int k = scanner.nextInt();
		scanner.close();
		if (n < k || k < 0 || n < 0) {
			System.out.println("-1");
			System.exit(0);
		}
		
		//method One Test:
		long MethodOneStart = System.nanoTime();
		long one =  MethodOne.calculate(n,k);
		long MethodOneEnd = System.nanoTime();
		System.out.println("method One Time:" + (MethodOneEnd - MethodOneStart));///1000000 + "ms");
		
		
		//method Two Test:
		long MethodTwoStart = System.nanoTime();
		long two = MethodTwo.calculate(n,k);
		long MethodTwoEnd = System.nanoTime();
		System.out.println("method Two Time:" + (MethodTwoEnd - MethodTwoStart));///1000000 + "ms");
		
		
		//method Three Test:
		long MethodThreeStart = System.nanoTime();
		long three = MethodThree.calculate(n,k);
		long MethodThreeEnd = System.nanoTime();
		System.out.println("method Three Time:" + (MethodThreeEnd - MethodThreeStart));///1000000 + "ms");



		//method Four Test:
		MethodFour meth = new MethodFour();
		long MethodFourStart = System.nanoTime();
		long four = meth.memoizedBinomial(n, k);
		long MethodFourEnd = System.nanoTime();
		System.out.println("method Four Time:" + (MethodFourEnd - MethodFourStart));///1000000 + "ms");
	
		
		//method Five Test:
		MethodFive dub = new MethodFive();
		long MethodFiveStart = System.nanoTime();
		long five = dub.dynamicBinomial(n, k);
		long MethodFiveEnd = System.nanoTime();
		System.out.println("method Five Time:" + (MethodFiveEnd - MethodFiveStart));///1000000 + "ms");
		
	}

}
