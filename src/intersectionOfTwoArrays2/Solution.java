package intersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * Classic sort and compare method.  O(nlog(n)) time and O(1) space
 * (really O(n) to build the solution list).
 * @author user
 *
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i, j;
        i = 0;
        j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i < nums1.length && j < nums2.length) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }       
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) i++;
            while (i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) j++;
    
        }
        int[] arrResult = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            arrResult[k] = result.get(k);
        }
        return arrResult;
    }
}