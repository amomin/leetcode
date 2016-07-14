package findKPairsWithSmallestSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static ArrayList<int[]> srtPairs(ArrayList<int[]> pairs) {
        int N = pairs.size();
        for (int i = 0; i < N; i++) {
            int minSoFar = pairs.get(i)[0] + pairs.get(i)[1];
            int minSoFarIndex = i;
            for (int j = i+1; j < N; j++) {
                int curr = pairs.get(j)[0] + pairs.get(j)[1]; 
                if (curr < minSoFar) {
                    minSoFar = curr;
                    minSoFarIndex = j;
                }
            }
            int[] tmp = pairs.get(i);
            pairs.set(i, pairs.get(minSoFarIndex));
            pairs.set(minSoFarIndex, tmp);
        }
        return pairs;
    }
    
    private static int[] srt(int[] ns) {
        int N = ns.length;
        for (int i = 0; i < N; i++) {
            int minSoFar = ns[i];
            int minSoFarIndex = i;
            for (int j = i+1; j < N; j++) {
                int curr = ns[j]; 
                if (curr < minSoFar) {
                    minSoFar = curr;
                    minSoFarIndex = j;
                }
            }
            int tmp = ns[i];
            ns[i] = ns[minSoFarIndex];
            ns[minSoFarIndex] = tmp;
        }
        return ns;
    }
    
    /** First solution which didn't pass the tests **/
    public List<int[]> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        this.srt(nums1);
        this.srt(nums2);
        ArrayList<int[]> pairs = new ArrayList<int[]>();
        for (int i = 0; i < k && i < nums1.length; i++) {
            for (int j = 0; j < k && j < nums2.length; j++) {
                pairs.add(new int[] {nums1[i],nums2[j]});
            }
        }
        srtPairs(pairs);
        while (pairs.size() > k) {
            pairs.remove(k);
        }
        return pairs;
    }
    
    public int[] seq(int[] nums1, int[] nums2, int k) {
    	if (k < 1) return new int[] {};
    	if (k == 1) return new int[] {1};
    	
    	int[] prevSeq = seq(nums1, nums2, k-1);
    	int i = 0;
    	while (prevSeq[i] >= nums2.length) {
    		i++;
    	}
    	int minSoFar = nums1[i] + nums2[prevSeq[i]];
    	int minSoFarIndex = i;
    	while (i < prevSeq.length) {
    		if (nums1[i] + nums2[prevSeq[i]] < minSoFar) {
    			minSoFar = nums1[i] + nums2[prevSeq[i]];
    			minSoFarIndex = i;
    		}
    		i++;
    	}
    	if (prevSeq.length < nums1.length) {
    		i = prevSeq.length;
    		if (nums1[i] + nums2[0] < minSoFar) {
    			minSoFar = nums1[i] + nums2[0];
    			minSoFarIndex = i;
    		}
    		i++;    		
    	}
    	if (minSoFarIndex == prevSeq.length) {
    		int[] s = new int[prevSeq.length + 1];
    		for (int j = 0; j < prevSeq.length; j++) {
    			s[j] = prevSeq[j];
    		}
    		s[prevSeq.length] = 1;
    		return s;
    	} else {
    		int[] s = new int[prevSeq.length];
    		for (int j = 0; j < prevSeq.length; j++) {
    			s[j] = prevSeq[j] + (j == minSoFarIndex ? 1 : 0);
    		}    		
       		return s;   	
    	}
    }
    
    /** Faster solution which passed the tests **/
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<int[]> pairs = new ArrayList<int[]>();
        if (k > nums1.length * nums2.length) {
        	k = nums1.length * nums2.length;
        }
        int[] seq = this.seq(nums1,  nums2, k);
        for (int i = 0; i < seq.length; i++) {
        	for (int j = 0; j < seq[i]; j++) {
        		pairs.add(new int[] {nums1[i], nums2[j]});
        	}
        }
        return pairs;
    }
    
}
