package maxSumSubmatrix;

public class Client {

	public static void main(String[] args) throws Exception {
		
		//BruteSolution s = new BruteSolution();
		//FullCacheingSolution s = new FullCacheingSolution();
		Solution s = new Solution();
		int[][] matrix = new int[][] {
			new int[] {1,  0, 1},
			new int[] {0, -2, 3}
		};
		
		int ans = s.maxSumSubmatrix(matrix, 2);
		System.out.printf("Answer was: %d %n", ans);
		
		ans = s.maxSumSubmatrix(matrix, 3);
		System.out.printf("Answer was: %d %n", ans);

		matrix = new int[][] {
			new int[] {2, 2, -1},
		};
		ans = s.maxSumSubmatrix(matrix, 3);
		System.out.printf("Answer should be 3, was: %d %n", ans);
		
	}

}
