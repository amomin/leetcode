package sortList;

public class Helpers {
	
	public static void printIntArr(int[] arr) {
		if (arr.length > 0) System.out.printf("Arr: %d", arr[0]);
		for (int i = 1; i < arr.length; i++) {
			System.out.printf(", %d", arr[i]);
		}
		System.out.printf("%n");
	}

	public static int[] randInt(int n, int maxN) {
		int[] res = new int[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = 1 + (int) (maxN*Math.random());
		}
		return res;
	}

	public static int[] incrArr(int n, boolean isIncreasing) {
		int[] res = new int[n];
		int baseVal = 5;
		if (!isIncreasing) baseVal = n + 5;
		int sign = isIncreasing ? 1 : -1;
		for (int i = 0; i < res.length; i++) {
			res[i] = sign * i + baseVal;
		}
		return res;		
	}
	
}
