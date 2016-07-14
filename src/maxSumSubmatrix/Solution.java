package maxSumSubmatrix;

public class Solution {

	private int[][] cache; // store sum [0:x][0:y]
	private int[][] matrix;
	private int maxSoFar;
	private int k;
		
	private void updateMax(int curr) {
		if (curr <= k && curr > maxSoFar) {
			maxSoFar = curr;
		}		
	}
	
	private void memoize() {
		cache[0][0] = matrix[0][0];
		for (int i = 1; i < matrix.length; i++) {
			cache[i][0] = cache[i-1][0] + matrix[i][0];
		}
		for (int j = 1; j < matrix[0].length; j++) {
			cache[0][j] = cache[0][j-1] + matrix[0][j];			
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				cache[i][j] = cache[i-1][j] -
						cache[i-1][j-1] +
						cache[i][j-1] +
						matrix[i][j];
			}
		}
	}
	
	private int getSum(int lo1, int hi1, int lo2, int hi2) {
		if (lo1 > 0 && lo2 > 0) {
			return cache[hi1][hi2] -
					cache[lo1 - 1][hi2] -
					cache[hi1][lo2 - 1] +
					cache[lo1 - 1][lo2 - 1];
		}
		if (lo1 > 0) {
			return cache[hi1][hi2] -
					cache[lo1 - 1][hi2];
		}
		if (lo2 > 0) {
			return cache[hi1][hi2] -
					cache[hi1][lo2 - 1];
		}
		// lo1 == 0 and lo2 == 0
		return cache[hi1][hi2];
	}
	
	/** O(n^2m^2) **/
	private void findMax() {
		for (int lo1 = 0; lo1 < matrix.length; lo1++) {
			for (int hi1 = lo1; hi1 < matrix.length; hi1++) {
				for (int lo2 = 0; lo2 < matrix[0].length; lo2++) {
					for (int hi2 = lo2; hi2 < matrix[0].length; hi2++) {
						//updateCache(lo1,hi1,lo2,hi2);
						int val = getSum(lo1, hi1, lo2, hi2);
						updateMax(val);
					}
				}				
			}
		}
	}	
	
	public int maxSumSubmatrix(int[][] matrix, int k) {
		cache = new int[matrix.length][matrix[0].length];
		maxSoFar = Integer.MIN_VALUE;
		this.matrix = matrix;
		this.k = k;
        memoize(); // O(nm), space O(nm)
        findMax(); // O(n^2m^2)
        return this.maxSoFar;
    }
	
}
