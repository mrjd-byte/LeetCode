class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combine = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                combine[k] = nums1[i];
                k++;
                i++;
            } else {
                combine[k] = nums2[j];
                k++;
                j++;
            }
        }

        while (i < nums1.length) {
            combine[k] = nums1[i];
            k++;
            i++;
        }

        while (j < nums2.length) {
            combine[k] = nums2[j];
            k++;
            j++;
        }
        int n = combine.length;

        if (n % 2 == 0) {
            int mid = n / 2;
            return (double) (combine[mid - 1] + combine[mid]) / 2;
        } else {
            return combine[n / 2];
        }
    }
}