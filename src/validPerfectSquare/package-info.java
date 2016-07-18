/**
 * 
 */
/** <h1> Valid Perfect Square </h1> 
 * 
 * <p> <a href="hhttps://leetcode.com/problems/valid-perfect-square/"> 
 * Leetcode - medium, 36% acceptance rate 
 * </a> <br/>
 * <a href="https://leetcode.com/submissions/detail/67563411/"> Solution here </a>
 * </p>
 * 
 * <h2> Statement </h2>
 * 
 * <p> Given a positive integer num, write a function which returns True 
 * if num is a perfect square else False. </br>
 * <strong> Note: Do not </strong> use any built-in library function such 
 * as sqrt.</p>
 * 
 * <h2> Thinking </h2>
 * <ul>
 * <li> Any tricks with binary representation? </li>
 * <li> Special properties of squares that may prove useful? </li>
 * <li> Is a "brute" solution (factor and check) reasonable? </li>
 * <li> Any binary arithmetic tricks that might help? </li>
 * <li> Naivest way is to square 1,2,3.., until n^2 = x or n^2 > x <li>
 * <li> An improvemet would be to figure out the binary digits: 
 * increment <code>i</code> until <code> (2^(2(i + 1)) > x </code>, and then
 * j until <code> (2^i + 2^j)^2 > x </code>, but we are still squaring many 
 * times (though only roughly (log_2(x))^2 instead of sqrt(x) many times. <li>
 * <li> We can improve this by NOT squaring, but rather using the
 *  binomial theorem and bitshifting to replace with addition: 
 * <pre> 
 * next2 
 * = (prev + 1&le;&le;i)**2 
 * = prev2 + 2*prev2 * 1&le;&le;1 + 1&le;&le;(2*i) 
 * = prev2 + prev2&le;&le;(i+1) + 1&le;&le;(2*i) 
 * </pre>
 * keeping track of the SQUARES
 * </li>
 * <li> We'll start with this latter idea <li>
 * </ul>
 * 
 * <h2> Questions </h2>
 * 
 * <ul>
 * <li> Time constraints? </li>
 * <li> Space constraints? </li>
 * <li> Any info on expected input? </li>
 * <li> Is factoring ok?  Or do we need to do better? </li>
 * </ul>
 * 
 * <h2> Errors made </h2>
 * <ul>
 * <li>  Coded in IDE so syntax errors not present initially.  </li>
 * <li>  Must reject 0 (positive number)  </li>
 * <li>  Ughh.. too many to count.  I started working in the IDE.</li>
 * <li>  </li>
 * </ul>
 * <p> The overall strategy is pretty sound and performs decently,but
 * dealing with integer overflow is a bit tricky.  Concretely, consider
 * 2147024896, which is near to an overflow but is a square.  Incrementing
 * 1,2,4,8,..., leads to an overflow before becoming > n, so you need
 * to stop at 2^15, and then start
 * 2^15 + 1, +2, +4, etc...
 * which again leads to an overflow at bit b+1, so you need to stop at bit b
 * and continue
 * 2^15 + 2^b + 1, +2, etc....
 * So you have to keep track of the largest bit you've set so far, and check
 * if your current square is > num OR if you have overflowed.
 * </p>
 * 
 * @author user
 *
 */
package validPerfectSquare;