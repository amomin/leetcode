package sortList;

class Filter {
	public ListNode lh, lt, gh, gt, eh, et;
	
	public Filter(ListNode oh, ListNode ot, int val) {
		ListNode curr = oh;
		lh = lt = gh = gt = eh = et = null;
		// Make sure curr = ot as well:
		while (curr != ot.next) {
			if (curr.val < val) {
				if (lh == null) {
					lh = curr;
					lt = lh;
				} else {
					// lh and lt not null
					lt.next = curr;
					lt = lt.next;
				}
			} else if (curr.val > val) {
				if (gh == null) {
					gh = curr;
					gt = gh;
				} else {
					// gh and gt not null
					gt.next = curr;
					gt = gt.next;
				}					
			} else {
				if (eh == null) {
					eh = curr;
					et = eh;
				} else {
					// eh and et not null
					et.next = curr;
					et = et.next;
				}
			}
			curr = curr.next;
		}
		if (lt != null) lt.next = null;
		if (et != null) et.next = null;
		if (gt != null) gt.next = null;
	}

	public static void tst(int[] arr, int val) {
		ListNode list = ListNode.fromArr(arr);
		ListNode tail = list;
		while (tail.next != null) tail = tail.next;
		System.out.printf("Testing filter on value %d:%n", val);
		list.prt();
		Filter f = new Filter(list, tail, val);
		ListNode lh, lt, eh, et, gh, gt;
		lh = f.lh;
		eh = f.eh;
		gh = f.gh;
		lt = f.lt;
		et = f.et;
		gt = f.gt;
		System.out.println("Less:");
		if (lh != null) { lh.prt(); lt.prt(); }
		System.out.println("Equal:");
		if (eh != null) { eh.prt(); et.prt(); }
		System.out.println("Greater:");
		if (gh != null) { gh.prt(); gt.prt(); }
		
	}
	public static void tst(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		for (int k = 0; k <= n + 1; k++) {
			tst(arr, k);
		}
	}
	public static void main(String[] args) {
		tst(3);
		tst(10);
	}
	
}
