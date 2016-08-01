package triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> partials = new ArrayList<List<Integer>>();
        List<Integer> currentRow = null;
        List<Integer> currentPartialRow = new ArrayList<Integer>();
        currentPartialRow.add(triangle.get(0).get(0));
        partials.add(currentPartialRow);
        for (int row = 1; row < triangle.size(); row++) {
            currentRow = triangle.get(row);
            currentPartialRow = new ArrayList<Integer>();
            partials.add(currentPartialRow);
            if (row > 0) {
                currentPartialRow.add(0, 
                    currentRow.get(0) + partials.get(row - 1).get(0));
                for (int col = 1; col < currentRow.size() - 1; col++) {
                    int currentVal = currentRow.get(col);
                    currentPartialRow.add(col, Math.min(
                        currentVal + partials.get(row - 1).get(col - 1),
                        currentVal + partials.get(row - 1).get(col)
                    ));
                }
                currentPartialRow.add(currentRow.get(row) + 
                    partials.get(row - 1).get(row - 1));
            } else {
                for (int col = 0; col < currentRow.size(); col++) {
                    currentPartialRow.set(col, currentRow.get(col));
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (Integer i : currentPartialRow) {
            if (i < minSum) minSum = i;
        }
        return minSum;
    }
}