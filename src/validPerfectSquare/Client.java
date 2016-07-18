package validPerfectSquare;

public class Client {
	public static void tst(int i, boolean expected) {
		ISolution s = new Solution();
		boolean result = s.isPerfectSquare(i); 
		if (result != expected) {
			System.out.printf("Is %d a square? expected %b, got %b %n",
					i, expected, result);
		}
	}
	public static void main(String[] args) {
		tst(1, true);
		tst((1<<30), true);
		tst((1<<31), false);
		tst((1<<30) + (1<<23) + (1<<14), true);
		tst((1<<30) + (1<<24) + (1<<16), true);
		//tst((1<<30) + (1<<30) + (1<<28), true);
		//tst((1<<31) + (1<<28), true);
		for (int i = 1; i < 2000; i++) {
			tst(i*i, true);
			tst(i*(i-1), false);
			tst(i*i + 1, false);
			tst(i*i - 1, false);
		}
		// Test all squares, and 
		// non-squares near the square, and a couple others
		// for good measure
		int nsq = 1;
		int j = 3;
		while (nsq > 0) {
			tst(nsq, true);
			for (int i = 1; i < 3; i++) {
				tst(nsq + i, false);
			}
			tst(nsq + j/2, false);
			tst(nsq + (3*j)/4, false);
			tst(nsq + (j)/4, false); // This test is incorrect once
			nsq += j;
			j += 2;
		}
		tst(2147024896, true);
		tst(2147395600, true);
		tst(2147483647,false);
		tst(1594884096, true);
		tst(1656815616, true);
		tst(2001846564, true);
		System.out.println("Passed all tests");
	}
}
