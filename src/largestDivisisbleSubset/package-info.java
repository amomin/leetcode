/**
 * 
 */
/** <h1> Largest Divisible Subset </h1>
 * 
 * <h2> Statement </h2> 
 * 
 * <h2> Questions </h2>
 * <ul>
 * <li> Time/Space constraints? </li>
 * <li> </li>
 * </ul>
 * 
 * 
 * <h2> Thoughts </h2>
 * <ul>
 * <li> Listing all subsets seem to be a bad idea (2^n subsets) </li>
 * <li> Search problem - can think of this as looking for the longest
 * path on a graph, where vertices are the elements of the set and the
 * directed edges are the relation "divides" </li>
 * <li> Oh, it's even a DAG (well if 1 is in it, otherwise a tree of DAGs)
 *  - assuming elements appear only once </li>
 * <li> Problem statement says not, so we should be good! </li>
 * <li> So I guess we topsort the dag, and then? </li>
 * <li> So we're about O(n^2) to build the graph..</li>
 * </ul>
 * <p> So the above is more complicated than needs to be, although the 
 * idea is helpful.  </p>
 * 
 * <h2> Problems </h2>
 * 
 * <p> Thought I had it coded well in about 1 hr without an IDE, but in the
 * end took more like 2 hrs and had to use the IDE </p>
 * 
 * <ul>
 * <li> Oh boy. Started coding in the browser, made a first solution which was
 * more complicated but conceptually nice (with the graph), but too slow.
 * So I simplified to remove the reference to the graph. Then I moved to the
 * IDE, but it was still slow going, and had trouble debugging an issue when
 * returning the path. </li>
 * </ul>
 * 
 * <h2> Improvements </h2>
 * <p> Quick glance at other solutions reveals a whole lot that could be
 * improved </p>
 * <ul>
 * <li> Instead of storing the whole path just store the pointer to the next
 * item along the path. In addition to improving space, this would have helped
 * with the bug I had of carrying (and copying) the whole path. </li>
 * <li> Order of iteration matters.  Better to start with larger numbers where
 * the path is small (because a number can't divide numbers smaller than it). 
 * </li>
 * </ul>
 * 
 * @author user
 *
 */
package largestDivisisbleSubset;