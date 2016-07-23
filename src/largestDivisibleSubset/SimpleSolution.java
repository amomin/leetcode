package largestDivisibleSubset;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SimpleSolution {
	
	private int[] vertices;
	private HashMap<Integer, List<Integer>> cache;
	
	public List<Integer> longestPathAt(int v) {
		if (cache.containsKey(v)) return cache.get(v);
		List<Integer> res = new LinkedList<Integer>();
		int maxSoFar = 0;
		for (int i = 0; i < vertices.length; i++) {
			int w = vertices[i];
			if (w == v) {
				continue;
			}
			if (w % v == 0) {
				List<Integer> curr = longestPathAt(w);
				if (curr.size() > maxSoFar) {
					maxSoFar = curr.size();
					res = curr;
				}
			}
		}
		List<Integer> res1 = new LinkedList<Integer>();
		res1.add(v);
		for (Integer i : res) {
			res1.add(i);
		}
		cache.put(v, res1);
		return res1;
	}
	
	
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new LinkedList<Integer>();
        vertices = nums;
        cache = new HashMap<Integer, List<Integer>>();
        int max = 0;
        List<Integer>res = new LinkedList<Integer>();
        for (int i = 0; i < vertices.length; i++) {
        	int v = vertices[i];
        	List<Integer>curr = longestPathAt(v);
        	if (curr.size() > max) {
        		res = curr;
        		max = curr.size();
        	}
        }
        return res;
    }
}
