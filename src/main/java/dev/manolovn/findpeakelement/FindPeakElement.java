package dev.manolovn.findpeakelement;

/**
 * source: https://leetcode.com/problems/find-peak-element/
 * difficulty: MEDIUM
 * topic: BINARY SEARCH
 */
public class FindPeakElement {

    /*
    [1,2,1,3,5,6,4]

    t: O(log2n)
    s: O(log2n)
    */
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int lo, int hi) {
        if (lo == hi) return hi;
        int mid = (lo + hi) / 2;
        if (nums[mid] < nums[mid + 1])
            return binarySearch(nums, mid + 1, hi);
        return binarySearch(nums, lo, mid);
    }

    /**
     * Alternative solution with improved space complexity
     * Time:  O(log2n)
     * Space: O(1)
     */
    public int findPeakElement_alt(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < nums[mid + 1])
                lo = mid + 1;
            else hi = mid;
        }
        return hi;
    }
}
