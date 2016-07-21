package productOfArrayExceptSelf;

public class Client {

	public static void tst(int[] nums) {
		AnotherSolution s = new AnotherSolution();
		int[] result = s.productExceptSelf(nums);
		for (int i : result) {
			System.out.printf("%d, ", i);
		}
		System.out.printf("%n");
	}
	public static void main(String[] args) {
		tst(new int[] {2,3,5});
		tst(new int[] {2,3,5,7});
		tst(new int[] {2,3,5,7,11});
		tst(new int[] {2,3,5,7,11,-1});
		
	}

}
