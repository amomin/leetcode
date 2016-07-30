package insertionListSort;

/** This one is actually gets a slower score from the Leetcode timer - 6ms.
 * 
 * The overall strategy is the same but tries to make the first half/second half distinction a 
 * little clearer.  The main thing is that you need quick access to the following things:
 * 
 * 1. Head of the list
 * 2. The tail of the first half of the list
 * 3. The current item (i)
 * 4. The head of the second half of the list.
 * 
 * With some planning you can probably merge some some of these pointers (2,3 and 4 are consecutive at the outset, but
 * you have to take care not to lose a pointer when inserting "i" into the middle of the first half).
 * 
 * @author user
 *
 */
public class Solution2 {
    ListNode firstHalf, firstHalfTail, secondHalf, iNode, jNode;
   
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        firstHalf = head;
        firstHalfTail = head;
        secondHalf = head.next;
        firstHalfTail.next = null;

        while (secondHalf != null) {
            iNode = secondHalf;
            secondHalf = secondHalf.next;
            iNode.next = null;
            
            if (iNode.val >= firstHalfTail.val) {
                firstHalfTail.next = iNode;
                firstHalfTail = firstHalfTail.next;
                continue;
            }
            firstHalf = insert();
        }
        return firstHalf;
    }

    public ListNode insert() {
        if (iNode.val <= firstHalf.val) {
            iNode.next = firstHalf;
            return iNode;
        }
        jNode = firstHalf;
        while (jNode.next.val < iNode.val) {
            jNode = jNode.next;
        }
        // jNode.next > iNode
        iNode.next = jNode.next;
        jNode.next = iNode;
        return firstHalf;
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
        Solution2 s = new Solution2();
        ListNode head;
        head = new ListNode(args[0]);
        ListNode ptr = head;
        for (int i = 1; i < args.length; i++) {
            ptr.next = new ListNode(args[i]);
            ptr = ptr.next;
        }
        System.out.printf("Input : ");
        prt(head);
        ListNode sorted = s.insertionSortList(head);
        System.out.printf("Result: ");
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
        tst(new int[] { 3, 2, 1} );
    }
}