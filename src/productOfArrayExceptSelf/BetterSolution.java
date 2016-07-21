package productOfArrayExceptSelf;

public class BetterSolution {

	/** constant extra space (one int)
	 * 
	 * 3n multiplications
	 * 4n assignments
	 * 
	 * @param nums
	 * @return
	 */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int acc;
        acc = 1;
        for (int i = 0; i < nums.length; i++) {
        	result[i] = acc;
        	acc *= nums[i];
        }
        acc = 1;
        for (int j = nums.length - 1; j >= 0 ; j--) {
        	result[j] *= acc;
        	acc *= nums[j];
        }
        return result;
    }	
}