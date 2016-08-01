package triangle;

import java.util.List;

/** Same as Soluiton 2 but using an array... quite a bit faster **/
public class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> currentRow = null;
        int[] accumulator = new int[triangle.size()];
        accumulator[0] = triangle.get(0).get(0);
        for (int row = 1; row < triangle.size(); row++) {
            currentRow = triangle.get(row);
            int previous = accumulator[0];
            accumulator[0] = currentRow.get(0) + accumulator[0];
            for (int col = 1; col < currentRow.size() - 1; col++) {
                int currentVal = currentRow.get(col);
                int tmp = accumulator[col];
                accumulator[col] = Math.min(
                    currentVal + previous,
                    currentVal + accumulator[col]
                );
                previous = tmp;
            }
            accumulator[row] = currentRow.get(row) + previous;
        }
        int minSum = Integer.MAX_VALUE;
        for (Integer i : accumulator) {
            if (i < minSum) minSum = i;
        }
        return minSum;
    }

}