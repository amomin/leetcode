package validPerfectSquare;

public class Solution implements ISolution{
	
	public boolean isPerfectSquare(int num) {
	    if (num < 1) return false;
	    int partial = 0;
		int partial2 = 0;
		int i = 0;
		int maxi = 15;
		while (maxi >= 0) {
			// next = partial + 1<<i
			int next2 = partial2 + (partial<<(i+1)) + (1<<(2*i));
			if (next2 == num) return true;
			if (next2 > num || i > maxi || next2 < 0) {
				if (i == 0) return false;
				// partial2 = partial2 + (partial<<i) + (1<<(2*(i-1)));
				// partial = partial + (1<<(i-1));
				i = i - 1;
    			partial2 = partial2 + (partial<<(i+1)) + (1<<(2*i));
				partial = partial + (1<<i);
				maxi = i - 1;
				i = 0;
				continue;
			}
			i++;
		}
		return false;
	}
}
