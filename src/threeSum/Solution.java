package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    List<List<Integer>> results;
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        results = new ArrayList<List<Integer>>();
        
        int i = 0;
        while (i < nums.length - 2) {
            int current = nums[i];
            if (current > 0) break; 
            twoSum(nums, -current, i + 1, nums.length - 1);
            while (i < nums.length - 2 && nums[i] == current) i++;
        }
        return results;
    }
    
    // Assume sorted
    public void twoSum(int[] nums, int target, int left, int right) {
        int rightIndex = right;
        int leftIndex = left;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] + nums[rightIndex] > target) {
                rightIndex--;
            } else if (nums[leftIndex] + nums[rightIndex] < target) {
                leftIndex++;
            } else {
                int summand1 = nums[leftIndex];
                int summand2 = nums[rightIndex];
                results.add(Arrays.asList(new Integer[] {-target, summand1, summand2}));
                // Ensure unique answers
                while (leftIndex < nums.length && nums[leftIndex] == summand1) leftIndex++;
                while (rightIndex >= 0 && nums[rightIndex] == summand2) rightIndex--;
            }
        }
    }
}