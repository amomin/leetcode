package coinChange;

import java.util.Arrays;

/**
 * This solution was at first too slow, but a one-line optimization drastically
 * improved things: ~330ms to ~1ms on the following input
 * 
 * [77,82,84,80,398,286,40,136,162]
 * 9794
 * 
 * See the comment OPTIMIZATION1
 * 
 * @author user
 *
 */
public class Solution {
    
    private int bestResult;
    private int[] coins;
    
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        reverse(coins);
        this.coins = coins;
        bestResult = Integer.MAX_VALUE;
        
        search(0, amount, 0);
        
        if (bestResult == Integer.MAX_VALUE) bestResult = -1;
        return bestResult;
    }
    
    // Pure recursion
    // A greedy solution is no good.
    private void search(int leastIndex, int amount, int numCoinsSoFar) {
        if (amount < 0) return;
        // Kill search if we can't do better
        if (numCoinsSoFar >= bestResult) return;
        // OPTIMIZATION1: This is the optimzation that killed it.
        if (numCoinsSoFar + (amount/coins[leastIndex]) >= bestResult) return;
        
        
        if (amount == 0) {
            bestResult = numCoinsSoFar;
            return;
        }
        for (int i = leastIndex; i < coins.length; i++) {
            search(i, amount - coins[i], numCoinsSoFar + 1);
        }
    }
    
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;right--;
        }
    }
}