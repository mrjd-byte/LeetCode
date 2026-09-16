class Solution {
    public int atmostSum(int[] arr, int goal) {
        if (goal == -1) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int ans = 0;
        for(int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > goal) {
                sum -= arr[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmostSum(nums, goal) - atmostSum(nums, goal - 1);
    }
}