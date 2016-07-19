package largestDivisisbleSubset;

import java.util.List;

public class Client {
	
	public static void tst(int[] nums) {
		//Solution s = new Solution();
		SimpleSolution s = new SimpleSolution();
		List<Integer> res = s.largestDivisibleSubset(nums);
		for (Integer i : res) {
			System.out.printf("%d ", i);
		}
		System.out.printf("%n");
	}
	public static void main(String[] args) {
		int N = 30;
		int[] powersOf2 = new int[N];
		int n = 1;
		for (int i = 0; i < N; i++) {
			powersOf2[i] = n;
			n *= 2;
		}
		//tst(powersOf2);
		tst(new int[] {3,4,16,8});
	}
}
