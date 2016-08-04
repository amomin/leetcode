package flattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Same idea but slightly simpler.
public class NestedIterator2 implements Iterator<Integer> {

    private List<Integer> integers;
    private int index;
    
    public NestedIterator2(List<NestedInteger> nestedList) {
        integers = new ArrayList<Integer>();
        index = 0;
        if (nestedList.isEmpty()) return;
        flatten(nestedList);
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                integers.add(nested.getInteger());
            } else {
                flatten(nested.getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        if (index >= integers.size()) return null;
        return integers.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < integers.size();
    }
}