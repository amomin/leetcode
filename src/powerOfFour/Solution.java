package powerOfFour;

/** <h1> Implementation of solution </h1>
 * 
 * @author user
 *
 */
public class Solution {
    
	private boolean withMath(int num) {
        return (Math.log(num) / Math.log(4)) % 1 < 0.000000001;	
	}
		
	private boolean bitWise(int num) {
        if (num <= 0) return false;
        while (num > 1) {
            if ((num & 3) != 0) return false;
            num = num >> 2;
        }
        return true;
    }
    
    public boolean isPowerOfFour(int num) {
    	return bitWise(num);
        //return withMath(num);
    }
}
