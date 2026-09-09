class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); 
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentIndex = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[currentIndex]) {
                stack.pop();
            }            
            if (i < n && !stack.isEmpty()) {
                result[currentIndex] = nums[stack.peek()];
            }
            
            stack.push(currentIndex);
        }
        
        return result;
    }
}
