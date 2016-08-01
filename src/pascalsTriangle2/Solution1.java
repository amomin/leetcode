package pascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> current = new ArrayList<Integer>();
        int previous, tmp = 0;
        if (rowIndex < 0) return current;
        while (current.size() <= rowIndex) {
            previous = 0;
            for (int i = 0; i < current.size(); i++) {
                tmp = previous;
                previous = current.get(i);
                current.set(i, previous + tmp);
            }
            current.add(1);
        }
        return current;
    }
}
