package hIndex2;

/** It's the exact same problem but they ask if you can do it faster
 * if the data is already sorted.  Which was the first thing we
 * did in the previous solution... 
 * 
 * Oh, that means we're supposed to do a binary search...
 * 
 **/
public class Solution {
    public int hIndex(int[] citations) {
        int n, lowerBound, upperBound, guess;
        n = citations.length;
        upperBound = n;
        lowerBound = 0;
        while (lowerBound < upperBound) {
            guess = (1 + upperBound + lowerBound) / 2;
            if (citations[n - guess] < guess) {
                upperBound = guess - 1;
            } else if (citations[n - guess] >= guess) {
                lowerBound = guess;
            }
        }
        return upperBound;
    }
}