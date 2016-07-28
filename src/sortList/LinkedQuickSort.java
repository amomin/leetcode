package sortList;

import java.util.Arrays;

/** with a good partition this would be ok if we randomize, but using
 * Lomuto partition which is bad if the number of values is small.
 * 
 * @author user
 *
 */
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
	
	public static void tst(int[] arr) {
		System.out.println("*********** Test started ****************");
		if (arr.length < 20) Helpers.printIntArr(arr);
		ListNode g, h, be, e;
		g = new ListNode(0);
		g.next = ListNode.fromArr(arr);
		h = g.next;
		be = g;
		while (be.next.next != null) be = be.next;
		e = be.next;
		//g.prt(); be.prt();
		LinkedQuickSort lqs = new LinkedQuickSort(g, be);
		lqs.sort();
		g = lqs.bh;
		be = lqs.be;
		Arrays.sort(arr);
		ListNode ptr = g;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] != ptr.next.val) {
				System.out.printf("error at %d: %d != %d %n", i, ptr.next.val, arr[i]);
			}
			ptr = ptr.next;
		}
		if (arr.length < 20) {
			Helpers.printIntArr(arr);
			g.prt();
		} else {
			System.out.println("If not messages test was successful.");
			
		}
		System.out.println("*********** Test complete ****************");
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
		tst(Helpers.randInt(1000000, 30000));
		tst(Helpers.incrArr(1000000, true));
		tst(Helpers.incrArr(1000000, false));
	}
}
