package topKFrequentElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return count.get(i1) - count.get(i2);
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, c);

        for (Integer i : nums) {
            if (count.containsKey(i)) count.put(i, count.get(i) + 1);
            else count.put(i, 1);
        }
        
        for (Integer i : count.keySet()) {
            if (pq.size() < k) {
                pq.add(i);
            }
            else if (count.get(i) > count.get(pq.peek())) {
                pq.poll();
                pq.add(i);
            }
        }
        return new ArrayList<Integer>(pq);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {1, -1, 2, 3, -1, 0, 1};
        Solution s = new Solution();
        List<Integer> topK = s.topKFrequent(arr, 2);
        for (Integer i : topK) System.out.println(i); //-1, 1
    }

}