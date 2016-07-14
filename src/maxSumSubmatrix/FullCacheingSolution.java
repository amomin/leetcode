package maxSumSubmatrix;

public class FullCacheingSolution {

	private int[][][][] cache;
	private int[][] matrix;
	private int maxSoFar;
	private int k;
		
	private void updateMax(int curr) {
		if (curr <= k && curr > maxSoFar) {
			maxSoFar = curr;
		}		
	}
	
	private int updateCache(int lo1, int hi1, int lo2, int hi2) {
		int val = Integer.MIN_VALUE;
		if (lo1 > 0) {			
			val =
				cache[lo1 - 1][hi1][lo2][hi2] -
				cache[lo1 - 1][lo1 - 1][lo2][hi2];
		} else if (lo2 > 0) {
			val =
				cache[lo1][hi1][lo2 - 1][hi2] -
				cache[lo1][hi1][lo2 - 1][lo2 - 1];
			
		} // lo1 = l02 = 0
		else if (hi1 > 0 && hi2 > 0) {
			val =
				cache[lo1][hi1 - 1][lo2][hi2] +
				cache[lo1][hi1][lo2][hi2 - 1] -
				cache[lo1][hi1-1][lo2][hi2 - 1] +
				matrix[hi1][hi2];
		} else if (hi1 > 0) { // lo1 = lo2 = hi2 = 0
			val = cache[0][hi1 - 1][0][0] + matrix[hi1][0];
		} else if (hi2 > 0) { // lo1 = lo2 = hi1 = 0
			val = cache[0][0][0][hi2 - 1] + matrix[0][hi2];
		} else {
			val = matrix[0][0];
		}
		cache[lo1][hi1][lo2][hi2] = val;
		updateMax(val);
		return val;		
	}
	
	/** O(n^2*m^2) 
	 * @throws Exception **/
	private void memoize(int[][] _matrix, int k) {
		this.matrix = _matrix;
		for (int lo1 = 0; lo1 < matrix.length; lo1++) {
			for (int hi1 = lo1; hi1 < matrix.length; hi1++) {
				for (int lo2 = 0; lo2 < matrix[0].length; lo2++) {
					for (int hi2 = lo2; hi2 < matrix[0].length; hi2++) {
						updateCache(lo1,hi1,lo2,hi2);
					}
				}				
			}
		}
	}	
	
	public int maxSumSubmatrix(int[][] matrix, int k) {
		cache = new int[matrix.length][matrix.length][matrix[0].length][matrix[0].length];
		maxSoFar = Integer.MIN_VALUE;
		this.k = k;
        memoize(matrix, k);
        return this.maxSoFar;
    }
}
