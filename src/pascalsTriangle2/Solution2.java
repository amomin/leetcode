package pascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

/** Half as much time/space as solution 1 **/
public class Solution2 {
    //
    // k = 0:   1
    // k = 1:   1
    // k = 2:   1, 2
    // k = 3:   1, 3
    // k = 4:   1, 4, 6
    // k = 5:   1, 5, 10
    // k = 6:   1, 6, 15, 20
    // k = 7:   1, 7, 21, 35
    public List<Integer> getRow(int rowIndex) {
        List<Integer> current = new ArrayList<Integer>();
        int currentRow, previous, tmp = 0;
        if (rowIndex < 0) return current;
        current.add(1);
        if (rowIndex < 1) return current;
        currentRow = 0;
        // Compute left half iteratively
        while (currentRow < rowIndex - 1) {
            previous = 1;
            for (int i = 1; i < current.size(); i++) {
                tmp = previous;
                previous = current.get(i);
                current.set(i, previous + tmp);
            }
            if ((currentRow % 2) == 0) {
                current.add(previous + previous);
            }
            currentRow++;
        }
        for (int i = 0; i < currentRow/ 2; i++) {
            current.add(current.get(currentRow/2 - i));
        }
        current.add(1);
        return current;
    }
        
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        for (int row = 0; row < 10; row ++) {
            System.out.printf("Row %d", row);
            List<Integer> answer = s.getRow(row);
            for (Integer i : answer) {
                System.out.printf("%5d, ", i);
            }
            System.out.printf("%n");            
        }
    }
}
