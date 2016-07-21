package productOfArrayExceptSelf;

/** This is actually slower, we must be doing more
 * multiplications than necessary.
 * 
 * 3n multiplications
 * 4n assignments
 * @author user
 *
 */
public class AnotherSolution {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int lacc, racc, m;
        lacc = 1; racc = 1;
        m = nums.length / 2;
        for (int i = 0; i < m; i++) {
        	result[i] = lacc;
        	result[nums.length - 1 - i] = racc;
        	lacc *= nums[i];
        	racc *= nums[nums.length - 1 - i];
        }
        if (nums.length % 2 == 1) {
        	result[m] = 1;
        }
        for (int i = m; i < nums.length; i++) {
        	result[i] *= lacc;
        	result[nums.length - 1 - i] *= racc;
        	lacc *= nums[i];
        	racc *= nums[nums.length - 1 - i];
        }
        return result;
    }	
}
