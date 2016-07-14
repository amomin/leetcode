package sumOfTwoIntegers;

public class Client {
	public static void main(String[] args) {
		
		int N = 1000;
		for (int i = -N; i < N; i++) {
			for (int j = -N; j < N; j++) {
				Solution s = new Solution();
				int expected = i + j;
				int returned = s.getSum(i,  j);
				if (expected != returned) {
					System.out.printf("Summing %3d + %3d = %4d: got %4d %n",
							i, j, expected, returned);
				}
			}
		}
		System.out.println("DOne testing: " + N);
	}
}
