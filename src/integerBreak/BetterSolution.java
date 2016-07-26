package integerBreak;

/**  Continuing discussion in solution....
 * 
 * In fact, there should be as many 3's as possible.  First, it should be clear that
 * the product should have no values > 4.  Otherwise we have
 * f(n) = k * .... with k > 5
 * but then we can (must!) replace
 * k with (k - 3) + 3
 * which has product 3k - 9 > k if k > 4 showing that f(n) was not maximal.  Therefore
 * the product is either (depending on n % 3):
 * 
 * 3*3*...*3*2
 * 3*3*...*3*3
 * 3*3*...*3*4
 * 
 * Another, more complicated approach to this guess:
 * In fact, we know that k should be near the real value of x maximizing (n/x)^x
 * 
 * i.e.
 * x (log n) - x log(x)
 * Taking the derivative
 * log n - log(x) - 1 = 0
 * log(x) = log(n) - 1
 * log(x) = log(n) - log(e) = log(n/e)
 * i.e. x = n / e
 * k = n / x => k = e
 * 
 * So we should have k = 3.
 * f(n) ~ 3 * 3 * ... * 3 * (2,3, or 4)
 * 
 * 
 * @author user
 *
 */
public class BetterSolution {
    public int integerBreak(int n) {
    	if (n < 4) {
    		return n - 1;
    	}
    	int k = (n / 3);
    	int m = n % 3;
    	if (m == 1) {
    		// 3 * 3 * ... * 3 * 4
    		return 4 * (int) Math.pow(3, k - 1);
    	}
    	if (m == 0) {
    		return (int) Math.pow(3, k);
    	}
    	// 3 * 3 * ... * 3 * 2
    	return (int) Math.pow(3, k) * m;
    }
}
