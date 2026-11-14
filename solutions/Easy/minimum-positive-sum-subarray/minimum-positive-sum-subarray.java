class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        for (int left = 0; left < n; left++) {
            
            for (int len = l; len <= r; len++) {

                int right = left + len - 1;

                if (right >= n) {
                    break;
                }
                int sum = prefix[right + 1] - prefix[left];

                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}