package hIndex2;

/** Got this idea from the discussions.
 * 
 * Notice that if the largest element in the array is 10, then the h-index
 * can be no larger than 10, which can cut down the search space dramatically if the
 * number of papers is large.  Furthermore, we can cut this down every time we update
 * the lower bound on the guess: continuing the last example, if we know the h-index is 
 * at least 3 because the 3rd most cited paper has 5 citations, then we know that 
 * the h-index is at most 5 and can update the upper bound from 10 to 5, further
 * reducing the search space.
 * 
 * This brings the solution time down from 11ms to 9ms (78% to 99.8%)
 * 
 * Interestingly, using Math.max seems to actually slow things down - replacing
 * the if statements with Max.min increases the test time from 9ms to 12ms(!) - so
 * we use if statements instead of Math.min/Math.max.
 * 
 * @author user
 *
 */
public class Solution2 {
    public int hIndex(int[] citations) {
        int n, lowerBound, upperBound, guess;
        n = citations.length;
        if (n == 0) return 0;
        upperBound = n;
        upperBound = n;
        if (citations[n - 1] < n) upperBound = citations[n-1];
        lowerBound = 0;
        while (lowerBound < upperBound) {
            guess = (1 + upperBound + lowerBound) >> 1;
            if (citations[n - guess] < guess) {
                upperBound = guess - 1;
            } else if (citations[n - guess] >= guess) {
                lowerBound = guess;
                if (citations[n - guess] < upperBound && citations[n - guess] < n) {
                    upperBound = citations[n - guess];
                }
            } else {
                return guess;
            }
        }
        return upperBound;
    }
}