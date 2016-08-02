package hIndex1;

import java.util.Arrays;

public class Solution {
    // runtime reported as 2ms
    public int hIndex(int[] citations) {
        // Sort reversed - no such function?  Then sort and then reverse.
        // Alternatively negate and then sort - we'll do this in a second solution.
        Arrays.sort(citations);
        // reverse - no standard library function to reverse?
        int left = 0;
        int right = citations.length - 1;
        int tmp;
        while (left < right) {
            tmp = citations[left];
            citations[left] = citations[right];
            citations[right] = tmp;
            left++; right--;
        }
        for (int i = 1; i <= citations.length; i++) {
            if (citations[i - 1] < i) {
                return i - 1;
            }
        }
        return citations.length;
    }
}