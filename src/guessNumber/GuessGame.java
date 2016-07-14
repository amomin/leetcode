package guessNumber;

public class GuessGame {
	
	private int n;
	
	public GuessGame(int n) {
		this.n = n;
	}
	
	public int guess(int m) {
		if (n > m) return 1;
		if (n < m) return -1;
		return 0;
	}
}
