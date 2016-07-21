/**
 * 
 */
/** <h1> Product of Array Except Self </h1>
 * 
 * <h2> Problem Statement </h2>
 * <p> Given an array of n integers where n > 1, nums, return an array 
 * output such that output[i] is equal to the product of all the elements 
 * of nums except nums[i]. </p> 
 * <p>  Solve it without division and in O(n). </p> 
 * 
 * <p> For example, given [1,2,3,4], return [24,12,8,6]. </p> 
 * 
 * <h2> Discussion </h2>
 * 
 * <p> Pretty straightforward - coded a solution in about 20 mins in
 * the browser.  Idea was to run through and keep arrays of two
 * running totals: products up to i, and products after i, and then build
 * the result by multiplying those two results together.  But it was pretty 
 * slow (worst 4% of submitted solutions). </p>
 * 
 * @author user
 *
 */
package productOfArrayExceptSelf;