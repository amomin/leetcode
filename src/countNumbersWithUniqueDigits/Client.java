package countNumbersWithUniqueDigits;

public class Client {

	public static void main(String[] args) {
		Solution s = new Solution();
		for (int i = 0; i < 20; i++) {
			System.out.println(s.countNumbersWithUniqueDigits(i));
		}
	}
}
