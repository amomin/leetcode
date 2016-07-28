package sortList;

public class Swap {

	private ListNode bh, bi, bj;
	
	// bh points to the list
	// bi points to the element to swap
	// bj points to the other element to swap
	// assume i -> ... -> j
	public Swap(ListNode bh, ListNode bi, ListNode bj) {
		this.bh = bh;
		this.bi = bi;
		this.bj = bj;
	}
	
	public void swap() {
		ListNode ni, nj;
		nj = new ListNode(bi.next.val); //i.val
		ni = new ListNode(bj.next.val); //j.val
		// bi -> ni -> nj -> bj.next.next
		if (bi.next == bj) {
			nj.next = bj.next.next;
			ni.next = nj;
			bi.next = ni;
			bj = ni;
			return;
		}
		nj.next = bj.next.next;
		ni.next = bi.next.next;
		bi.next = ni;
		bj.next = nj;
	}
	
	public ListNode bh() {
		return bh;
	}
	public ListNode bi() {
		return bi;
	}
	public ListNode bj() {
		return bj;
	}
	
	public static void tst(int[] arr, int i, int j) {
		Helpers.printIntArr(arr);
		System.out.printf("Swap entries %d, %d %n", i, j);
		ListNode list, bh, bi, bj;
		bh = new ListNode(0);
		list = ListNode.fromArr(arr);
		bh.next = list;
		bi = bh;
		bj = bh;
		for (int k = 0; k < arr.length; k++) {
			if (k < i) bi = bi.next;
			if (k < j) bj = bj.next;
		}

		Swap s = new Swap(bh, bi, bj);
		s.swap();
		bh = s.bh();
		bi = s.bi();
		bj = s.bj();

		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

		if (bi.next.val != arr[i])
			System.out.printf("Test failed on index i: %d != %d %n", i, bi.next.val, arr[i]);
		if (bj.next.val != arr[j])
			System.out.printf("Test failed on index j: %d != %d %n", i, bj.next.val, arr[j]);
		ListNode current = bh.next;
		for (int k = 0; k < arr.length; k++) {
			int v1 = arr[k];
			int v2 = current.val;
			if (v1 != v2) {
				System.out.printf("Test failed on index i = %d: %d != %d", i, v1, v2);
			}
			current = current.next;
		}
		//printIntArr(arr);
		System.out.printf("List: (%d,%d) -> (%d, %d) %n", i, j, bi.next.val, bj.next.val);
		bh.next.prt();
	}
	
	public static void main(String[] args) {
		tst(new int[] {1, 2, 3}, 0, 1);
		tst(new int[] {1, 2, 3}, 1, 2);
		tst(new int[] {1, 2, 3}, 0, 2);
//		tst(new int[] {1, 3, 2}, 0, 1);
//		tst(new int[] {2, 1, 3}, 0, 1);
//		tst(new int[] {2, 3, 1}, 0, 1);
//		tst(new int[] {3, 1, 2}, 0, 1);
//		tst(new int[] {3, 2, 1}, 0, 1);
		tst(new int[] {1, 2, 3, 4}, 0, 1);
		tst(new int[] {1, 2, 3, 4}, 0, 2);
		tst(new int[] {1, 2, 3, 4}, 0, 3);
		tst(new int[] {1, 2, 3, 4}, 1, 2);
		tst(new int[] {1, 2, 3, 4}, 1, 3);
		tst(new int[] {1, 2, 3, 4}, 2, 3);
	}
}
