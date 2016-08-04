/**
 * 
 */
/** <h1> Flatten Nested List Iterator </h1>
 * 
 * <p> A really straightforward exercise in recursion. </p>
 * 
 * <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">
 * Flatten Nested List Iterator </a>
 * 
 * <h2> Solutions </h2>
 * <a href="https://leetcode.com/submissions/detail/69327820/">
 * First solution </a> - 7ms beats 79% of submissions.
 * 
 * <h2> Comments </h2>
 * 
 * <p> The problem may not have been well stated, as there is another approach
 * that might have been preferred: one can iterate without creating the flatten list
 * (note that the problem statement is not to flatten but to iterate).  The problem
 * is to build the iterator to work with nested data.  The rough idea is to keep
 * a stack of lists to process, enter the top item in the stack and pop integers
 * as they are encountered, and push lists onto the stack as they are encountered.
 * Most of the posted answers seem to use this idea. </p>
 * 
 * <p> We remark that this latter solution ("usually") uses a good deal less space (proportional
 * to the maximal depth instead of the number of elements in the list), but there
 * are problems if the Lists change values: immutable lists would be better. </p>
 * 
 * @author user
 *
 */
package flattenNestedListIterator;