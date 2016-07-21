package productOfArrayExceptSelf;

public class Solution {
    // Questions
    // * Worry about overflow?
    // * Time/space
    // * i.e. is it ok to pass through twice and keep two arrays of comparable
    // size?
	// 4n multiplications
	// 2n extra space
	public int[] productExceptSelf(int[] nums) {
        int[] prodsBefore = new int[nums.length];
        int[] prodsAfter = new int[nums.length];
        // We could do away with this after the fact by putting the results in
        // prodsBefore (say) but for simplicity let's not
        int[] result = new int[nums.length];
        prodsBefore[0] = 1;
        prodsAfter[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            int j = nums.length - 1 - i;
            prodsBefore[i] = prodsBefore[i - 1] * nums[i - 1];
            prodsAfter[j] = prodsAfter[j  + 1] * nums[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prodsBefore[i] * prodsAfter[i];
        }
        return result;
    }
}