class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increase = 1;
        int decrease = 1;
        int ans = 1;

        for (int num = 0; num < nums.length - 1; num++) {
            if (nums[num + 1] > nums[num]) {
                increase++;
                decrease = 1;
            } else if (nums[num + 1] < nums[num]){
                decrease++;
                increase = 1;
            } else {
                increase = 1;
                decrease = 1;
            }
            ans = Math.max(ans, Math.max(increase, decrease));
        }
        return ans;
    }
}