package insertionListSort;

/**
 * A cleaned up and optimized version of the submitted solution, gets submission time
 * down to 5ms (although some people seem to have managed 2ms!)
 * 
 * @author user
 *
 */
public class Solution {
    ListNode iPointer, secondHalfPointer, jPointer;
   
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        iPointer = head;
        while (iPointer.next != null) {
            if (iPointer.val <= iPointer.next.val) {
                iPointer = iPointer.next;
                continue;
            }
            
            secondHalfPointer = iPointer.next.next;
            head = insert(head, iPointer.next);
            iPointer.next = secondHalfPointer;
        }

        return head;
    }

    public ListNode insert(ListNode head, ListNode newItem) {
        if (newItem.val < head.val) {
            newItem.next = head;
            return newItem;
        }
        
        jPointer = head;
        // Somehow changing this to < makes the submission slower(?)
        // Even though it can only do more iterations this way (I think)
        while (jPointer.next.val <= newItem.val) {
            jPointer = jPointer.next;
        }
        newItem.next = jPointer.next;
        jPointer.next = newItem;
        return head;
    }
    
    
    public static void prt(ListNode n) {
        ListNode ptr = n; 
        while (ptr != null) {
            System.out.print(ptr.val +",");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void tst(int[] args) {
        Solution s = new Solution();
        ListNode head;
        head = new ListNode(args[0]);
        ListNode ptr = head;
        for (int i = 1; i < args.length; i++) {
            ptr.next = new ListNode(args[i]);
            ptr = ptr.next;
        }
        prt(head);
        ListNode sorted = s.insertionSortList(head);
        prt(sorted);
    }
    
    public static void main(String[] args) {
        tst(new int[] { 1, 1} );
        tst(new int[] { 1, 1, 1} );
        tst(new int[] { 1, 2} );
        tst(new int[] { 2, 1} );
        tst(new int[] { 1, 2, 3} );
        tst(new int[] { 1, 3, 2} );
        tst(new int[] { 2, 1, 3} );
        tst(new int[] { 2, 3, 1} );
        tst(new int[] { 3, 1, 2} );
        tst(new int[] { 3, 2, 1} );
    }
}