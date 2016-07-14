package intersectionOfTwoArrays;

public class Client {

	private static void prt(int[] nums1, int[] nums2) {
		ISolution s = new Solution();
		
		int[] ans = s.intersection(nums1, nums2);
		for (int i : ans) {
			System.out.println(i);
		}
		System.out.println("Tested");
	}
	public static void main(String[] args) {
		int[] nums1 = new int[] {5,3,7,9,1,3,5,5,3,11};
		int[] nums2 = new int[] {2,4,1,4,2,6,3,1,6,4};		
		prt(nums1, nums2);
		nums1 = new int[] {};
		nums2 = new int[] {};		
		prt(nums1, nums2);
		nums1 = new int[] {1};
		nums2 = new int[] {};		
		prt(nums1, nums2);
		nums1 = new int[] {};
		nums2 = new int[] {1};		
		prt(nums1, nums2);
	}

}
