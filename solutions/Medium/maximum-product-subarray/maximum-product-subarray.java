class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            ans = Math.max(ans, num);
        }

        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {
            int product = curMax * num;
            curMax = Math.max(product, Math.max(curMin * num, num));
            curMin = Math.min(product, Math.min(curMin * num, num));

            ans = Math.max(ans, curMax);
        }
        return ans;
    }
}