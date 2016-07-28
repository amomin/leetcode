package sortList;

public class LomutoPartition {

	public ListNode bh;
	public ListNode be;
	public ListNode bp;

	public LomutoPartition(ListNode bh, ListNode be) {
		this.bh = bh;
		this.be = be;
		this.bp = null;
	}

	public ListNode selectPivot() {
		ListNode curr = bh;
		ListNode mid = curr;
		double i = 1;
		while(curr.next != be.next) {
			if (Math.random() < 1 / i) {
				mid = curr;
			}
			curr = curr.next;
			i = i + 1;
		}
		// Completely random instead of median of 3 for now
		return mid;
	}

	
	// Invariants:
	// for x < bi.next, val < pivot
	// for bi.next <= x < bj.next, val >= pivot
	// end of loop bj.next = j = last
	public void partition() {
		// Select a new pivot value to 
		// avoid problems with ordering
		{
			ListNode bp = selectPivot();
			Swap s = new Swap(bh, bp, be);
			s.swap();
			bh = s.bh();
			bp = s.bi();
			be = s.bj();			
		}
		// This still does not solve the dutch-flag issue
		int pivot = be.next.val;
		ListNode bi = bh;
		ListNode bj = bi;
		boolean flag = false;
		while (bj.next != be.next) {
			if (bj.next.val < pivot) {
				if (bi != bj) {
					if (bj.next == be) {
						flag = true;
					}
					Swap s = new Swap(bh, bi, bj);
					s.swap();
					bh = s.bh();
					bi = s.bi();
					bj = s.bj();
					if (flag) be = bj.next;
				}
				bi = bi.next;
			}
			bj = bj.next;
		}
		Swap s = new Swap(bh, bi, be);
		s.swap();
		bh = s.bh();
		bi = s.bi();
		be = s.bj();
		this.bp = bi;
	}
		
	public static void tst(int[] arr) {
		System.out.println("***************** STARTED **********************");
		System.out.printf("Partition: ");
		if (arr.length < 10) Helpers.printIntArr(arr);
		ListNode list, bh, bp, be;
		list = ListNode.fromArr(arr);
		bh = new ListNode(0);
		bh.next = list;
		be = bh;
		while (be.next.next != null) be = be.next;
		LomutoPartition p = new LomutoPartition(bh, be);
		p.partition();
		bh = p.bh;
		be = p.be;
		bp = p.bp;
		System.out.printf("Partitioning about: %d %n", bp.next.val);
		{
			boolean beforePivot = true;
			for (ListNode c = bh; c != be; c = c.next) {
				if (c == bp) {
					beforePivot = false;
				}
				if (beforePivot) {
					if (c.next.val > bp.next.val) System.out.println("ERROR BEFORE PIVOT");
				} else {
					if (c.next.val < bp.next.val) System.out.println("ERROR BEFORE PIVOT");					
				}
			}
			
		}
		if (arr.length < 10) bh.next.prt();
		System.out.println("**************** COMPLETE ***********************");
	}
	
	public static void main (String[] args) {
		tst(new int[] {1, 2});
		tst(new int[] {2, 1});
		tst(new int[] {1, 2, 3});
		tst(new int[] {1, 3, 2});
		tst(new int[] {2, 1, 3});
		tst(new int[] {2, 3, 1});
		tst(new int[] {3, 1, 2});
		tst(new int[] {3, 2, 1});
		tst(new int[] {1, 2, 3, 4});
		tst(new int[] {1, 2, 4, 3});
		tst(new int[] {1, 3, 2, 4});
		tst(new int[] {1, 3, 4, 2});
		tst(new int[] {1, 4, 2, 3});
		tst(new int[] {1, 4, 3, 2});
		tst(Helpers.incrArr(10000000, true));
		tst(Helpers.incrArr(10000000, false));
		
	}
}
