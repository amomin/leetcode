package sortList;

public class SolutionWithFilterSort {

    public ListNode sortList(ListNode head) {
    	if (head == null) return head;
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        FilterSort fs = new FilterSort(head, tail);
        fs.sort();
        head = fs.h;
        return head;
    }
	
	class FilterSort {

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
	}
	
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
	}

}
