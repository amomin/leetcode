package pascalsTriangle2;

import java.util.Arrays;
import java.util.List;

/** Simplest is best.
 * 
 * Just have to be careful about overflow, so divide before multiplying.  And factor out the
 * gcd to make sure that the division is whole.
 * 
 * @author user
 *
 */
public class Solution3 {
    public int gcd(int a, int b) {
        return _gcd(Math.max(a, b), Math.min(a, b));
    }
    
    public int _gcd(int mx, int mn) {
        if (mn == 0) return mx;
        return _gcd(mn, mx % mn);
    }
    
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int num = rowIndex + 1 - i;
            int denum = i;
            int gcd = gcd(num, denum);
            row[i] = ( row[i-1] / (denum / gcd) ) * (num / gcd);
        }
        return Arrays.asList(row);
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
