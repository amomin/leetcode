package sortList;

import java.util.Arrays;

public class QuickSortSolution {
		
	public ListNode sortList(ListNode head) {
		if (head == null) return head;
		ListNode headPointer = new ListNode(0);
		headPointer.next = head;
		ListNode tailPointer = headPointer;
		while (tailPointer.next.next != null) tailPointer = tailPointer.next;
		
		LinkedQuickSort s = new LinkedQuickSort(headPointer, tailPointer);
		s.sort();
		headPointer = s.bh;
		return headPointer.next;
	}

	public class LinkedQuickSort {

		public ListNode bh, be;
		public LinkedQuickSort(ListNode bh, ListNode be) {
			this.bh = bh;
			this.be = be;
		}
			
		public void sort() {
			LomutoPartition p;
			ListNode bp;
			LinkedQuickSort q1, q2;
			
			if (bh == be) return;
			p = new LomutoPartition(bh, be);
			p.partition();
			bp = p.bp;
			bh = p.bh;
			be = p.be;
			if (bh.next == be) {
				return;
			}
			// Sort right half
			if (bp != be) {
				q2 = new LinkedQuickSort(bp.next, be); // p before head of next list
				q2.sort();
				bp.next = q2.bh;
				be = q2.be;
			}
			if (bp != bh) {
				ListNode piv = bp.next;
				ListNode bbp = bh;
				while (bbp.next != bp) bbp = bbp.next;
				if (bh != bbp) {
					q1 = new LinkedQuickSort(bh, bbp);
					q1.sort();
					bh = q1.bh;
					bbp = q1.be;
				}
				bbp.next.next = piv;
				piv.next = bp.next.next;			
			}
		}
	}	

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
	}

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
	}	

	
	public static void tst(int[] arr) {
		System.out.println("*********** Test started ****************");
		if (arr.length < 20) Helpers.printIntArr(arr);
		ListNode list = ListNode.fromArr(arr);
		QuickSortSolution s = new QuickSortSolution();
		list = s.sortList(list);
		ListNode ptr = list;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] != ptr.val) {
				System.out.printf("error at %d: %d != %d %n", i, ptr.val, arr[i]);
			}
			ptr = ptr.next;
		}
		if (arr.length < 20) {
			Helpers.printIntArr(arr);
			list.prt();
		} else {
			System.out.println("If not messages test was successful.");
			
		}
		System.out.println("*********** Test complete ****************");
	}
	
	public static void main(String[] args) {
		//tst(new int[] {});
		tst(new int[] {1});
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
		tst(Helpers.randInt(1000000, 30000));
		tst(Helpers.incrArr(1000000, true));
		tst(Helpers.incrArr(1000000, false));
	}
}
