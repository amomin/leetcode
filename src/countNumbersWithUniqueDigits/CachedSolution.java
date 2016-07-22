package countNumbersWithUniqueDigits;

public class CachedSolution {
    public int countNumbersWithUniqueDigits(int n) {

        int[] ans = new int[] {1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771, 8877691};
        if (n > 10) return ans[10];
        return ans[n];
    }
}