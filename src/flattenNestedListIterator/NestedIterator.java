package flattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> integers;
    private int index;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        integers = new ArrayList<Integer>();
        index = 0;
        if (nestedList.isEmpty()) return;
        
        for (NestedInteger ni : nestedList) {
            process(ni);
        }
    }

    private void process(NestedInteger ni) {
        if (ni.isInteger()) {
            integers.add(ni.getInteger());
        } else {
            for (NestedInteger nested : ni.getList()) {
                process(nested);
            }
        }
    }
    
    @Override
    public Integer next() {
        if (index == integers.size()) return null;
        Integer result = integers.get(index);
        index++;
        return result;
    }

    @Override
    public boolean hasNext() {
        return index < integers.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */