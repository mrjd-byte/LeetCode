class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;

        while (left <= right && right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (len == Integer.MAX_VALUE) {
            return 0;
        }
        return len;
    }
}