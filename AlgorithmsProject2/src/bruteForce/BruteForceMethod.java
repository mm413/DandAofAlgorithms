package bruteForce;

import java.util.ArrayList;

public class BruteForceMethod {
	ArrayList<Integer> nums;
	int n;

	/**
	 * @param nums - the nums to be stored as an arrayList
	 * BruteForceethod is the constructor to instantiate an arrayList
	 * to be iterated through
	 */
	public BruteForceMethod(ArrayList<Integer> nums) {
		this.n = nums.remove(0);
		this.nums = nums;
	}
	/**
	 * @return string - a concacted string explaining the days bought/ sold
	 * /profit made.
	 * Solve iterates through the list twice to find the best possibly days
	 * to buy and sell to maximize profit.
	 */
	public String solve() {
		int max = -10000000;
		int buy = 0;
		int sell = 0;
		int buyPrice = 0;
		int sellPrice = 0;
		for (int i = 0; i < nums.size(); i++) {
			for (int j = i+1; j < nums.size(); j++) {
				if ((nums.get(j) - nums.get(i)) > max) {
					max = nums.get(j) - nums.get(i);
					buy = i+1;
					buyPrice = nums.get(i);
					sell = j+1;
					sellPrice = nums.get(j);
				}
			}
		}
		return ("buy on day " + buy + " for price "+ buyPrice + ", sell on day " + sell + " for price "+ sellPrice + ";    profit/loss = $" + max);
	}
}
