package linkedListCycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode rabbit = head;
        ListNode hare = head;
        while (rabbit != null) {
            rabbit = rabbit.next;
            // If there's a cycle you never hit null
            if (rabbit == null) return false;
            rabbit = rabbit.next;
            hare = hare.next;
            if (rabbit == hare) return true;
        }
        return false;        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head, ptr, loopBack;
        ptr = head = new ListNode(5);
        ptr.next = new ListNode(4); ptr = ptr.next;
        ptr.next = new ListNode(3); ptr = ptr.next;
        loopBack = ptr;
        ptr.next = new ListNode(2); ptr = ptr.next;
        ptr.next = new ListNode(1); ptr = ptr.next;
        ptr.next = loopBack;
        System.out.println(s.hasCycle(head));
        ptr = head = new ListNode(5);
        ptr.next = new ListNode(4); ptr = ptr.next;
        ptr.next = new ListNode(3); ptr = ptr.next;
        ptr.next = new ListNode(2); ptr = ptr.next;
        ptr.next = new ListNode(1); ptr = ptr.next;
        System.out.println(s.hasCycle(head));
    }

}