package maxSumSubmatrix;

public class BruteSolution {

	public int submatrixSum(int lo1, int hi1, int lo2, int hi2, int[][] matrix) {
		int s = 0;
		for (int i = lo1; i <= hi1; i++) {
			for (int j = lo2; j <= hi2; j++) {
				s += matrix[i][j];
			}
		}
		return s;
	}
	
	/** Insane O(n^4*m^4) or something **/
	private int brute(int[][] matrix, int k) {
		int newMax = Integer.MIN_VALUE;
		for (int lo1 = 0; lo1 < matrix.length; lo1++) {
			for (int hi1 = lo1; hi1 < matrix.length; hi1++) {
				for (int lo2 = 0; lo2 < matrix[0].length; lo2++) {
					for (int hi2 = lo2; hi2 < matrix[0].length; hi2++) {
						int s = submatrixSum(lo1, hi1, lo2, hi2, matrix);
						if (s <= k && s > newMax) {
							newMax = s;
						}
					}
				}				
			}
		}
		return newMax;
	}
    public int maxSumSubmatrix(int[][] matrix, int k) {
        return brute(matrix, k);
    }
}