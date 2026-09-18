class Solution {
    public int atMost(int[] nums,int k) {
       if (k < 0) {
        return 0;
       } 
       int left = 0;
       int right = 0;
       int distinct = 0;
       int count = 0;
       HashMap<Integer, Integer> freq = new HashMap<>();

       while (right < nums.length) {
        if (!freq.containsKey(nums[right])) {
            distinct++;
        }
        freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

        while (distinct > k) {
            freq.put(nums[left], freq.get(nums[left]) - 1);
            if (freq.get(nums[left]) == 0) {
                freq.remove(nums[left]);
                distinct--;
            }
            left++;
        } 
        count += right - left + 1;
        right++;
       }
       return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}