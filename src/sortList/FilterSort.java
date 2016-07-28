package sortList;

import java.util.Arrays;

public class FilterSort {

	ListNode h, t;

	public FilterSort(ListNode list, ListNode tail) {
		h = list;
		t = tail;
	}
		
	public int getPivotValue() {
		int head = h.val;
		int rand = head;
		int tail = t.val;
		
		ListNode mid = h;
		int i = 1;
		while (mid != t) {
			double prob = (1 / (double) i);
			if (Math.random() < prob) {
				rand = mid.val;
			}
			i++;
			mid = mid.next;
		}
		
		//System.out.printf("pivot from %d %d %d %n", head, rand, tail);
		if (rand < head && head < tail) return head;
		if (tail < head && head < rand) return head;
		if (head < rand && rand < tail) return rand;
		if (tail < rand && rand < head) return rand;
		if (head < tail && tail < rand) return tail;
		if (rand < tail && tail < head) return tail;
		return head;
	}
	
	public void sort() {
		if (h == null) return;
		if (h == t)   return;
				
		ListNode nh, nt, lh, lt, gh, gt, eh, et;
		nh = nt = null;
		
		// Filter into three lists < pivot, == pivot, > pivot
		int pivot = getPivotValue();
		Filter f = new Filter(h, t, pivot);
		lh = f.lh; lt = f.lt; eh = f.eh; et=f.et; gh = f.gh; gt = f.gt;		
		
		if (lh != null) {
			if (lh != lt) {
				FilterSort fs = new FilterSort(lh, lt);
				fs.sort();
				lh = fs.h;
				lt = fs.t;
			}
			nh = lh;
			nt = lt;
		}
		if (eh != null) {
			if (nh == null) {
				nh = eh;
				nt = et;
			} else {
				// nt != null since nh != null
				// point from end of < list to head of = list
				nt.next = eh;
				nt = et;
			}
		}
		if (gh != null) {
			if (gh != gt) {
				FilterSort fs = new FilterSort(gh, gt);
				fs.sort();
				gh = fs.h;
				gt = fs.t;
			}
			if (nh == null) {
				nh = gh;
				nt = gt;
			} else {
				nt.next = gh;
				nt = gt;				
			}
		}
		h = nh;
		t = nt;
		return;
	}
	
	public static void tst(int[] arr) {
		System.out.println("**********************");
		if (arr.length < 20) Helpers.printIntArr(arr);
		
		ListNode list = ListNode.fromArr(arr);
		long t = System.currentTimeMillis();
		ListNode tail = list;
		while (tail.next != null) tail = tail.next;		
		FilterSort fs = new FilterSort(list, tail);
		fs.sort();
		list = fs.h;
		t = System.currentTimeMillis() - t;

		Arrays.sort(arr);
		ListNode ptr = list;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] != ptr.val) {
				System.out.printf("error at %d: %d != %d %n", i, ptr.val, arr[i]);
			}
			ptr = ptr.next;
		}
		if (arr.length < 20) {
			Helpers.printIntArr(arr);
			list.prt();
		}
		System.out.printf("Test complete in %dms %n", t);
		long n = arr.length;
		System.out.printf("t/nlogn = %d %n", (10000000 * t) / ( (long) (n * Math.log(n)) )  );
		System.out.println("**********************");
	}
			
	public static void main(String[] args) {
		tst(new int[] {1,2});
		tst(new int[] {2,1});
		tst(new int[] {1,2,3});
		tst(new int[] {1,3,2});
		tst(new int[] {2,1,3});
		tst(new int[] {2,3,1});
		tst(new int[] {3,1,2});
		tst(new int[] {3,2,1});
		tst(new int[] {1,2,3,4});
		tst(new int[] {1,3,2,4});
		tst(new int[] {2,1,3,4});
		tst(Helpers.randInt( 100000, 100));
		tst(Helpers.randInt( 400000, 100));
		tst(Helpers.randInt(1600000, 100));
		tst(Helpers.randInt( 100000, 1000000000));
		tst(Helpers.randInt( 400000, 1000000000));
		tst(Helpers.randInt(1600000, 1000000000));
		tst(Helpers.incrArr( 100000, true));
		tst(Helpers.incrArr( 400000, true));
		tst(Helpers.incrArr(1600000, true));
		tst(Helpers.incrArr( 100000, false));
		tst(Helpers.incrArr( 400000, false));
		tst(Helpers.incrArr(1600000, false));
	}
}
