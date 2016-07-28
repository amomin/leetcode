package sortList;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	public void prt() {
		ListNode that = this;
		System.out.printf("%d", val);
		while (that.next != null) {
			that = that.next;
			System.out.printf(", %d", that.val);
		}
		System.out.printf("%n");
	}
	
	public static ListNode fromArr(int[] arr) {
		ListNode head;
		head = new ListNode(arr[arr.length - 1]);
		for (int i = arr.length - 1; i-- > 0; ) {
			ListNode tmp = head;
			head = new ListNode(arr[i]);
			head.next = tmp;
		}
		return head;
	}
	
}
