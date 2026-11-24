class Solution {
    public boolean check(int[] nums, int maxSum, int k) {
        int subarrayCount = 1;
        int sumOfSubarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sumOfSubarray + nums[i] <= maxSum) {
                sumOfSubarray += nums[i];
            } else {
                subarrayCount++;
                sumOfSubarray = nums[i];
            }
        }
        return (subarrayCount <= k);
    }
    public int splitArray(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        int arraySum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            arraySum += num;
        }

        int ans = 0;

        int left = maxNum;
        int right = arraySum;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}