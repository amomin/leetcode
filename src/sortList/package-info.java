/**
 * 
 */
/** <h1> Sort List </h1>
 * 
 * <p> Sort a linked list in O(nlog(n)) time with constant extra space. </p>
 * 
 * <h2> Soluion idea </h2>
 * 
 * <p> Merge sort and heap sort seem to be out of the picture.  So it would seem
 * to be best to use quicksort (assuming there isn't something that allows us
 * to use count/bucket type of sorting).  Since it's a singly linked list,
 * we need to use a Lomuto partition strategy, which I confess I looked up.
 * </p>
 * 
 * <p> Upon further reflection a Lomuto strategy is no good either, because of the
 * "Dutch-flag" problem (small range of values in the array causes quadratic
 * complexity).  However, you can still do a quick-like "filter" sort which filters
 *  the arrays into (<), (==), and (>) lists and then merges them. <p>
 *  
 *  <p> In any case, I like this problem, which made me think about what one
 *  can do with linked lists. If asked whether one can do a O(nlog(n)) sort
 *  I would have naively thought it wasn't possible.</p>
 *  
 *  <h2> Comments after submission and reading other solutions </h2>
 *  
 *  <p> Upon thinking of the filter-sort idea, it should have occurred to me
 *  that I was wrong about merge sort - merging two arrays uses extra space,
 *  but merging two linked lists *does not* (which we observe in implementing the
 *  filter solution).  The merge sort solution (as explained for example in
 *  <a href="https://discuss.leetcode.com/topic/643/i-have-a-pretty-good-mergesort-method-can-anyone-speed-up-the-run-time-or-reduce-the-memory-usage">
 *  this comment
 *  </a>
 *  is a *much* cleaner approach. </p>
 *
 * @author user
 *
 */
package sortList;