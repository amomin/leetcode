package triangle;

import java.util.ArrayList;
import java.util.List;

/** Same as solution 1 but without keeping the overhead of the previous
 * precomputed rows - runs "in-place" in an accumulator.
 * 
 * @author user
 *
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> currentRow = null;
        List<Integer> accumulator = new ArrayList<Integer>();
        accumulator.add(triangle.get(0).get(0));
        for (int row = 1; row < triangle.size(); row++) {
            currentRow = triangle.get(row);
            int previous = accumulator.get(0);
            accumulator.set(0, currentRow.get(0) + accumulator.get(0));
            for (int col = 1; col < currentRow.size() - 1; col++) {
                int currentVal = currentRow.get(col);
                int tmp = accumulator.get(col);
                accumulator.set(col, Math.min(
                    currentVal + previous,
                    currentVal + accumulator.get(col)
                ));
                previous = tmp;
            }
            accumulator.add(currentRow.get(row) + previous);
        }
        int minSum = Integer.MAX_VALUE;
        for (Integer i : accumulator) {
            if (i < minSum) minSum = i;
        }
        return minSum;
    }
}
