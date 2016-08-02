package intersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/** Should have thought of this one but didn't.  
 * O(n) time + O(n) space using a HashMap
 * 
 * @author user
 *
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nums1ElementCount = new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<Integer>(Math.min(nums1.length, nums2.length));
        for (int i = 0; i < nums1.length; i++) {
            if (nums1ElementCount.containsKey(nums1[i])) {
                nums1ElementCount.put(nums1[i], nums1ElementCount.get(nums1[i]) + 1);
            } else {
                nums1ElementCount.put(nums1[i], 1);                
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            if (nums1ElementCount.containsKey(nums2[j])) {
                result.add(nums2[j]);
                nums1ElementCount.put(nums2[j], nums1ElementCount.get(nums2[j]) - 1);
                if (nums1ElementCount.get(nums2[j]) < 1) nums1ElementCount.remove(nums2[j]);
            }
        }
        int[] arrResult = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            arrResult[k] = result.get(k);
        }
        return arrResult;
    }

}
