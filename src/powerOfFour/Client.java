package powerOfFour;

public class Client {

	public static void main(String[] args) {
		Solution s = new Solution();
		int N = 2147000000;
		for (int i = 0; i < N; i++) {
			if (s.isPowerOfFour(i)) {
				System.out.printf("%d is a power of 4 %n", i);
			}
		}
		System.out.printf("Those are all powers of 4 less that %d %n", N);
	}

}
