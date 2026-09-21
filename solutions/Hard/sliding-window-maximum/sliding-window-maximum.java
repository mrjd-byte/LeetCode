class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int ansIndex = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && queue.peekFirst() < left) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
                queue.pollLast();
            }
            queue.offerLast(right);

            if (right - left + 1 == k) {
                ans[ansIndex] = nums[queue.peekFirst()];
                ansIndex++;
                left++;
            }
            
        }
        return ans;
    }
}