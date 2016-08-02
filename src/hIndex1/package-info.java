/**
 * 
 */
/** <h1> H-index 1 </h1>
 * 
 * <p> Compute the h-index of an author given an array of citations.  The
 * h-index is the maximum number h such that the author has h papers
 * cited at least h times each. </p>
 * 
 * <h2> Discussion </h2>
 * 
 * <p> I saw in the discussion a clever solution which is worth mentioning.  It goes 
 * like this: </p>
 * <ol>
 * <li> Create an array of counts of citations - this only needs to have
 * as many elements as the citations array + 1 to count papers with more citations than
 * the total number of papers authored.</li>
 * <li> i.e. create int[] count: count[i] = number of papers with i citations.  </li>
 * <li> Once the array is created, traverse this array in reverse order and accumulate
 * the number of papers counted.   Once i < accumulator, return i.  </li>
 * </ol>
 * 
 * @author user
 *
 */
package hIndex1;