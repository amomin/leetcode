package pascalsTriangle1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
	    for (int i = 0; i < numRows; i++) {
		    result.add(new ArrayList<Integer>(i + 1));
		    result.get(i).add(1);
		    for (int j = 1; j < i; j++) {
			    result.get(i).add(result.get(i-1).get(j-1) + result.get(i-1).get(j) );
    		}
	    	if (i > 0) result.get(i).add(1);
	    }
        return result;
    }
}