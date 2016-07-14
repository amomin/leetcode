package findKPairsWithSmallestSum;

import java.util.List;

public class Client {

    public static void main(String[] args) {
    	Solution x = new Solution();
    	int[] ns1, ns2;
    	ns1 = new int[] {1,2,3};
    	ns2 = new int[] {7,11,13};
    	/*
    	ns1 = new int[1000];
    	ns2 = new int[1000];
    	for (int i = 0; i < 1000; i++) {
    		ns1[i] = -1;
    		ns2[i] = -1;
    	}
    	*/
    	//List<int[]> ans = x.kSmallestPairs(new int[] {}, new int[] {}, 5);
    	List<int[]> ans = x.kSmallestPairs(ns1, ns2, 3);
    	for (int[] xs : ans) {
    		System.out.println(xs[0] + "," + xs[1]);
    	}
    }

}
