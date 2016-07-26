package integerBreak;

/** It's not difficult to guess that the answer will be something like
 * (k * k * k * ... * k * k') (where k' is close to k)
 * 
 * So we loop through k = 2,3,4,... and products which are equal to k except
 * for the very last value.  While the answers increase keep going, otherwise
 * stop and return.  Be careful try values of k' both larger than and
 * less than k.  e.g. for n = 11 we should return
 * 
 * f(11) = 3 * 3 * 3 * 2
 * but for n = 10
 * f(10) = 3 * 3 * 4
 * 
 **/

public class Solution {
    public int integerBreak(int n) {
        if (n < 4) return n - 1;
        int ans = 0;
        int k = 2;
        int newAns = 1;
        while (newAns > ans) {
            ans = newAns;
            //n = (n / k) * k + (n % k)
            //  = (k + k + ... + k) + (k + (n % k))
            //  = (n / k - 1)*k + (k + (n % k))
            //  OR
            //  = (n / k )*k + (n % k)
            int m = n / k;
            newAns = 1;
            for (int i = 1; i < m; i++) {
                newAns *= k;
            }
            int newAns2 = newAns * k * (n % k);
            newAns *= (k + (n % k));
            if (newAns2 > newAns) newAns = newAns2;
            k++;
        }
        return ans;
    }
}