package hIndex1;

import java.util.Arrays;

public class Solution2 {
    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            citations[i] = -citations[i];
        }
        Arrays.sort(citations);
        for (int i = 1; i <= citations.length; i++) {
            if (-citations[i - 1] < i) {
                return i - 1;
            }
        }
        return citations.length;
    }

}
