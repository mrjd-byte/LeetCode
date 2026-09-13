class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroCnt = 0;
        int maxLength = 0;
        while (right < nums.length && left <= right) {
            if (nums[right] == 0) {
                zeroCnt++;
            }
            while (zeroCnt > k) {
                if (nums[left] == 0) {
                    zeroCnt--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}