class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        long prefixSum = 0;
        int evenCount = 1;
        int oddCount = 0;
        long ans = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                ans = (ans + oddCount) % MOD;
                evenCount++;
            } else {
                ans = (ans + evenCount) % MOD;
                oddCount++;
            }
        }
        return (int) ans;
    }
}