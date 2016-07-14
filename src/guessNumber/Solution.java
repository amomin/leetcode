package guessNumber;

public class Solution extends GuessGame {

	private int count;
	public Solution(int n) {
		super(n);
		count = 0;
	}

	public int getCount() {
		return count;
	}
    /** 
     * Classic binary search
     * Watch out for overflow!!!!
     */
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        int g = (lo + hi) / 2;
        int res = guess(g); 
        count = 1;
        while (res != 0) {
        	System.out.println(lo + "," + g + "," + hi);
            if (res < 0) { // My number is lower (than g), meaning g is too hi
                hi = g - 1;
            } else { // My number is higher (than g), meaning g is too lo
                lo = g + 1;
            }
            count += 1;
            g = (lo >> 1) + (hi >> 1) + ((lo % 2) + (hi % 2)) / 2;
            //g = (lo + hi) / 2;
            // If overflow:
            //if (g < 0 || g > hi) {
            	//g = lo / 2 + hi / 2;
            //}
            res = guess(g);
       }
        return g;
     }
}
