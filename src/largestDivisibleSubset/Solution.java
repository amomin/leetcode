package largestDivisibleSubset;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private HashMap<Integer,Integer> maxLengths;
    
    private class Graph {
        private int[] vertices;
        private HashMap<Integer,List<Integer>> adjList;

        public Graph(int[] nums) {
            vertices = new int[nums.length];
            adjList = new HashMap<Integer,List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                vertices[i] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                adjList.put(vertices[i],new LinkedList<Integer>());
                for (int j = 0; j < nums.length; j++) {
                    if (j != i &&
                        (vertices[j] % vertices[i] == 0) ) {
                        adjList.get(vertices[i]).add(vertices[j]);
                    }
                }
            }
        }
        
        public int[] getVertices() { return vertices; }
        public List<Integer> getEdges(int n) {
            if (adjList.containsKey(n)) {
                return adjList.get(n);
            }
            // Empty
            return new LinkedList<Integer>();
        }
    }
    
    private int computeMaxLengths(Graph g)
    {
        int[] vertices = g.getVertices();
        maxLengths = new HashMap<Integer,Integer>();
        int maxSoFar = 0;
        int maxVertex = vertices[0];
        for (int i = 0; i < vertices.length; i++) {
            int v = vertices[i];
            int curr = computeMaxLengths(g, v);
            //System.out.printf("(%d,%d)", v, curr);
            if (curr > maxSoFar) {
                maxSoFar = curr;
                maxVertex = v;
            }
        }
        return maxVertex;
    }
    
    private int computeMaxLengths(Graph g, int v) {
        if (maxLengths.containsKey(v)) {
            return maxLengths.get(v);
        }
        List<Integer> edges = g.getEdges(v);
        int max = 1;
        for (Integer e : edges) {
            int curr = 1 + computeMaxLengths(g, e);
            if (curr > max) {
                max = curr;
            }
        }
        maxLengths.put(v, max);
        return max;
    }
    
    private List<Integer> reconstructMaxPath(Graph g, int v) {
        List<Integer> result = new LinkedList<Integer>();
        int maxSoFar = 0;
        for (Integer e : g.getEdges(v)) {
            List<Integer> curr = reconstructMaxPath(g, e);
            if (curr.size() > maxSoFar) {
                result = curr;
                maxSoFar = curr.size();
            }
        }
        result.add(v);
        return result;
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new LinkedList<Integer>();
        Graph g = new Graph(nums);
        int v = computeMaxLengths(g);
        return reconstructMaxPath(g, v);
    }
}
