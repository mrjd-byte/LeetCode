class Solution {
    public int countAtMost(int[] arr, int k) {
        int left = 0;
        int ans = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] % 2 != 0) {
                k--;
            }

            while (k < 0){
                if (arr[left] % 2 != 0) {
                    k++;
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }
}