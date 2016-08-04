/**
 * 
 */
/** <h1> Coin Change </h1>
 * 
 * <p> The classic coin change problem - given a list of denominations, return the
 * combination of fewest coins that produces a given amount (instead of all
 * possible ways of returning the result).  Return -1 if it is not possible (e.g.
 * if all coins have even denomination and the amount is odd). </p>
 * 
 * <h2> Discussion </h2>
 * 
 * <p> Solution should be close to optimal - at least in concept.  Although
 * you may save a good amount of time by checking validity before making
 * the recursive function calls instead of after. </p>
 * 
 * <p> We should note that the problem can be approached with dynamic
 * programming: compute in sequence the optimal solution for each amount
 * 0,1,...,amount, using the previous answers to build the current answer
 * as:
 * <code> best[x] = min(best[x - coin[0]], best[x - coin[1]], etc...) </code>
 * </p>
 * 
 * <p> I think a greedy-first approach is usually better, at least
 * in the case where it is easy to make any given amount, since you will
 * probably get to an optimal solution quickly and use that to eliminate
 * many of the branches.  But DP might be better when an amount is not
 * attainable. </p>
 * 
 * 
 * @author user
 *
 */
package coinChange;