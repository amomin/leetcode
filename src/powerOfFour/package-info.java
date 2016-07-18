/**
 * 
 */
/** <h1> Power of Four </h1>
 * 
 * <p> Given an integer (signed 32 bits), write a function to check 
 * whether it is a power of 4. <br/>
 * Example: <br/>
 * Given num = 16, return true. Given num = 5, return false. <br/>
 * </p>
 * 
 * <h2> Discussion </h2>
 * <p> One way to do this would be to check that the last two 
 * binary digits are 00, bitshift right by 2, and repeat.</p>
 *
 * <h2> Questions to ask: </h2>
 * <ol>
 * <li>  Any constraints on the algorithm?  Functions/libraries 
 * to use/avoid/</li>
 * <li>  Time or space constraints?  </li>
 * <li>  </li>
 * </ol>
 * 
 * <h2> Errors made </h2>
 * <ol>
 * <li>  BEDMAS (num &amp; 3 != 0) evaluated != 0 before &amp;, did not catch
 * until checked in IDE </li>
 * <li>  num >> 2 instead of num = num >> 2</li>
 * </ol>
 *
 * <h2> Things learned from other users </h2>
 * <p>  You can do the bitwise stuff in one line conveniently.  For
 * example, here are some other user suggested answers: <br/>
 * <br/>
 * <code> return num > 0 && ((num & (num - 1)) == 0) && (0x55555555 & num) != 0; </code> <br/>
 * <code> return num>0 && (num & (num-1)) == 0 && Integer.numberOfTrailingZeros(num)%2==0; </code> <br/>
 * </p>
 * @author user
 *
 */
package powerOfFour;