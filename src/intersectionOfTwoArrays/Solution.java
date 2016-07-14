package intersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Iterator;

public class Solution implements ISolution {
	    
    // Strategy 1: Double loop through each, insert into answer if result is not yet in
    // answer.  Space is O(n), Time may be as bad as O(n^3) if nums1 = nums2 = [1..n]
    
    // Strategy 2: Sort the arrays first, keep a pointer to a current index and increment
    // these pointers while the values do not match.  Once they match, add the element to
    // the answer, fastforward to the next value, and continue.
    // Time = O(nlog(n)+mlog(m)), Space = O(1)
    
    // Strategy 3: Put the values of nums1 into a hash-table, then run through the values
    // of nums2, check if they are in the table, and if so add to the result
    // Time = O(n+m), Space = O(n)
    // EDIT: this was not quite complete
    // Need a second hashtable for the intersection: loop through elements of nums2
    // and add them to the result hashset iff it's in hashsetnums1 and not in the
    // the intersection
    // Time=O(n+m), Space = O(n+m)
	// EDIT AFTER LOOKING AT OTHER SOLUTION:
	// You could have run through elements of nums2 and REMOVE the elements from
	// the HashSet once found.  This reduces space to O(n).
    
    private int[] hashSetMethod(int[] nums1, int[] nums2) {
        HashSet s = new HashSet<Integer>();
        for (Integer i : nums1) {
            if (!s.contains(i)) s.add(i);
        }
        HashSet<Integer> intersection = new HashSet<Integer>();
        for (Integer i : nums2) {
            if (s.contains(i) && !intersection.contains(i)) {
            	intersection.add(i);
            }
        }
        int[] res = new int[intersection.size()];
        Iterator<Integer> iter = intersection.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            res[i] = iter.next();
        }
        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        return hashSetMethod(nums1, nums2);
    }
}
