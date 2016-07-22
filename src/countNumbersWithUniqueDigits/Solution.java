package countNumbersWithUniqueDigits;

public class Solution {
	
	/** Slightly updated version of submitted solution
	 * 
	 * <code>
	 * n = 0 => ans = 1 <br/>
	 * n = 1 => ans = 10 <br/>
	 * n = 2 => ans = 91 = 100 - 9 <br/>
	 *              = 10 + 9*9 <br/>
	 *          - 1st digit in 1..9, 2nd in 0..9 minus @1 <br/>
	 * n = 3 => ans = 91 + 9*9*8 <br/>
	 *          - 1st digit in 1..9, 2nd in 0..9 minus @1, 3rd in 0..9 mns @1,@2 <br/>
 	 * ... <br/>
 	 * n = 3 => ans = 1 + 9 + 9*9 + 9*9*8 + ... + 9*9*8*7*6*5*4*3*2*1 <br/>
 	 * n > 10 => ans = countNumbersWIthUniqueDigits(10) <br/>
	 * </code>
	 * 
	 * @param n
	 * @return
	 */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int sAcc = 10;
        int mAcc = 9;
        int i = 1;
        n = Math.min(n, 10);
        while (i < n) {
            mAcc *= (10 - i);
            sAcc += mAcc;
            i++;
        }
        return sAcc;
    }
}