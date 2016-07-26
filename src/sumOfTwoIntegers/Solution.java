package sumOfTwoIntegers;

/**
 * Sum two integeres without using + or -
 * @author user
 */
public class Solution {
    
    /**
     * Grade school addition
     **/
    protected int addViaBitShift(int a, int b) {
        int sum = 0;
        int carry = 0;
        int dPlace = 1;
        while (true) {
            int aDigit = a & 1;
            int bDigit = b & 1;
            int digitSum = aDigit ^ bDigit ^ carry; // ^ is associative?
            sum = (digitSum * dPlace) | sum; // * is allowed
            carry = (aDigit & bDigit) | (aDigit & carry) | (bDigit & carry);
            a = a >> 1;
            b = b >> 1;
            if (dPlace < 0) {
                break;
            }
            dPlace = dPlace << 1;
        }
        return sum;
    }
    
    /** Same as above **/
    private int s2(int a, int b) {
    	if (a == 0) return b;
    	if (b == 0) return a;
    	int xr = a ^ b;
    	// easy to show inductively that
    	// on - the nth call - cry ends in n zeros
    	int cry = (a & b) << 1;
    	// we could write this as a loop on the condition while (b != 0)
    	return s2(xr, cry);
    }
    
    public int getSum(int a, int b) {
        return s2(a, b);
    }
}