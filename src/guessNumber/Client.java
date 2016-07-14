package guessNumber;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 1000;
		int maxCount = 0;
		for (int i = 1; i < n; i++) {
			Solution s = new Solution(i);
			int g = s.guessNumber(n);
			if (s.getCount() > maxCount) maxCount = s.getCount();
			//System.out.printf("Should guess %d: %d in %d guesses %n", i, g, s.getCount());			
		}
		System.out.println("Max COunt: " + maxCount);

		n 		= 2126753390;
		int g 	= 1702766719;
		//int g = 2;
		Solution s = new Solution(g);
		System.out.printf("FOr %d: %d", g, s.guessNumber(n));
		
		n 	= 2147483647;
		g 	= 2147483647;
		//int g = 2;
		s = new Solution(g);
		System.out.printf("FOr %d: %d", g, s.guessNumber(n));
	}

}
