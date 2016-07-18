/**
 * 
 */
/** <h1> Water and Jug Problem </h1> 
 * 
 * <p> <a href="https://leetcode.com/problems/water-and-jug-problem/"> 
 * Leetcode - medium, 22% acceptance rate 
 * </a> <br/>
 * <a href="https://leetcode.com/submissions/detail/67552295/"> Solution here </a>
 * </p>
 * 
 * <h2> Statement </h2>
 * 
 * <p> You are given two jugs with capacities x and y litres. There is 
 * an infinite amount of water supply available. You need to determine 
 * whether it is possible to measure exactly z litres using these 
 * two jugs. </p> 
 * <p> If z liters of water is measurable, you must have z liters 
 * of water contained within one or both buckets by the end. </p>
 * 
 * <h2> Operations allowed </h2>
 * <ul>
 * <li> Fill any of the jugs completely with water. </li>
 * <li> Empty any of the jugs. </li>
 * <li> Pour water from one jug into another till the other jug 
 * is completely full or the first jug itself is empty. </li>
 * </ul>
 * 
 * <h2> Thinking </h2>
 * <ul>
 * <li> Looks like a dynamic programming problem, or recursion. </li>
 * <li> First strategy: keep a list of attainable values of (x,y), say a
 * double array of values [0..x][0..y].  Start with (0,0).  At each step, 
 * apply each (permissible) operation to get a new (x,y).  If we have come
 * across the new (x',y'), then stop, otherwise mark it as available and 
 * continue from there.  Stop when x' == z or y' == z.  </li>
 * <li> Data structures: for the list, either an array or a hash table. 
 * We should also keep a list of entries to be processed.  I think a stack or
 * queue would be fine here.  </li>
 * <li> The above is O(xy) space and O(xy) time.  </li>
 * <li> Could it be as simple as whether gcd(x,y) | z ???? Apparently so. </li>
 * <li> How to prove/disprove?  One idea would be to show you can simulate
 * (x,y) case with (y %x, x) case...</li>
 * </ul>
 * 
 * <h2> Questions </h2>
 * 
 * <ul>
 * <li> Time constraints? </li>
 * <li> Space constraints? </li>
 * <li> Any info on expected input? </li>
 * </ul>
 * 
 * <h2> Errors made </h2>
 * <ul>
 * <li> Syntax return [1,2] instead of return new int[] {1,2} </li>
 * <li> Had to look up implementation of Queue - LinkedList!</li>
 * <li> missing ')' at end of if condition </li>
 * <li> private int[][] foundValues; - int should be boolean</li>
 * <li> empty -> isEmpty: processList.isEmpty() </li>
 * <li>  int[][] candidates = new int[] (need another []) </li>
 * <li>  queue.add -> processList.offer </li>
 * <li>  GCD solution - edge cases (e.g. % 0) </li>
 * <li>  Misread question - <strong> one or both </strong> </li>
 * <li>  </li>
 * </ul>
 * 
 * @author user
 *
 */
package waterAndJugProblem;