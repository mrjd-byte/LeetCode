class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;

        List<Integer> temp = new ArrayList<>();
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                temp.add(nums1[left]);
                left++;
            } else {
                temp.add(nums2[right]);
                right++;
            }
        }
        while (left < m) {
            temp.add(nums1[left]);
            left++;
        }
        while (right < n) {
            temp.add(nums2[right]);
            right++;
        }
        
        for (int i = 0; i < temp.size(); i++) {
            nums1[i] = temp.get(i);
        }
    }
}